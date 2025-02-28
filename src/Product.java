public class Product {
    // Attributes
    private int productID;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;

    // Constructor
    public Product(int productID, String name, String category,double price, int stockQuantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price=price;
        this.stockQuantity = stockQuantity;
    }

    // Getters
    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Setters
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Discount method (To be overridden in subclasses)
    public double calculateDiscount() {
        return getPrice(); // It will return Product price by deafult without discount
    }
}
