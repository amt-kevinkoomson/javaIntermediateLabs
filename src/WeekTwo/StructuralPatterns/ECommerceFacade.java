package WeekTwo.StructuralPatterns;

public class ECommerceFacade {
    // InventorySystem.java
    public static class InventorySystem {
        public boolean checkStock(String item, int quantity) {
            // Check if the item is in stock
            System.out.println("Checking stock for " + quantity + " of " + item);
            return true;
        }

        public void updateStock(String item, int quantity) {
            // Update stock levels
            System.out.println("Updating stock for " + quantity + " of " + item);
        }
    }

    // PaymentSystem.java
    public static class PaymentSystem {
        public boolean processPayment(String paymentDetails) {
            // Process the payment
            System.out.println("Processing payment: " + paymentDetails);
            return true;
        }
    }

    // ShippingSystem.java
    public static class ShippingSystem {
        public void shipOrder(String item, int quantity, String address) {
            // Ship the order
            System.out.println("Shipping " + quantity + " of " + item + " to " + address);
        }
    }

    // NotificationSystem.java
    public static class NotificationSystem {
        public void sendConfirmation(String email, String message) {
            // Send confirmation notification
            System.out.println("Sending confirmation to " + email + ": " + message);
        }
    }

    // OrderFacade.java
    public static class OrderFacade {
        private final InventorySystem inventorySystem;
        private final PaymentSystem paymentSystem;
        private final ShippingSystem shippingSystem;
        private final NotificationSystem notificationSystem;

        public OrderFacade() {
            this.inventorySystem = new InventorySystem();
            this.paymentSystem = new PaymentSystem();
            this.shippingSystem = new ShippingSystem();
            this.notificationSystem = new NotificationSystem();
        }

        public void placeOrder(String item, int quantity, String paymentDetails, String address, String email) {
            // Check stock
            if (!inventorySystem.checkStock(item, quantity)) {
                System.out.println("Item is out of stock");
                return;
            }

            // Process payment
            if (!paymentSystem.processPayment(paymentDetails)) {
                System.out.println("Payment failed");
                return;
            }

            // Update stock
            inventorySystem.updateStock(item, quantity);

            // Ship order
            shippingSystem.shipOrder(item, quantity, address);

            // Send confirmation
            notificationSystem.sendConfirmation(email, "Your order for " + quantity + " of " + item + " has been placed successfully.");
        }

        public void cancelOrder(String item, int quantity, String paymentDetails, String address, String email) {
            // Placeholder for order cancellation logic
            System.out.println("Cancelling order for " + quantity + " of " + item);

            // Update stock (return items to stock)
            inventorySystem.updateStock(item, quantity);

            // Send cancellation notification
            notificationSystem.sendConfirmation(email, "Your order for " + quantity + " of " + item + " has been cancelled.");
        }
    }



    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();

        // Place an order
        orderFacade.placeOrder("Laptop", 1, "CreditCard 1234", "123 Main St", "customer@example.com");

        // Cancel an order
        orderFacade.cancelOrder("Laptop", 1, "CreditCard 1234", "123 Main St", "customer@example.com");
    }
}
