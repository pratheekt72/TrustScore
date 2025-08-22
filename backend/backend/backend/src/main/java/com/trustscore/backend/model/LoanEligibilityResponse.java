package com.trustscore.backend.model;

import java.util.Map;

public class LoanEligibilityResponse {
    private boolean eligible;
    private String message;
    private double maxLoanAmount;

    // Extra metrics you can show on the UI (e.g., dti, thresholds, bucket)
    private Map<String, Object> metrics;

    public LoanEligibilityResponse() {}

    public LoanEligibilityResponse(boolean eligible, String message, double maxLoanAmount, Map<String, Object> metrics) {
        this.eligible = eligible;
        this.message = message;
        this.maxLoanAmount = maxLoanAmount;
        this.metrics = metrics;
    }

    public boolean isEligible() { return eligible; }
    public void setEligible(boolean eligible) { this.eligible = eligible; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public double getMaxLoanAmount() { return maxLoanAmount; }
    public void setMaxLoanAmount(double maxLoanAmount) { this.maxLoanAmount = maxLoanAmount; }

    public Map<String, Object> getMetrics() { return metrics; }
    public void setMetrics(Map<String, Object> metrics) { this.metrics = metrics; }
}
