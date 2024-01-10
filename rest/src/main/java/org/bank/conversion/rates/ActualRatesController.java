package org.bank.conversion.rates;

import java.util.List;
import org.bank.conversion.rates.core.services.RateService;
import org.bank.conversion.rates.models.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actual-rates")
public class ActualRatesController {

    @Autowired
    private RateService rateService;

    @GetMapping(produces = "application/json")
    public List<Rate> getActualRates() {
        return rateService.getAllRates();
    }
}