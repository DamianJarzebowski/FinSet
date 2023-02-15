package dj.api;

import dj.dto.integration.IntegrationForm;
import dj.dto.integration.bank.Bank;
import dj.dto.integration.build_a_link.ResponseEndingIntegration;
import dj.dto.integration.secrets.Secrets;
import dj.dto.integration.secrets.token.Tokens;
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
    public ResponseEntity<Tokens> createTokens(@RequestBody Secrets secrets) {
        return ResponseEntity.ok(integrationService.getTokens(secrets));
    }

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getBankList(@RequestParam String country, @RequestParam String accessToken) {
        return ResponseEntity.ok(integrationService.getListBanks(country, accessToken));
    }

    @PostMapping("/createConnection")
    public ResponseEntity<ResponseEndingIntegration> createConnection(@RequestBody IntegrationForm integrationForm, @RequestBody Secrets secrets) {
        return ResponseEntity.ok(integrationService.createConnection(integrationForm, secrets));
    }


}
