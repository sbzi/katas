package fr.softeam.sgcib.pricing.billing;

import fr.softeam.sgcib.pricing.domain.Product;
import fr.softeam.sgcib.pricing.strategies.PricingStrategy;

import java.math.BigDecimal;

public class InvoiceLine {

    private Product product;
    private BigDecimal quantity;
    private PricingStrategy.Unit unit;

    public InvoiceLine(Product product, BigDecimal quantity, PricingStrategy.Unit unit) {
        this.product = product;
        this.quantity = quantity;
        this.unit = unit;
    }

    public InvoiceLine(Product product, BigDecimal quantity) {
        this(product, quantity, null);
    }

    public InvoiceLineDetail getPricingLine() {
        return null;
    }

    public InvoiceLineDetail getDiscountLine() {
        return null;
    }

    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public String toString() {
        String str = String.format("%15s",
                product.getCode()) +
                this.getPricingLine().toString();
        if(getDiscountLine() != null) {
            str += "\n" + String.format("%15s",
                    "") +
                    this.getDiscountLine().toString();
        }
        return str;
    }
}
