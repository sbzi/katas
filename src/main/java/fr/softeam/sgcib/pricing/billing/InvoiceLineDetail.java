package fr.softeam.sgcib.pricing.billing;

import fr.softeam.sgcib.pricing.strategies.PricingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvoiceLineDetail {

    private String label;
    private BigDecimal quantity;
    private PricingStrategy.Unit unit;
    private BigDecimal price;

    public InvoiceLineDetail(String label, BigDecimal quantity, PricingStrategy.Unit unit, BigDecimal price) {
        this.label = label;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                String.format("%25s", label) +
                        String.format("%10s", "" + quantity.setScale(3, RoundingMode.DOWN)) +
                        String.format("%10s", ((unit != null) ? " " + unit : "")) +
                        String.format("%10s", "" + price.setScale(2, RoundingMode.UP));
    }
}
