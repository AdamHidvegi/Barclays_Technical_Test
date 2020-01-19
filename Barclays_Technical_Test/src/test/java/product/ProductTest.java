package product;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    Product product;

    @Before
    public void before() {
        product = new Product("Cash", 100, 2, "asset");
    }

    @Test
    public void hasName() {
        assertEquals("Cash", product.getName());
    }

    @Test
    public void hasGBPValue() {
        assertEquals(100, product.getGBPValue());
    }

    @Test
    public void hasRiskRating() {
        assertEquals(2, product.getRiskRating());
    }

    @Test
    public void hasType() {
        assertEquals("asset", product.getType());
    }

}
