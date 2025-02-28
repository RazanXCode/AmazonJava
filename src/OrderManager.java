import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private List<Order> orders; // Stores all orders
    private Map<Integer, List<Order>> userOrderHistory; // Maps userID to their order history

    // Constructor
    public OrderManager() {
        this.orders = new ArrayList<>();
        this.userOrderHistory = new HashMap<>();
    }

    // Method to place an order with stock validation
    public void placeOrder(Order order, Product product, int quantity) throws OutOfStockException {
        if (product.getStockQuantity() < quantity) {
            throw new OutOfStockException();
        }

        // Deduct stock quantity
        product.setStockQuantity(product.getStockQuantity() - quantity);

        // Add order to main list
        orders.add(order);

        // Add order to user history
        userOrderHistory.putIfAbsent(order.getUserID(), new ArrayList<>());
        userOrderHistory.get(order.getUserID()).add(order);

        System.out.println("Order placed successfully: Order ID " + order.getOrderID());

    }


    // Method to retrieve all orders
    public List<Order> getAllOrders() {
        return orders;
    }

    // Method to retrieve a user's order history
    public List<Order> getUserOrderHistory(int userID) {
        return userOrderHistory.getOrDefault(userID, new ArrayList<>());
    }

}
