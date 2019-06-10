package fr.softeam.sgcib.pricing.discount;

import fr.softeam.sgcib.pricing.strategies.PricingStrategy;

import java.math.BigDecimal;

public interface DiscountStrategy {

    BigDecimal apply(BigDecimal quantity);

    BigDecimal apply(BigDecimal quantity, PricingStrategy.Unit unit);
}
