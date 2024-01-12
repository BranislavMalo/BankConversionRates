package org.bank.conversion.rates.exceptions;

public class RateNotFoundException extends RuntimeException {

    public RateNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}