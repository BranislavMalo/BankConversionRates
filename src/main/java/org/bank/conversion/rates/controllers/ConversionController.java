package org.bank.conversion.rates.controllers;

import org.bank.conversion.rates.exceptions.RateNotFoundException;
import org.bank.conversion.rates.models.ConversionRequest;
import org.bank.conversion.rates.models.ConversionResult;
import org.bank.conversion.rates.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate-conversion")
public class ConversionController {

    private final RateService rateService;

    @Autowired
    public ConversionController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping(path = "/convert", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> convertRates(@RequestBody ConversionRequest request) {
        try {
            // Check if the amount is non-negative
            if (request.getAmount() < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Amount cannot be a negative number");
            }
            final ConversionResult result = rateService.convertRates(request);
            return ResponseEntity.ok(result);
        } catch (RateNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}