package ConversionRateMicroservice.repository;

import ConversionRateMicroservice.model.ConversionRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRateRepository extends JpaRepository<ConversionRate, Long> {
    ConversionRate findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);

}