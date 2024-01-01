package ConversionRateMicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ConversionRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rateId;

    private String currencyFrom;
    private String currencyTo;
    private double rate;
    private Date validityStartDate;
    private Date validityEndDate;
}


