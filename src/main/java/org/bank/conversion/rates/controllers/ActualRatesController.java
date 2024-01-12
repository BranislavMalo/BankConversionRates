package org.bank.conversion.rates;

import java.util.List;
import org.bank.conversion.rates.models.Rate;
import org.bank.conversion.rates.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actual-rates")
public class ActualRatesController {

    private final RateService rateService;

    @Autowired
    public ActualRatesController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping(path = "/show-rates", produces = "application/json")
    public List<Rate> getActualRates() {
        return rateService.getAllRates();
    }
}