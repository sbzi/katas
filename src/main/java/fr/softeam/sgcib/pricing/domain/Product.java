package fr.softeam.sgcib.pricing.domain;

import fr.softeam.sgcib.pricing.billing.InvoiceLineDetail;
import fr.softeam.sgcib.pricing.discount.DiscountStrategy;
import fr.softeam.sgcib.pricing.strategies.PricingStrategy;

import java.math.BigDecimal;

public class Product {

    private String code;

    private PricingStrategy pricingStrategy;
    private DiscountStrategy discountStrategy;


    public Product(String code, PricingStrategy pricingStrategy) {
        this.code = code;
        this.pricingStrategy = pricingStrategy;
    }

    public String getCode() {
        return code;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public InvoiceLineDetail applyPricing(BigDecimal quantity, PricingStrategy.Unit unit) {
        BigDecimal price = this.pricingStrategy.getPrice(quantity, unit);
        return new InvoiceLineDetail(pricingStrategy.getLabel(),
                quantity, unit, price);
    }

    public InvoiceLineDetail applyDiscount(BigDecimal quantity, PricingStrategy.Unit unit) {
        if(this.discountStrategy != null) {
            BigDecimal freeQuantity = discountStrategy.apply(quantity, unit);
            if(freeQuantity.compareTo(BigDecimal.ZERO) > 0) {
                return new InvoiceLineDetail(discountStrategy.getLabel(),
                        freeQuantity, unit,
                        pricingStrategy.getPrice(freeQuantity, unit).multiply(new BigDecimal(-1)));
            }
        }
        return null;
    }
}
