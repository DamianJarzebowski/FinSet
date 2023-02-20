package dj.services;

import dj.dto.integration.bank.Bank;
import dj.dto.integration.secrets.Secrets;
import dj.dto.integration.secrets.token.Tokens;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(value = "integration", url = "https://ob.nordigen.com")
@Headers({"accept: application/json"})
public interface IntegrationClient {

    @Headers("Content-Type: application/json")
    @PostMapping(value = "/api/v2/token/new/")
    Tokens createTokens(Secrets secrets);

    @GetMapping(value = "/api/v2/institutions/?country={country}")
    List<Bank> getBankList(@RequestHeader("Authorization") String accessToken, @PathVariable("country") String country);

}


