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
        rateRepository.save(new Rate(1, "USD", "EUR", 0.85));
        rateRepository.save(new Rate(2, "USD", "GBP", 0.75));
        rateRepository.save(new Rate(3, "EUR", "USD", 1.18));
        rateRepository.save(new Rate(4, "EUR", "GBP", 0.89));
        rateRepository.save(new Rate(5, "GBP", "USD", 1.33));
        rateRepository.save(new Rate(6, "GBP", "EUR", 1.12));
    }
}