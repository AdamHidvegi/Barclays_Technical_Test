package accounts;

import org.junit.Before;
import org.junit.Test;
import products.Product;
import products.ProductName;
import products.ProductType;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    Account retail;
    Account wholesale;
    Account internal;

    ArrayList<Account> accounts;

    Product cash;
    Product bond;
    Product tier1Capital;

    @Before
    public void before() {
        retail = new Account(AccountType.RETAIL);
        wholesale = new Account(AccountType.WHOLESALE);
        internal = new Account(AccountType.INTERNAL);

        accounts = new ArrayList<Account>();

        cash = new Product(ProductName.CASH, 1, ProductType.ASSET, 1000);
        bond = new Product(ProductName.BOND, 1, ProductType.LIABILITY, 35000);
        tier1Capital = new Product(ProductName.TIER_1_CAPITAL, 1, ProductType.ASSET, 35000);
    }

    @Test
    public void hasType() {
        assertEquals(AccountType.RETAIL, retail.getType());
    }

    @Test
    public void sizeOfProducts__emptyArray() {
        assertEquals(0, retail.sizeOfProducts());
        assertEquals(0, wholesale.sizeOfProducts());
        assertEquals(0, internal.sizeOfProducts());
    }

    @Test
    public void addProduct() {
        wholesale.addProduct(bond);
        assertEquals(1, wholesale.sizeOfProducts());
        assertEquals(35000, bond .getGBPValue());
    }


}
