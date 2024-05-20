package WeekTwo.StructuralPatterns;

import java.util.UUID;

// Complex e-commerce order processing system
class OrderProcessingSystem {
    // Method to place an order
    public String placeOrder(String productId, int quantity, String shippingAddress) {
        // Simulate order placement process
        String orderId = UUID.randomUUID().toString(); // Generate a random order ID
        System.out.println("Order placed successfully. Order ID: " + orderId);
        return orderId;
    }

    // Method to cancel an order
    public void cancelOrder(String orderId) {
        // Simulate order cancellation process
        System.out.println("Order cancelled successfully. Order ID: " + orderId);
    }

    // Method to track order status
    public String trackOrder(String orderId) {
        // Simulate order tracking process
        return "Shipped"; // In a real system, this would return the actual order status
    }
}

// Facade class providing simplified methods for order processing
class OrderFacade {
    private OrderProcessingSystem orderProcessingSystem;

    public OrderFacade() {
        this.orderProcessingSystem = new OrderProcessingSystem();
    }

    // Method to place an order
    public String placeOrder(String productId, int quantity, String shippingAddress) {
        return orderProcessingSystem.placeOrder(productId, quantity, shippingAddress);
    }

    // Method to cancel an order
    public void cancelOrder(String orderId) {
        orderProcessingSystem.cancelOrder(orderId);
    }

    // Method to track order status
    public String trackOrder(String orderId) {
        return orderProcessingSystem.trackOrder(orderId);
    }
}

// Client code using the Facade
public class ClientFacade {
    public static void main(String[] args) {
        // Create an instance of the OrderFacade
        OrderFacade orderFacade = new OrderFacade();

        // Place an order
        String orderId = orderFacade.placeOrder("12345", 2, "123 Street, City");

        // Cancel the order
        orderFacade.cancelOrder(orderId);

        // Track the order status
        String orderStatus = orderFacade.trackOrder(orderId);
        System.out.println("Order status: " + orderStatus);
    }
}

