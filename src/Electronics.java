public class Electronics extends Product {
    private String brand;

    // Constructor
    public Electronics(int productID, String name, double price, int stockQuantity, String brand) {
        super(productID, name, "Electronics", price, stockQuantity);
        this.brand = brand;
    }

    // Getter and Setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Override discount method
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }
}
