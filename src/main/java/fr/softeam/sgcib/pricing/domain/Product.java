package fr.softeam.sgcib.pricing.domain;

import fr.softeam.sgcib.pricing.discount.DiscountStrategy;
import fr.softeam.sgcib.pricing.strategies.PricingStrategy;

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
}
