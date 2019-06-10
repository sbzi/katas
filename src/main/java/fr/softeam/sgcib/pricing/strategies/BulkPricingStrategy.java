package fr.softeam.sgcib.pricing.strategies;

import java.math.BigDecimal;

public class BulkPricingStrategy implements PricingStrategy {

    private Unit unit;
    private BigDecimal bulkSize;
    private BigDecimal bulkPrice;

    public BulkPricingStrategy(Unit unit, BigDecimal bulkSize, BigDecimal bulkPrice) {
        this.unit = unit;
        this.bulkSize = bulkSize;
        this.bulkPrice = bulkPrice;
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
