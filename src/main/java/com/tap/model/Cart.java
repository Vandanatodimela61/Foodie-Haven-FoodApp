package com.tap.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items; // List to store cart items
    private double totalAmount;

    // Default constructor
    public Cart() {
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // Add an item to the cart
    public void addItem(CartItem item) {
        // Check if the item already exists in the cart
        boolean itemExists = false;
        for (CartItem cartItem : items) {
            if (cartItem.getItemId() == item.getItemId()) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity()); // Update quantity
                itemExists = true;
                break;
            }
        }
        
        if (!itemExists) {
            // If item doesn't exist, add it as a new item
            items.add(item);
        }

        // Recalculate total amount after adding/updating item
        recalculateTotalAmount();
    }

    // Update the quantity of an existing item in the cart
    public void updateItemQuantity(int itemId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        for (CartItem item : items) {
            if (item.getItemId() == itemId) {
                item.setQuantity(quantity); // Update the quantity
                recalculateTotalAmount(); // Recalculate total amount after updating the quantity
                return;
            }
        }
    }

    // Remove an item from the cart
    public void removeItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId); // Remove item by itemId
        recalculateTotalAmount(); // Recalculate total amount after removing the item
    }

    // Recalculate the total amount of the cart
    private void recalculateTotalAmount() {
        totalAmount = 0.0;
        // Iterate through all cart items and calculate the total amount
        for (CartItem item : items) {
            totalAmount += item.getSubtotal(); // Add the item's subtotal to total amount
        }
    }

    // Get the total amount of the cart
    public double getTotalAmount() {
        return totalAmount;
    }

    // Get all the items in the cart
    public List<CartItem> getItems() {
        return items;
    }

    // Check if the cart is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Clear the cart
    public void clear() {
        items.clear();
        totalAmount = 0.0;
    }

    // Override toString method for debugging purposes
    @Override
    public String toString() {
        return "Cart [items=" + items + ", totalAmount=" + totalAmount + "]";
    }
}
