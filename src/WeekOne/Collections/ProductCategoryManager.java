package WeekOne.Collections;

import java.util.HashMap;
import java.util.Map;

public class ProductCategoryManager {
    private Map<String, String> productCategories;

    // Constructor
    public ProductCategoryManager() {
        productCategories = new HashMap<>();
    }

    // Method to add a product and its category
    public void addProductCategory(String productName, String category) {
        productCategories.put(productName, category);
        System.out.println("Product '" + productName + "' added to category '" + category + "'.");
    }

    // Method to get the category of a product
    public String getCategory(String productName) {
        return productCategories.get(productName);
    }

    // Method to display all products and their categories
    public void displayProductCategories() {
        System.out.println("Product Categories:");
        for (Map.Entry<String, String> entry : productCategories.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", Category: " + entry.getValue());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a ProductCategoryManager object
        ProductCategoryManager categoryManager = new ProductCategoryManager();

        // Add some products and their categories
        categoryManager.addProductCategory("Laptop", "Electronics");
        categoryManager.addProductCategory("Shirt", "Fashion");
        categoryManager.addProductCategory("Headphones", "Electronics");

        // Display all product categories
        categoryManager.displayProductCategories();

        // Get the category of a specific product
        String category = categoryManager.getCategory("Shirt");
        System.out.println("Category of Shirt: " + category);
    }
}

