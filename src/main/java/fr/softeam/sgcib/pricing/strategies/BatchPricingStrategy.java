package fr.softeam.sgcib.pricing.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BatchPricingStrategy implements PricingStrategy {

    private BigDecimal batchSize;
    private BigDecimal batchPrice;

    public BatchPricingStrategy(BigDecimal batchSize, BigDecimal batchPrice) {
        this.batchSize = batchSize;
        this.batchPrice = batchPrice;
    }

    @Override
    public BigDecimal getPrice(BigDecimal quantity) {
        return quantity.divide(batchSize, 10, RoundingMode.DOWN).multiply(batchPrice).setScale(2, RoundingMode.UP);
    }
}
