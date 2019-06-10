package fr.softeam.sgcib.pricing.strategies;

import java.math.BigDecimal;

public class BatchPricingStrategy implements PricingStrategy {

    private BigDecimal batchSize;
    private BigDecimal batchPrice;

    public BatchPricingStrategy(BigDecimal batchSize, BigDecimal batchPrice) {
        this.batchSize = batchSize;
        this.batchPrice = batchPrice;
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
