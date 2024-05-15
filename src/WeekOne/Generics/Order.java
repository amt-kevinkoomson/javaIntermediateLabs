package WeekOne.Generics;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private double totalAmount;
    private int customerId;

    // Constructor
    public Order(int orderId, double totalAmount, int customerId) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Sample list of orders
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, 100.0, 101));
        orders.add(new Order(2, 150.0, 102));
        orders.add(new Order(3, 200.0, 103));
        orders.add(new Order(4, 120.0, 101));
        orders.add(new Order(5, 180.0, 102));

        // Calculate average order value
        double averageOrderValue = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .average()
                .orElse(0.0);

        // Print the average order value
        System.out.println("Average Order Value: $" + averageOrderValue);
    }
}

