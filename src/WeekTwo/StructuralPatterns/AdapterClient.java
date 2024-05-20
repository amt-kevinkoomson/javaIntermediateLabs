package WeekTwo.StructuralPatterns;

// Modern API interface for payment processing
interface PaymentProcessor {
    void pay(double amount);
}

// Legacy payment processing library (adaptee)
class LegacyPaymentLibrary {
    void processPayment(double amount) {
        System.out.println("Legacy payment processed for amount: " + amount);
    }
}

// Adapter class that adapts the legacy payment library to the modern API
class LegacyPaymentAdapter implements PaymentProcessor {
    private LegacyPaymentLibrary legacyPaymentLibrary;

    public LegacyPaymentAdapter(LegacyPaymentLibrary legacyPaymentLibrary) {
        this.legacyPaymentLibrary = legacyPaymentLibrary;
    }

    @Override
    public void pay(double amount) {
        // Call the processPayment method of the legacy library
        legacyPaymentLibrary.processPayment(amount);
    }
}

// Client code using the modern API
public class AdapterClient {
    public static void main(String[] args) {
        // Create an instance of the legacy payment library
        LegacyPaymentLibrary legacyPaymentLibrary = new LegacyPaymentLibrary();

        // Create an adapter instance to use the legacy library with the modern API
        PaymentProcessor paymentProcessor = new LegacyPaymentAdapter(legacyPaymentLibrary);

        // Use the modern API to process payment
        paymentProcessor.pay(100.0);
    }
}
