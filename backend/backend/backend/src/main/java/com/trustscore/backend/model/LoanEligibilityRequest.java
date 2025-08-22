package com.trustscore.backend.model;

import jakarta.validation.constraints.*;

public class LoanEligibilityRequest {

    // Optional: if you associate requests to a stored user
    private String userId;

    @Positive(message = "Requested loan amount must be positive.")
    private double requestedAmount;

    @Min(value = 300, message = "Credit score must be between 300 and 850.")
    @Max(value = 850, message = "Credit score must be between 300 and 850.")
    private int creditScore;

    @PositiveOrZero(message = "Monthly debt must not be negative.")
    private double monthlyDebt;

    @Positive(message = "Annual income must be positive.")
    private double annualIncome;

    @NotNull(message = "Employment status is required.")
    private EmploymentStatus employmentStatus;

    public enum EmploymentStatus {
        EMPLOYED, SELF_EMPLOYED, STUDENT, UNEMPLOYED, CONTRACT
    }

    public LoanEligibilityRequest() {}

    // Getters and setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public double getRequestedAmount() { return requestedAmount; }
    public void setRequestedAmount(double requestedAmount) { this.requestedAmount = requestedAmount; }

    public int getCreditScore() { return creditScore; }
    public void setCreditScore(int creditScore) { this.creditScore = creditScore; }

    public double getMonthlyDebt() { return monthlyDebt; }
    public void setMonthlyDebt(double monthlyDebt) { this.monthlyDebt = monthlyDebt; }

    public double getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(double annualIncome) { this.annualIncome = annualIncome; }

    public EmploymentStatus getEmploymentStatus() { return employmentStatus; }
    public void setEmploymentStatus(EmploymentStatus employmentStatus) { this.employmentStatus = employmentStatus; }
}
