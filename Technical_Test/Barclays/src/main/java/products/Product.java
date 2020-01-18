package products;

public class Product {

    private ProductName name;
    private int riskRating;
    private ProductType type;
    private int GBPValue;

    public Product(ProductName name, int riskRating, ProductType type, int GBPValue) {
        this.name = name;
        this.riskRating = riskRating;
        this.type = type;
        this.GBPValue = GBPValue;
    }

    public int getGBPValue() {
        return GBPValue;
    }

    public void setGBPValue(int GBPValue) {
        this.GBPValue = GBPValue;
    }

    public ProductName getName() {
        return name;
    }

    public void setName(ProductName name) {
        this.name = name;
    }

    public int getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(int riskRating) {
        this.riskRating = riskRating;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
