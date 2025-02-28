import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create sample products
        Electronics laptop = new Electronics(1, "Laptop", 1999.90, 5, "Asus");
        Electronics smartphone = new Electronics(2, "Smartphone", 999.99, 10, "Samsung");
        Clothing jacket = new Clothing(9, "Jacket", 89.99, 2, "L");
        Clothing sneakers = new Clothing(10, "Sneakers", 79.99, 15, "42");

        // Create an OrderManager object
        OrderManager orderManager = new OrderManager();

        Scanner scanner = new Scanner(System.in);
        int userID = 1;

        while (true) {
            // Display menu
            System.out.println("==== Order System ====");
            System.out.println("1. Place Order");
            System.out.println("2. View Order History");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Place Order
                    System.out.println("Select a product to order:");
                    System.out.println("1. Laptop");
                    System.out.println("2. Smartphone");
                    System.out.println("3. Jacket");
                    System.out.println("4. Sneakers");
                    System.out.print("Enter product number: ");
                    int productChoice = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    Product selectedProduct = null;

                    switch (productChoice) {
                        case 1:
                            selectedProduct = laptop;
                            break;
                        case 2:
                            selectedProduct = smartphone;
                            break;
                        case 3:
                            selectedProduct = jacket;
                            break;
                        case 4:
                            selectedProduct = sneakers;
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            continue;
                    }

                    // Create order and add order detail
                    try {
                        Order order = new Order(orderManager.getAllOrders().size() + 1, userID);
                        double subTotal = selectedProduct.getPrice() * quantity;
                        OrderDetails orderDetails = new OrderDetails(1, order.getOrderID(), selectedProduct.getProductID(), quantity, subTotal);
                        order.addOrderDetail(orderDetails);

                        orderManager.placeOrder(order, selectedProduct, quantity);
                    } catch (OutOfStockException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // View Order History
                    System.out.println("Enter your User ID: ");
                    userID = scanner.nextInt();
                    System.out.println("Your Order History:");
                    for (Order order : orderManager.getUserOrderHistory(userID)) {
                        System.out.println("Order ID: " + order.getOrderID() + ", User ID: " + order.getUserID());
                        for (OrderDetails details : order.getOrderDetails()) {
                            System.out.println("  Product ID: " + details.getProductID() + ", Quantity: " + details.getQuantity() + ", Subtotal: $" + details.getSubTotal());
                        }
                    }
                    break;

                case 3:
                    // Exit
                    System.out.println("Thank you for visiting Amazon!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
