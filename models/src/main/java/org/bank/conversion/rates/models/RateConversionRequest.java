package org.bank.conversion.rates.models;

public class RateConversionRequest {

    private Rate rate;
    private double amount;

    // Constructors, getters, and setters

    // Constructors, getters, and setters

    public RateConversionRequest() {
        // Default constructor
    }

    public RateConversionRequest(Rate rate, double amount) {
        this.rate = rate;
        this.amount = amount;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}