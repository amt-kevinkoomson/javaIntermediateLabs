package WeekOne.Generics;

public class KeyValueStore<K, V> {
    private K key;
    private V value;

    // Constructor
    public KeyValueStore(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Method to get the key
    public K getKey() {
        return key;
    }

    // Method to get the value
    public V getValue() {
        return value;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        KeyValueStore<Integer, String> studentMap = new KeyValueStore<>(1, "John");
        System.out.println("Student ID: " + studentMap.getKey() + ", Name: " + studentMap.getValue());

        KeyValueStore<String, Double> productMap = new KeyValueStore<>("ABC123", 29.99);
        System.out.println("Product ID: " + productMap.getKey() + ", Price: $" + productMap.getValue());
    }
}
