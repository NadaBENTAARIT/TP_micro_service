package ConversionRateMicroservice.service;

import ConversionRateMicroservice.repository.ConversionRateRepository;
import ConversionRateMicroservice.model.ConversionRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionRateService {

    @Autowired
    private ConversionRateRepository conversionRateRepository;

    public Double getConversionRate(String currencyFrom, String currencyTo) {
        // Fetch conversion rate from the database based on currencyFrom and currencyTo
        ConversionRate conversionRate = conversionRateRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);

        if (conversionRate != null) {
            return conversionRate.getRate();
        } else {
            return null;
        }
    }
}
