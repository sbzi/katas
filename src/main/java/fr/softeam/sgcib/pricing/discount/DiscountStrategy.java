package fr.softeam.sgcib.pricing.discount;

import java.math.BigDecimal;

public interface DiscountStrategy {

    BigDecimal apply(BigDecimal price, BigDecimal quantity);
}
