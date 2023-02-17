package dj.services;

import dj.dto.integration.AgreementData;
import dj.dto.integration.IntegrationForm;
import dj.dto.integration.bank.Bank;
import dj.dto.integration.build_a_link.DataForCreateConnection;
import dj.dto.integration.build_a_link.ResponseEndingIntegration;
import dj.dto.integration.secrets.Secrets;
import dj.dto.integration.secrets.token.Tokens;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IntegrationService {

    @Value("${NORDIGEN_SECRET_KEY}")
    private String secretKey;

    @Value("${NORDIGEN_SECRET_ID}")
    private String secretId;

    private Tokens getTokens(Secrets secrets) {

        WebClient webClient = WebClient.create("https://ob.nordigen.com");

        Mono<Tokens> tokens = webClient.post()
                .uri("/api/v2/token/new/")
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                })
                .body(Mono.just(secrets), Secrets.class)
                .retrieve()
                .bodyToMono(Tokens.class);

        return tokens.block();
    }

    public List<Bank> getListBanks(String country) {

        Tokens tokens = getTokens(new Secrets()
                .setSecretId(secretId)
                .setSecretKey(secretKey));

        WebClient webClient = WebClient.create("https://ob.nordigen.com");

        Mono<List<Bank>> banks = webClient.get()
                .uri("/api/v2/institutions/?country=" + country)
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    httpHeaders.setBearerAuth(tokens.getAccess());
                })
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Bank>>() {
                });

        return banks.block();
    }

    // We will not use default settings for user agreement and set our own, need only to user give us bank id which have to be connected
    // setMaxHistoricalDays = 90
    // setAccessValidForDays = 30
    // setAccessScope = "balances", "details", "transactions"
    public AgreementData createAgreement(String institutionId, Tokens tokens) {

        WebClient webClient = WebClient.create("https://ob.nordigen.com");

        IntegrationForm integrationForm = new IntegrationForm()
                .setInstitutionId(institutionId)
                .setMaxHistoricalDays("90")
                .setAccessValidForDays("30")
                .setAccessScope(List.of("balances", "details", "transactions"));

        Mono<AgreementData> agreementData = webClient.post()
                .uri("/api/v2/agreements/enduser/")
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.setBearerAuth(tokens.getAccess());
                })
                .body(Mono.just(integrationForm), IntegrationForm.class)
                .retrieve()
                .bodyToMono(AgreementData.class);

        return agreementData.block();
    }

    // This method set us user agreements and transfers the customer to the bank's website in order to authorize the provision of his bank details to us
    public ResponseEntity<?> createConnection(String institutionId) {

        Tokens tokens = getTokens(new Secrets()
                .setSecretId(secretId)
                .setSecretKey(secretKey));

        AgreementData agreementData = createAgreement(institutionId, tokens);

        WebClient webClient = WebClient.create("https://ob.nordigen.com");

        // Have to build automatic reference numeric and change redirect url to us site
        // Have to decide with Slavik what to do with user language :
        // user_language to enforce a language for all end user steps hosted by Nordigen passed
        // as a two-letter country code (ISO 639-1). If user_language is not defined a language set in browser will be used to determine language.

        ResponseEndingIntegration responseEndingIntegration = webClient.post()
                .uri("/api/v2/requisitions/")
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.setBearerAuth(tokens.getAccess());
                })
                .body(Mono.just(new DataForCreateConnection()
                        .setRedirect("http://localhost:8080/swagger-ui.html#/integration")
                        .setInstitutionId(institutionId)
                        .setReference("2")
                        .setAgreement(agreementData.getId())
                        .setUserLanguage("PL")), DataForCreateConnection.class)
                .retrieve()
                .bodyToMono(ResponseEndingIntegration.class)
                .block();

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(responseEndingIntegration.getLink())).build();
    }
}
