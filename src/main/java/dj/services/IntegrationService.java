package dj.services;

import com.sun.xml.bind.v2.model.core.TypeRef;
import dj.dto.integration.bank.Bank;
import dj.dto.integration.secrets.Secrets;
import dj.dto.integration.token.Tokens;
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




}
