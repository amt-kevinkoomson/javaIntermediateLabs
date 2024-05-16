package WeekOne.Collections;

import java.util.HashSet;
import java.util.Set;

public class ProductManager {
    private Set<String> productIds;

    // Constructor
    public ProductManager() {
        productIds = new HashSet<>();
    }

    // Method to add a product ID
    public void addProduct(String productId) {
        if (productIds.add(productId)) {
            System.out.println("Product ID " + productId + " added successfully.");
        } else {
            System.out.println("Product ID " + productId + " already exists.");
        }
    }

    // Method to remove a product ID
    public void removeProduct(String productId) {
        if (productIds.remove(productId)) {
            System.out.println("Product ID " + productId + " removed successfully.");
        } else {
            System.out.println("Product ID " + productId + " does not exist.");
        }
    }

    // Method to display all product IDs
    public void displayProductIds() {
        System.out.println("Unique Product IDs:");
        for (String productId : productIds) {
            System.out.println("- " + productId);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a ProductManager object
        ProductManager productManager = new ProductManager();

        // Add some product IDs
        productManager.addProduct("P001");
        productManager.addProduct("P002");
        productManager.addProduct("P003");
        productManager.addProduct("P001"); // Adding a duplicate ID

        // Display all product IDs
        productManager.displayProductIds();

        // Remove a product ID
        productManager.removeProduct("P002");

        // Display updated product IDs
        productManager.displayProductIds();
    }
}

