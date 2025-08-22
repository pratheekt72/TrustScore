package com.trustscore.backend.service;

import com.trustscore.backend.model.LoanEligibilityRequest;
import com.trustscore.backend.model.LoanEligibilityResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class LoanEligibilityService {

    // Tunable policy knobs
    private static final int MIN_CREDIT_SCORE = 620;
    private static final double MAX_DTI = 0.40;               // 40% Debt-to-Income cap
    private static final double MIN_ANNUAL_INCOME = 20000.0;  // Basic income floor

    public LoanEligibilityResponse evaluate(LoanEligibilityRequest req) {
        // Derived metrics
        double monthlyIncome = req.getAnnualIncome() / 12.0;
        double dti = (monthlyIncome == 0) ? 1.0 : req.getMonthlyDebt() / monthlyIncome;

        // Score bucket determines generosity multiplier
        double scoreMultiplier = scoreToMultiplier(req.getCreditScore());

        // Base capacity by income less debt (simple, conservative heuristic)
        // Example cap: up to a portion of annual income, with debt headroom.
        double incomeCap = req.getAnnualIncome() * 0.35;
        double debtPenalty = req.getMonthlyDebt() * 12.0;
        double rawMax = Math.max(0.0, incomeCap - debtPenalty);

        // Adjust by score bucket (better score = more allowance)
        double maxLoanAmount = rawMax * scoreMultiplier;

        // Employment adjustment
        switch (req.getEmploymentStatus()) {
            case UNEMPLOYED -> maxLoanAmount *= 0.5;
            case STUDENT -> maxLoanAmount *= 0.7;
            case CONTRACT -> maxLoanAmount *= 0.9;
            default -> { /* EMPLOYED / SELF_EMPLOYED keep as-is */ }
        }

        // Round to nearest hundred for nicer UX
        maxLoanAmount = Math.floor(maxLoanAmount / 100.0) * 100.0;

        // Decision rules
        boolean eligible = true;
        StringJoiner reasons = new StringJoiner("; ");

        if (req.getCreditScore() < MIN_CREDIT_SCORE) {
            eligible = false;
            reasons.add("Credit score below " + MIN_CREDIT_SCORE);
        }
        if (req.getAnnualIncome() < MIN_ANNUAL_INCOME) {
            eligible = false;
            reasons.add("Annual income below $" + (int) MIN_ANNUAL_INCOME);
        }
        if (dti > MAX_DTI) {
            eligible = false;
            reasons.add("Debt-to-Income (DTI) exceeds " + (int) (MAX_DTI * 100) + "%");
        }
        if (maxLoanAmount <= 0) {
            eligible = false;
            reasons.add("Calculated capacity is zero based on income/debt");
        }
        if (eligible && req.getRequestedAmount() > maxLoanAmount) {
            // Still eligible, but requested amount is too high — suggest a lower number
            reasons.add("Requested amount exceeds approved maximum; consider requesting $" + (long) maxLoanAmount);
        }

        String message = eligible
                ? (reasons.toString().isBlank()
                    ? "Eligible based on current profile."
                    : "Eligible with notes: " + reasons)
                : ("Not eligible: " + reasons);

        Map<String, Object> metrics = new HashMap<>();
        metrics.put("dti", round2(dti));
        metrics.put("monthlyIncome", round2(monthlyIncome));
        metrics.put("scoreMultiplier", scoreMultiplier);
        metrics.put("thresholds", Map.of(
                "minCreditScore", MIN_CREDIT_SCORE,
                "maxDTI", MAX_DTI,
                "minAnnualIncome", MIN_ANNUAL_INCOME
        ));
        metrics.put("requestedAmount", req.getRequestedAmount());
        metrics.put("employmentStatus", req.getEmploymentStatus().name());

        return new LoanEligibilityResponse(eligible, message, maxLoanAmount, metrics);
    }

    private static double scoreToMultiplier(int score) {
        if (score >= 800) return 0.60;
        if (score >= 740) return 0.50;
        if (score >= 680) return 0.40;
        if (score >= 620) return 0.30;
        return 0.0;
        // <620 is handled as ineligible elsewhere, multiplier 0 here just zeroes capacity.
    }

    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
