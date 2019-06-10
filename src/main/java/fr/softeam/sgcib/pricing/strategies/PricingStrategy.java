package fr.softeam.sgcib.pricing.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public interface PricingStrategy {

    BigDecimal getPrice(BigDecimal quantity);

    default BigDecimal getPrice(BigDecimal quantity, Unit unit) {
        BigDecimal converted = quantity;
        if(getUnit() != null && getUnit() != unit) {
            UnaryOperator<BigDecimal> converter = getUnit().getConverters().get(unit);
            if(converter == null) {
                throw new UnsupportedOperationException("Conversion from " + unit + " to " + getUnit() + " not supported");
            }
            converted = converter.apply(quantity);
        }
        return getPrice(converted);
    }

    default Unit getUnit() {
        return null;
    }

    enum Unit {
        POUND() {
            Map<Unit, UnaryOperator<BigDecimal>> getConverters() {
                HashMap<Unit, UnaryOperator<BigDecimal>> converters = new HashMap<>();
                converters.put(Unit.OUNCE, q -> q.divide(new BigDecimal(16), 10, RoundingMode.DOWN));
                return converters;
            }
        },
        OUNCE() {
            @Override
            Map<Unit, UnaryOperator<BigDecimal>> getConverters() {
                HashMap<Unit, UnaryOperator<BigDecimal>> converters = new HashMap<>();
                converters.put(Unit.POUND, q -> q.multiply(new BigDecimal(16)));
                return converters;
            }
        };

        abstract Map<Unit, UnaryOperator<BigDecimal>> getConverters();
    }
}
