package products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    Product product;

    @Before
    public void before() {
        product = new Product(ProductName.CASH, 1, ProductType.ASSET, 100);
    }

    @Test
    public void hasName() {
        assertEquals(ProductName.CASH, product.getName());
    }

    @Test
    public void hasRiskRating() {
        assertEquals(1, product.getRiskRating());
    }

    @Test
    public void hasType() {
        assertEquals(ProductType.ASSET, product.getType());
    }

    @Test
    public void hasGBPValue() {
        assertEquals(100, product.getGBPValue());
    }
}
