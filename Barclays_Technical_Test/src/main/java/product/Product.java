package product;

public class Product {

    private String name;
    private long GBPValue;
    private int riskRating;
    private String type;

    public Product(String name, long GBPValue, int riskRating, String type) {
        this.name = name;
        this.GBPValue = GBPValue;
        this.riskRating = riskRating;
        this.type = type;
    }

    public long getGBPValue() {
        return GBPValue;
    }

    public void setGBPValue(long GBPValue) {
        this.GBPValue = GBPValue;
    }

    public int getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(int riskRating) {
        this.riskRating = riskRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
