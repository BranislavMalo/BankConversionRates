package org.bank.conversion.rates.core.exceptions;

public class RateNotFoundException extends RuntimeException {

    public RateNotFoundException() {
        super();
    }

    public RateNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public RateNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}