package fr.softeam.sgcib.pricing.discount;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DiscountStrategyTest {

    @Test
    public void buyThreeGetOneFree() {
        // Given
        DiscountStrategy strategy = new BuyManyGetSomeFreeDiscountStrategy(new BigDecimal(3), BigDecimal.ONE);
        // When
        BigDecimal price = strategy.apply(new BigDecimal(2), new BigDecimal(4));
        // Then
        Assert.assertEquals(new BigDecimal("1.50"), price);
    }
}