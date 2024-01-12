package org.bank.conversion.rates.services;

import java.util.List;
import org.bank.conversion.rates.models.ConversionRequest;
import org.bank.conversion.rates.models.ConversionResult;
import org.bank.conversion.rates.models.Rate;

public interface RateService {

    List<Rate> getAllRates();

    ConversionResult convertRates(ConversionRequest request);
}