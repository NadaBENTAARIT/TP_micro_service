package ConversionRateMicroservice.controller;

import ConversionRateMicroservice.service.ConversionRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class ConversionRateController {
    @Autowired
    private ConversionRateService conversionRateService;
    @GetMapping("/getConversionRate")
    public Double getConversionRate(
            @RequestParam(name = "currencyFrom") String currencyFrom,
            @RequestParam(name = "currencyTo") String currencyTo) {

        // Fetch conversion rate from the database
        Double conversionRate = conversionRateService.getConversionRate(currencyFrom, currencyTo);

        return conversionRate;
    }
}