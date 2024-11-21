package com.tap.model;

public class CartItem {
    private int itemId;
    private int restaurantId; // Corrected spelling
    private String name;
    private int quantity;
    private double price;
    private double subtotal; // This field will store the subtotal for this item
    private String img_path;

    // Default constructor
    public CartItem() {
        // No need for super() as there is no parent class requiring it
    }

    public CartItem(int itemId, int restaurantId, String name, int quantity, double price, String img_path) {
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.name = name != null ? name : "Unknown";
        this.quantity = quantity > 0 ? quantity : 1;
        this.price = price > 0 ? price : 0.0;
        this.img_path = img_path;
        updateSubtotal(); // Initialize subtotal
        
        // Debugging line to check if CartItem is created successfully
        System.out.println("CartItem created: " + this.toString());
    }

    // Method to recalculate the subtotal
    private void updateSubtotal() {
        this.subtotal = quantity * price; // Update subtotal
    }

    // Getters and setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getRestaurantId() {  // Corrected getter name
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {  // Corrected setter name
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null ? name : "Unknown";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.quantity = quantity;
        updateSubtotal(); // Update subtotal when quantity changes
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        this.price = price;
        updateSubtotal(); // Update subtotal when price changes
    }

    public double getSubtotal() {
        return subtotal;
    }

    public String getimg_path() {
        return img_path;
    }

    public void setimg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "CartItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", name=" + name +
               ", quantity=" + quantity + ", price=" + price + ", subtotal=" + subtotal + ", img_path=" + img_path + "]";
    }
}
