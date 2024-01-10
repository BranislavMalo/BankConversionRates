package org.bank.conversion.rates.models;

public class ConversionResult {

    private double convertedAmount;
    private String sourceCurrency;
    private String targetCurrency;

    // Constructors, getters, and setters

    public ConversionResult() {
        // Default constructor
    }

    public ConversionResult(double convertedAmount, String sourceCurrency, String targetCurrency) {
        this.convertedAmount = convertedAmount;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}