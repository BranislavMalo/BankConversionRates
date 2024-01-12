package org.bank.conversion.rates.services;

import java.util.List;
import org.bank.conversion.rates.exceptions.RateNotFoundException;
import org.bank.conversion.rates.models.ConversionRequest;
import org.bank.conversion.rates.models.ConversionResult;
import org.bank.conversion.rates.models.Rate;
import org.bank.conversion.rates.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    @Autowired
    public RateServiceImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }

    @Override
    public ConversionResult convertRates(ConversionRequest request) {
        final Rate sourceRate = rateRepository.findBySourceCurrencyAndTargetCurrency(
                request.getSourceCurrency(),
                request.getTargetCurrency());

        if (sourceRate == null) {
            throw new RateNotFoundException("Rate not found for the provided currencies");
        }

        double convertedAmount = request.getAmount() * sourceRate.getRateValue();

        final ConversionResult result = new ConversionResult();
        result.setSourceCurrency(request.getSourceCurrency());
        result.setTargetCurrency(request.getTargetCurrency());
        result.setConvertedAmount(convertedAmount);

        return result;
    }
}