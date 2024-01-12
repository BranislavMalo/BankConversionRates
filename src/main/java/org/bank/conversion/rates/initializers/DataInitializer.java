package org.bank.conversion.rates.initializers;

import org.bank.conversion.rates.models.Rate;
import org.bank.conversion.rates.repository.RateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RateRepository rateRepository;

    public DataInitializer(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public void run(String... args) {
        rateRepository.save(new Rate("USD", "EUR", 0.85));
        rateRepository.save(new Rate("USD", "GBP", 0.75));
        rateRepository.save(new Rate("EUR", "USD", 1.18));
        rateRepository.save(new Rate("EUR", "GBP", 0.89));
        rateRepository.save(new Rate("GBP", "USD", 1.33));
        rateRepository.save(new Rate("GBP", "EUR", 1.12));
    }
}