package fr.softeam.sgcib.pricing.discount;

import java.math.BigDecimal;

public class BuyManyGetSomeFreeDiscountStrategy implements DiscountStrategy {

    private BigDecimal bought;
    private BigDecimal free;

    public BuyManyGetSomeFreeDiscountStrategy(BigDecimal bought, BigDecimal free) {
        this.bought = bought;
        this.free = free;
    }

    @Override
    public BigDecimal apply(BigDecimal price, BigDecimal quantity) {
        return null;
    }
}
