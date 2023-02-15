package dj.api;

import dj.dto.integration.bank.Bank;
import dj.dto.integration.secrets.Secrets;
import dj.dto.integration.token.Tokens;
import dj.services.IntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/integration")
public class Integration {

    private final IntegrationService integrationService;

    @PostMapping("/tokens")
    public ResponseEntity<Tokens> getTokens(@RequestBody Secrets secrets) {
        return ResponseEntity.ok(integrationService.getTokens(secrets));
    }

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getBankList(@RequestParam String country, @RequestParam String accessToken) {
        return ResponseEntity.ok(integrationService.getListBanks(country, accessToken));
    }

}
