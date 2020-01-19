package account;

import org.junit.Before;
import org.junit.Test;
import product.Product;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    Account retail;
    Account wholesale;
    Account internal;

    ArrayList<Product> products;

    Product cash;
    Product bond;
    Product collateralisedLoan;
    Product tier1Capital;

    @Before
    public void before() {
        retail = new Account("Retail");
        wholesale = new Account("Wholesale");
        internal = new Account("Internal");

        products = new ArrayList<Product>();

        cash = new Product("Cash", 100, 2, "asset");
        bond = new Product("Bond", 35000, 2, "asset");
        collateralisedLoan = new Product("Collateralised Loan", 100, 2, "asset");
        tier1Capital = new Product("Tier 1 Capital", 35000, 2, "asset");
    }

    @Test
    public void hasType() {
        assertEquals("Retail", retail.getType());
    }

    @Test
    public void checkSize() {
        assertEquals(0, retail.checkSize());
        retail.addProduct(cash);
        assertEquals(1, retail.checkSize());
    }

    @Test
    public void addProduct() {
        retail.addProduct(bond);
        assertEquals(1, retail.checkSize());
        retail.addProduct(tier1Capital);
        assertEquals(1, retail.checkSize());
        wholesale.addProduct(cash);
        assertEquals(0, wholesale.checkSize());
        wholesale.addProduct(bond);
        assertEquals(1, wholesale.checkSize());
        wholesale.addProduct(tier1Capital);
        assertEquals(1, wholesale.checkSize());
        internal.addProduct(tier1Capital);
        assertEquals(1, internal.checkSize());
    }

    @Test
    public void addCash() {
        retail.addProduct(cash);
        wholesale.addProduct(cash);
        internal.addProduct(cash);
        assertEquals(1, retail.checkSize());
        assertEquals(0, wholesale.checkSize());
        assertEquals(1, internal.checkSize());
    }

    @Test
    public void addBond() {
        retail.addProduct(bond);
        wholesale.addProduct(bond);
        internal.addProduct(bond);
        assertEquals(1, retail.checkSize());
        assertEquals(1, wholesale.checkSize());
        assertEquals(1, internal.checkSize());
    }

    @Test
    public void addCollateralisedLoan() {
        retail.addProduct(collateralisedLoan);
        wholesale.addProduct(collateralisedLoan);
        internal.addProduct(collateralisedLoan);
        assertEquals(1, retail.checkSize());
        assertEquals(0, wholesale.checkSize());
        assertEquals(1, internal.checkSize());
    }

    @Test
    public void addTier1Capital() {
        retail.addProduct(tier1Capital);
        wholesale.addProduct(tier1Capital);
        internal.addProduct(tier1Capital);
        assertEquals(0, retail.checkSize());
        assertEquals(0, wholesale.checkSize());
        assertEquals(1, internal.checkSize());
    }

}
