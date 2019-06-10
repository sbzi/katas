package fr.softeam.sgcib.pricing.discount;

import fr.softeam.sgcib.pricing.strategies.DefaultPricingStrategy;
import fr.softeam.sgcib.pricing.strategies.PricingStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DiscountStrategyTest {

    @Test
    public void buyThreeGetOneFree() {
        // Given
        DiscountStrategy discountStrategy = new BuyManyGetSomeFreeDiscountStrategy(new BigDecimal(3), BigDecimal.ONE);
        // When
        BigDecimal freeQuantity = discountStrategy.apply(new BigDecimal(4));
        // Then
        Assert.assertEquals(BigDecimal.ONE, freeQuantity);
    }
}