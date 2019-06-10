package fr.softeam.sgcib.pricing.billing;

import fr.softeam.sgcib.pricing.domain.Product;
import fr.softeam.sgcib.pricing.strategies.PricingStrategy;

import java.math.BigDecimal;

public class InvoiceLine {

    private Product product;
    private BigDecimal quantity;
    private PricingStrategy.Unit unit;

    private InvoiceLineDetail pricingLine;
    private InvoiceLineDetail discountLine;

    public InvoiceLine(Product product, BigDecimal quantity, PricingStrategy.Unit unit) {
        this.product = product;
        this.quantity = quantity;
        this.unit = unit;
        compute();
    }

    public InvoiceLine(Product product, BigDecimal quantity) {
        this(product, quantity, null);
    }

    private void compute() {
        pricingLine = this.product.applyPricing(quantity, unit);
        discountLine = this.product.applyDiscount(quantity, unit);
    }

    public InvoiceLineDetail getPricingLine() {
        return pricingLine;
    }

    public InvoiceLineDetail getDiscountLine() {
        return discountLine;
    }

    public BigDecimal getPrice() {
        BigDecimal price = pricingLine.getPrice();
        if(discountLine != null) {
            price = price.add(discountLine.getPrice());
        }
        return price;
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
