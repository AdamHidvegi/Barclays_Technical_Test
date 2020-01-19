package account;

import product.Product;

import java.util.ArrayList;

public class Account {
    private String type;
    private ArrayList<Product> products;

    public Account(String type) {
        this.type = type;
        this.products = new ArrayList<Product>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int checkSize() {
        return this.products.size();
    }

//  make sure we are fulfilling every specific requirements
    public void addProduct(Product product) {
//      Retail account can use any kind of product except Tier 1 Capital
        if ((this.type == "Retail") && (product.getName() != "Tier 1 Capital")) {
            this.products.add(product);
        }
//      Internal account can use any kind of product
        else if (this.type == "Internal") {
            this.products.add(product);
        }
//      any product can be added to a Wholesale account (except Tier 1 Capital) if it has a minimum balance of £35000
        else if ((this.type == "Wholesale") && (product.getGBPValue() >= 35000) && (product.getName() != "Tier 1 Capital")) {
            this.products.add(product);
        }
    }
}
