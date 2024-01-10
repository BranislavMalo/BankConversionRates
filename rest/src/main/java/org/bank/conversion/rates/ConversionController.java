package org.bank.conversion.rates;

import org.bank.conversion.rates.core.exceptions.RateNotFoundException;
import org.bank.conversion.rates.core.services.RateService;
import org.bank.conversion.rates.models.ConversionRequest;
import org.bank.conversion.rates.models.ConversionResult;
import org.bank.conversion.rates.models.RateConversionRequest;
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

    @Autowired
    private RateService rateService;

    // Existing method for converting with predefined rates
    @PostMapping(path = "/convert", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ConversionResult> convertRates(@RequestBody ConversionRequest request) {
        try {
            ConversionResult result = rateService.convertRates(request);
            return ResponseEntity.ok(result);
        } catch (RateNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // New method for converting with a specific rate
    @PostMapping(path = "/convert-with-rate", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ConversionResult> convertWithSpecificRate(@RequestBody RateConversionRequest request) {
        try {
            ConversionResult result = rateService.convertWithSpecificRate(request);
            return ResponseEntity.ok(result);
        } catch (RateNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
