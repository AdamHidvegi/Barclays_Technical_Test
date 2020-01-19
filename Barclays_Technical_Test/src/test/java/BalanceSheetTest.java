import account.Account;
import org.junit.Before;
import org.junit.Test;
import product.Product;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BalanceSheetTest {

    BalanceSheet balanceSheet;

    Account retail;

    Account internal1;
    Account internal2;

    Account wholesale1;
    Account wholesale2;
    Account wholesale3;
    Account wholesale4;
    Account wholesale5;
    Account wholesale6;
    Account wholesale7;
    Account wholesale8;
    Account wholesale9;
    Account wholesale10;

    Product cash;
//    Product cash2;

    Product bond1;
    Product bond2;

    Product collateralisedLoan1;
    Product collateralisedLoan2;

    Product tier1Capital;

    ArrayList<Product> products;

    ArrayList<Account> accounts;

    @Before
    public void before() {
        balanceSheet = new BalanceSheet();

        retail = new Account("Retail");

        wholesale1 = new Account("Wholesale");
        wholesale2 = new Account("Wholesale");
        wholesale3 = new Account("Wholesale");
        wholesale4 = new Account("Wholesale");
        wholesale5 = new Account("Wholesale");
        wholesale6 = new Account("Wholesale");
        wholesale7 = new Account("Wholesale");
        wholesale8 = new Account("Wholesale");
        wholesale9 = new Account("Wholesale");
        wholesale10 = new Account("Wholesale");

        internal1 = new Account("Internal");
        internal2 = new Account("Internal");

        cash = new Product("Cash", 50000, 2, "asset");

        bond1 = new Product("Bond", 40000, 1, "asset");
        bond2 = new Product("Bond", 80000, 1, "asset");

        collateralisedLoan1 = new Product("Collateralised Loan", 100000, 3, "liability");
        collateralisedLoan2 = new Product("Collateralised Loan", 200000, 3, "liability");

        tier1Capital = new Product("Tier 1 Capital", 10000000000L, 0, "asset");

        accounts = new ArrayList<Account>();

        products = new ArrayList<Product>();
    }

    @Test
    public void addAccount() {
        balanceSheet.addAccount(retail);
        assertEquals(1, balanceSheet.checkSize());
    }

    @Test
    public void balanceSheetTest() {

//      internal accounts
        internal1.addProduct(tier1Capital);
        internal2.addProduct(collateralisedLoan1);
        internal2.addProduct(collateralisedLoan2);
        internal2.addProduct(collateralisedLoan1);
        internal2.addProduct(collateralisedLoan2);
        internal2.addProduct(collateralisedLoan1);
        internal2.addProduct(collateralisedLoan2);
        internal2.addProduct(collateralisedLoan1);
        internal2.addProduct(collateralisedLoan2);
        internal2.addProduct(collateralisedLoan1);
        internal2.addProduct(collateralisedLoan2);

//      wholesale accounts
        wholesale1.addProduct(cash);
        wholesale1.addProduct(bond1);
        wholesale1.addProduct(bond2);
        wholesale2.addProduct(cash);
        wholesale2.addProduct(bond1);
        wholesale2.addProduct(bond2);
        wholesale3.addProduct(cash);
        wholesale3.addProduct(bond1);
        wholesale3.addProduct(bond2);
        wholesale4.addProduct(cash);
        wholesale4.addProduct(bond1);
        wholesale4.addProduct(bond2);
        wholesale5.addProduct(cash);
        wholesale5.addProduct(bond1);
        wholesale5.addProduct(bond2);
        wholesale6.addProduct(cash);
        wholesale6.addProduct(bond1);
        wholesale6.addProduct(bond2);
        wholesale7.addProduct(cash);
        wholesale7.addProduct(bond1);
        wholesale7.addProduct(bond2);
        wholesale8.addProduct(cash);
        wholesale8.addProduct(bond1);
        wholesale8.addProduct(bond2);
        wholesale9.addProduct(cash);
        wholesale9.addProduct(bond1);
        wholesale9.addProduct(bond2);
        wholesale10.addProduct(cash);
        wholesale10.addProduct(bond1);
        wholesale10.addProduct(bond2);

//      adding accounts to the balance sheet
        balanceSheet.addAccount(internal1);
        balanceSheet.addAccount(internal2);

        balanceSheet.addAccount(wholesale1);
        balanceSheet.addAccount(wholesale2);
        balanceSheet.addAccount(wholesale3);
        balanceSheet.addAccount(wholesale4);
        balanceSheet.addAccount(wholesale5);
        balanceSheet.addAccount(wholesale6);
        balanceSheet.addAccount(wholesale7);
        balanceSheet.addAccount(wholesale8);
        balanceSheet.addAccount(wholesale9);
        balanceSheet.addAccount(wholesale10);

//      testing the number of products
        assertEquals(1, internal1.checkSize());
        assertEquals(10, internal2.checkSize());
        assertEquals(3, wholesale1.checkSize());
        assertEquals(3, wholesale2.checkSize());
        assertEquals(3, wholesale3.checkSize());
        assertEquals(3, wholesale4.checkSize());
        assertEquals(3, wholesale5.checkSize());
        assertEquals(3, wholesale6.checkSize());
        assertEquals(3, wholesale7.checkSize());
        assertEquals(3, wholesale8.checkSize());
        assertEquals(3, wholesale9.checkSize());
        assertEquals(3, wholesale10.checkSize());

//      testing the number of accounts
        assertEquals(12, balanceSheet.checkSize());

//      testing net worth value
        assertEquals(10000200000L, balanceSheet.netWorthValue());

//      testing net worth GBP value
        assertEquals(10000315000L, balanceSheet.netWorthGBPValue());
    }

}
