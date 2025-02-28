import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private int userID;
    private List<OrderDetails> orderDetails;

    // Constructor
    public Order(int orderID, int userID) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDetails = new ArrayList<>();
    }

    // Getters
    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    // Setters
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setOrderDetails(List<OrderDetails> orderDetailsList) {
        this.orderDetails = orderDetailsList;
    }

    // Method to add an OrderDetail to the list
    public void addOrderDetail(OrderDetails orderDetail) {
        this.orderDetails.add(orderDetail);
    }
}
