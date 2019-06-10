package fr.softeam.sgcib.pricing.discount;

import fr.softeam.sgcib.pricing.Labelled;
import fr.softeam.sgcib.pricing.strategies.PricingStrategy;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public interface DiscountStrategy extends Labelled {

    BigDecimal apply(BigDecimal quantity);

    default BigDecimal apply(BigDecimal quantity, PricingStrategy.Unit unit) {
        BigDecimal converted = quantity;
        if(getUnit() != null && getUnit() != unit) {
            UnaryOperator<BigDecimal> converter = getUnit().getConverters().get(unit);
            if(converter == null) {
                throw new UnsupportedOperationException("Conversion from " + unit + " to " + getUnit() + " not supported");
            }
            converted = converter.apply(quantity);
        }
        BigDecimal discounted = apply(converted);
        if(unit != null && getUnit() != unit) {
            UnaryOperator<BigDecimal> converter = unit.getConverters().get(getUnit());
            if(converter == null) {
                throw new UnsupportedOperationException("Conversion from " + getUnit() + " to " + unit + " not supported");
            }
            discounted = converter.apply(discounted);
        }
        return discounted;
    }

    default PricingStrategy.Unit getUnit() {
        return null;
    }
}
