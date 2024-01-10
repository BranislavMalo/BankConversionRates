package org.bank.conversion.rates.core.services;

import java.util.List;
import org.bank.conversion.rates.models.ConversionRequest;
import org.bank.conversion.rates.models.ConversionResult;
import org.bank.conversion.rates.models.Rate;
import org.bank.conversion.rates.models.RateConversionRequest;

public interface RateService {

    List<Rate> getAllRates();

    ConversionResult convertRates(ConversionRequest request);

    ConversionResult convertWithSpecificRate(RateConversionRequest request);
}