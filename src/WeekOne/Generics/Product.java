package WeekOne.Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private String name;
    private double price;
    private String category;

    // Constructor
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Sample list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.0, "Electronics"));
        products.add(new Product("Shirt", 25.0, "Fashion"));
        products.add(new Product("Headphones", 80.0, "Electronics"));
        products.add(new Product("Watch", 150.0, "Fashion"));
        products.add(new Product("Mobile Phone", 700.0, "Electronics"));

        // Filter products with price above 100
        List<Product> expensiveProducts = products.stream()
                .filter(product -> product.getPrice() > 100)
                .toList();

        // Print the names of expensive products
        System.out.println("Expensive Products:");
        expensiveProducts.forEach(product -> System.out.println(product.getName()));
    }
}
