package org.bank.conversion.rates.core.services;

import java.util.List;
import org.bank.conversion.rates.core.database.RateRepository;
import org.bank.conversion.rates.core.exceptions.RateNotFoundException;
import org.bank.conversion.rates.models.ConversionRequest;
import org.bank.conversion.rates.models.ConversionResult;
import org.bank.conversion.rates.models.Rate;
import org.bank.conversion.rates.models.RateConversionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }

    @Override
    public ConversionResult convertRates(ConversionRequest request) {
        Rate sourceRate = rateRepository.findBySourceCurrencyAndTargetCurrency(
                request.getSourceCurrency(),
                request.getTargetCurrency());

        if (sourceRate == null) {
            throw new RateNotFoundException("Rate not found for the provided currencies");
        }

        double convertedAmount = request.getAmount() * sourceRate.getRateValue();

        ConversionResult result = new ConversionResult();
        result.setSourceCurrency(request.getSourceCurrency());
        result.setTargetCurrency(request.getTargetCurrency());
        result.setConvertedAmount(convertedAmount);

        return result;
    }

    @Override
    public ConversionResult convertWithSpecificRate(RateConversionRequest request) {
        Rate rate = request.getRate();

        // Check if the rate for the conversion exists
        if (rate == null) {
            throw new RateNotFoundException("Rate not provided for conversion");
        }

        // Perform conversion calculation
        double convertedAmount = request.getAmount() * rate.getRateValue();

        // Prepare the conversion result
        ConversionResult result = new ConversionResult();
        result.setSourceCurrency(rate.getSourceCurrency());
        result.setTargetCurrency(rate.getTargetCurrency());
        result.setConvertedAmount(convertedAmount);

        return result;
    }
}