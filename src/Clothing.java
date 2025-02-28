public class Clothing extends Product {
    private String material;

    // Constructor
    public Clothing(int productID, String name, double price, int stockQuantity, String material) {
        super(productID, name, "Clothing", price, stockQuantity);
        this.material = material;
    }

    // Getters and Setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // Override discount method
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.40;
    }
}
