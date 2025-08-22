package com.trustscore.backend.controller;

import com.trustscore.backend.model.LoanEligibilityRequest;
import com.trustscore.backend.model.LoanEligibilityResponse;
import com.trustscore.backend.service.LoanEligibilityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
@CrossOrigin(origins = "*") // adjust to your frontend origin if you want tighter CORS
public class LoanEligibilityController {

    private final LoanEligibilityService eligibilityService;

    public LoanEligibilityController(LoanEligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
    }

    @PostMapping("/evaluate")
    public ResponseEntity<LoanEligibilityResponse> evaluate(@Valid @RequestBody LoanEligibilityRequest request) {
        LoanEligibilityResponse resp = eligibilityService.evaluate(request);
        return ResponseEntity.ok(resp);
    }

    // Simple health check / doc hint
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("eligibility OK");
    }
}
