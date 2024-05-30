package WeekTwo.StructuralPatterns;

public class ModernPaymentProcessor {
    public static class LegacyPaymentProcessor {
        public void pay(String amount){
            System.out.println("Amount paid: " + amount + " GHS.");
        }

    }
    public static class NewPaymentProcessor {
        public void pay(Double amount){
            System.out.println("Amount paid: " + amount + " USD.");
        }
    }

    public static class LegacyPaymentProcessorAdapter implements PaymentProcessor {
        private final NewPaymentProcessor paymentProcessor = new NewPaymentProcessor();

        @Override
        public void pay(String amount) {
            Double newAmount = Double.parseDouble(amount) / 15; // convert to USD
            paymentProcessor.pay(newAmount);
        }
    }

    public static void main(String[] args) {
        LegacyPaymentProcessorAdapter legacyPaymentProcessorAdapter = new LegacyPaymentProcessorAdapter();
        // paying 15 GHS as a string, to be converted to Double USD
        legacyPaymentProcessorAdapter.pay("15.0");
    }

}

