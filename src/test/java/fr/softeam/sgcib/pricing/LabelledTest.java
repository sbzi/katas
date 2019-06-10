package fr.softeam.sgcib.pricing;

import fr.softeam.sgcib.pricing.discount.BuyManyGetSomeFreeDiscountStrategy;
import fr.softeam.sgcib.pricing.discount.DiscountStrategy;
import fr.softeam.sgcib.pricing.strategies.BatchPricingStrategy;
import fr.softeam.sgcib.pricing.strategies.BulkPricingStrategy;
import fr.softeam.sgcib.pricing.strategies.DefaultPricingStrategy;
import fr.softeam.sgcib.pricing.strategies.PricingStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class LabelledTest {

    @Test
    public void getDefaultPricingLabel() {
        // Given
        PricingStrategy ps = new DefaultPricingStrategy(new BigDecimal("1.5"));
        // When
        String label = ps.getLabel();
        // Then
        Assert.assertEquals("1.50/unit", label);
    }

    @Test
    public void getBulkPricingLabel() {
        // Given
        PricingStrategy ps = new BulkPricingStrategy(PricingStrategy.Unit.POUND,
                BigDecimal.ONE, new BigDecimal("1.99"));
        // When
        String label = ps.getLabel();
        // Then
        Assert.assertEquals("1.99/1 POUND", label);
    }

    @Test
    public void getBatchPricingLabel() {
        // Given
        PricingStrategy ps = new BatchPricingStrategy(new BigDecimal(3),
                BigDecimal.ONE);
        // When
        String label = ps.getLabel();
        // Then
        Assert.assertEquals("1.00/3 units", label);
    }

    @Test
    public void getBuyThreeGetOneFreeLabel() {
        // Given
        DiscountStrategy ds = new BuyManyGetSomeFreeDiscountStrategy(new BigDecimal(3), BigDecimal.ONE);
        // When
        String label = ds.getLabel();
        // Then
        Assert.assertEquals("Buy 3, 1 Free", label);
    }
}