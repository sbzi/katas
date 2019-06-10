package fr.softeam.sgcib.pricing.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DefaultPricingStrategy implements PricingStrategy{

    private BigDecimal unitPrice;

    public DefaultPricingStrategy(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public BigDecimal getPrice(BigDecimal quantity) {
        return unitPrice.multiply(quantity).setScale(2, RoundingMode.UP);
    }

    @Override
    public String getLabel() {
        return null;
    }
}
