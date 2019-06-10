package fr.softeam.sgcib.pricing.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BulkPricingStrategy implements PricingStrategy {

    private Unit unit;
    private BigDecimal bulkSize;
    private BigDecimal bulkPrice;

    public BulkPricingStrategy(Unit unit, BigDecimal bulkSize, BigDecimal bulkPrice) {
        this.unit = unit;
        this.bulkSize = bulkSize;
        this.bulkPrice = bulkPrice;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    public BigDecimal getPrice(BigDecimal quantity) {
        return quantity.divide(bulkSize, 10, RoundingMode.DOWN).multiply(bulkPrice).setScale(2, RoundingMode.UP);
    }

    @Override
    public String getLabel() {
        return bulkPrice.setScale(2, RoundingMode.UP) + "/" + bulkSize + " " + unit;
    }
}
