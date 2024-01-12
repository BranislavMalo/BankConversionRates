package org.bank.conversion.rates.repository;

import org.bank.conversion.rates.models.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    Rate findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);
}