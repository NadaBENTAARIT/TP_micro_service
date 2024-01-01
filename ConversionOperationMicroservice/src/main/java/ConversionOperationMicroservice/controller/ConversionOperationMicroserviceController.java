package ConversionOperationMicroservice.controller;
import ConversionOperationMicroservice.model.ConversionOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/api")
public class ConversionOperationMicroserviceController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/convert-amount")
    public ConversionOperation convertAmount(
            @RequestParam(name = "currencyFrom") String currencyFrom,
            @RequestParam(name = "currencyTo") String currencyTo,
            @RequestParam(name = "initialAmount") double initialAmount) {
        // Call ConversionRateMicroservice to get the conversion rate
        double conversionRate = getConversionRate(currencyFrom, currencyTo);
        // Perform conversion logic
        double convertedAmount = initialAmount * conversionRate;
        // Create and return a ConversionOperation object
        ConversionOperation conversionOperation = new ConversionOperation();
        conversionOperation.setCurrencyFrom(currencyFrom);
        conversionOperation.setCurrencyTo(currencyTo);
        conversionOperation.setInitialAmount(initialAmount);
        conversionOperation.setConvertedAmount(convertedAmount);
        conversionOperation.setConversionRate(conversionRate);
        return conversionOperation;
    }
    public double getConversionRate(String currencyFrom, String currencyTo) {
        String conversionRateServiceUrl = "http://localhost:8080/api/getConversionRate";

        return restTemplate.getForObject(
                String.format("%s?currencyFrom=%s&currencyTo=%s", conversionRateServiceUrl, currencyFrom, currencyTo),
                Double.class
        );
    }


}