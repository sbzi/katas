package fr.softeam.sgcib.pricing.billing;

import fr.softeam.sgcib.pricing.discount.BuyManyGetSomeFreeDiscountStrategy;
import fr.softeam.sgcib.pricing.domain.Product;
import fr.softeam.sgcib.pricing.strategies.BulkPricingStrategy;
import fr.softeam.sgcib.pricing.strategies.DefaultPricingStrategy;
import fr.softeam.sgcib.pricing.strategies.PricingStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class InvoiceLineTest {

    @Test
    public void getPriceDefaultPricingBuyFiveGetTwoFree() {
        // Given
        Product product = new Product("123", new DefaultPricingStrategy(new BigDecimal("1.23")));
        product.setDiscountStrategy(new BuyManyGetSomeFreeDiscountStrategy(new BigDecimal(5), new BigDecimal(2)));
        // When
        InvoiceLine invoiceLine = new InvoiceLine(product, new BigDecimal(10));
        // Then
        Assert.assertNotNull("There is a pricing line", invoiceLine.getPricingLine());
        Assert.assertNotNull("There is a discount line", invoiceLine.getDiscountLine());
        Assert.assertEquals(new BigDecimal("7.38"), invoiceLine.getPrice());
        System.out.println("--------- Test Get Price with default pricing and a discount ---------");
        System.out.println(invoiceLine.toString());
    }

    @Test
    public void getPriceBulkPricing() {
        // Given
        Product product = new Product("456", new BulkPricingStrategy(PricingStrategy.Unit.OUNCE,
                new BigDecimal("2.5"), new BigDecimal("2.17")));
        // When
        InvoiceLine invoiceLine = new InvoiceLine(product, BigDecimal.ONE, PricingStrategy.Unit.POUND);
        // Then
        Assert.assertNotNull("There is a pricing line", invoiceLine.getPricingLine());
        Assert.assertNull("There is no discount line", invoiceLine.getDiscountLine());
        Assert.assertEquals(new BigDecimal("13.89"), invoiceLine.getPrice());
        System.out.println("--------- Test Get Price with Bulk pricing ---------");
        System.out.println(invoiceLine.toString());
    }

}