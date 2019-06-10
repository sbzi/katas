package fr.softeam.sgcib.pricing.strategies;

import java.math.BigDecimal;

public class DefaultPricingStrategy implements PricingStrategy{

    private BigDecimal unitPrice;

    public DefaultPricingStrategy(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public BigDecimal getPrice(BigDecimal quantity) {
        return null;
    }

    @Override
    public BigDecimal getPrice(BigDecimal quantity, Unit unit) {
        return null;
    }
}
