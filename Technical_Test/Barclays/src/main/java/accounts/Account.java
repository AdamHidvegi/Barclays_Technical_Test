package accounts;

import products.Product;
import products.ProductName;

import java.util.ArrayList;

public class Account {

    private AccountType type;
    private ArrayList<Product> products;

    public Account(AccountType type) {
        this.type = type;
        this.products = new ArrayList<Product>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public int sizeOfProducts() {
        return this.products.size();
    }

    public void addProduct(Product product) {
        if (this.type == AccountType.RETAIL) {
            this.products.add(product);
        }
        if (this.type == AccountType.WHOLESALE && product.getGBPValue() >= 35.000) {
            this.products.add(product);
        }
        else if (this.type == AccountType.INTERNAL && product.getName() == ProductName.TIER_1_CAPITAL) {
            this.products.add(product);
        }
        else {
            this.products.add(null);
        }
    }

    public void addProductToWholesale(Product product) {
        if ((product.getGBPValue() >= 35.000) && (this.getType() == AccountType.WHOLESALE)) {
            this.products.add(product);
        }
    }

    public double netWorthValue() {
    }

    public double netWorthGBPValue() {
    }

}