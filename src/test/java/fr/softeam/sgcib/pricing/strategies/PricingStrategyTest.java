package fr.softeam.sgcib.pricing.strategies;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PricingStrategyTest {

    @Test
    public void getPriceDefault() {
        PricingStrategy strategy = new DefaultPricingStrategy(new BigDecimal("2.23"));
        BigDecimal price = strategy.getPrice(new BigDecimal(3));
        Assert.assertEquals(new BigDecimal("6.69"), price);
    }

    @Test
    public void getPriceBatch() {
        PricingStrategy strategy = new BatchPricingStrategy(new BigDecimal(3), BigDecimal.ONE);
        BigDecimal price = strategy.getPrice(new BigDecimal(5));
        Assert.assertEquals(new BigDecimal("1.67"), price);
    }

    @Test
    public void getPriceBulk() {
        PricingStrategy strategy = new BulkPricingStrategy(PricingStrategy.Unit.POUND, BigDecimal.ONE, new BigDecimal("1.99"));
        BigDecimal price = strategy.getPrice(new BigDecimal(4), PricingStrategy.Unit.OUNCE);
        Assert.assertEquals(new BigDecimal("0.50"), price);
    }
}