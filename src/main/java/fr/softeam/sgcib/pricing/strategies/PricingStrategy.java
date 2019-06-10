package fr.softeam.sgcib.pricing.strategies;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal getPrice(BigDecimal quantity);

    BigDecimal getPrice(BigDecimal quantity, Unit unit);

    enum Unit {
        POUND,
        OUNCE
    }
}
