package WeekOne.Collections;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> items;
    // Constructor
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // Method to add an item to the cart
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " added to the cart.");
    }

    // Method to remove an item from the cart
    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println(item + " removed from the cart.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    public void getItemByIndex(int index) {
        System.out.println("Item at given index is " + items.get(index));
    }

    // Method to display items in the cart
    public void displayCart() {
        System.out.println("Items in the cart:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a new shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add items to the cart
        cart.addItem("Laptop");
        cart.addItem("Headphones");
        cart.addItem("Mouse");

        // Display the contents of the cart
        cart.displayCart();

        // Remove an item from the cart
        cart.removeItem("Mouse");

        // Display the updated contents of the cart
        cart.displayCart();

        cart.getItemByIndex(1);
    }
}

