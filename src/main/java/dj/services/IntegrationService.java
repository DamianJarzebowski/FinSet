package dj.services;

import dj.dto.integration.EndUserAgreementData;
import dj.dto.integration.IntegrationForm;
import dj.dto.integration.bank.Bank;
import dj.dto.integration.build_a_link.DataForCreateConnection;
import dj.dto.integration.build_a_link.ResponseEndingIntegration;
import dj.dto.integration.secrets.Secrets;
import dj.dto.integration.secrets.token.Tokens;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IntegrationService {

    public Tokens getTokens(Secrets secrets) {

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

    public List<Bank> getListBanks(String country, String accessToken) {

        WebClient webClient = WebClient.create("https://ob.nordigen.com");

        Mono<List<Bank>> banks = webClient.get()
                .uri("/api/v2/institutions/?country=" + country)
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    httpHeaders.setBearerAuth(accessToken);
                })
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Bank>>() {
                });

        return banks.block();
    }

    public EndUserAgreementData createEndUserAgreement(IntegrationForm integrationForm, Secrets secrets) {

        Tokens tokens = getTokens(secrets);

        WebClient webClient = WebClient.create("https://ob.nordigen.com");

        Mono<EndUserAgreementData> endUserAgreementData = webClient.post()
                .uri("/api/v2/agreements/enduser/")
                .headers(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    httpHeaders.setBearerAuth(tokens.getAccess());
                })
                .body(Mono.just(integrationForm), IntegrationForm.class)
                .retrieve()
                .bodyToMono(EndUserAgreementData.class);

        return endUserAgreementData.block();
    }

    public ResponseEndingIntegration createConnection(IntegrationForm integrationForm, Secrets secrets) {

        Tokens tokens = getTokens(secrets);

        EndUserAgreementData endUserAgreementData = createEndUserAgreement(integrationForm, secrets);

        WebClient webClient = WebClient.create("https://ob.nordigen.com");

        // Have to build automatic reference numeric and change redirect url to us site
        // Have to decide with Slavik what to do with user language :
        // user_language to enforce a language for all end user steps hosted by Nordigen passed
        // as a two-letter country code (ISO 639-1). If user_language is not defined a language set in browser will be used to determine language.

        Mono<ResponseEndingIntegration> responseWithBankLink = webClient.post()
                .uri("/api/v2/requisitions/")
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    httpHeaders.setBearerAuth(tokens.getAccess());
                })
                .body(Mono.just(new DataForCreateConnection()
                        .setRedirect("http://localhost:8080/swagger-ui.html#/integration")
                        .setInstitutionId(endUserAgreementData.getInstitutionId())
                        .setReference("1")
                        .setAgreement(endUserAgreementData.getId())
                        .setUserLanguage("PL")), DataForCreateConnection.class)
                .retrieve()
                .bodyToMono(ResponseEndingIntegration.class);

        return responseWithBankLink.block();
    }
}
