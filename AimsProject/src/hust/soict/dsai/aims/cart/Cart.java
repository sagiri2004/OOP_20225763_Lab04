package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Use ObservableList to allow dynamic updates in the UI
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media item) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(item);
            System.out.println("Item added: " + item.getTitle());
        } else {
            System.out.println("The cart is full (Max 20 items).");
        }
    }

    public void removeMedia(Media item) {
        if (itemsOrdered.remove(item)) {
            System.out.println("Item removed: " + item.getTitle());
        } else {
            System.out.println("Item not found.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("Cart has been cleared.");
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost.");
    }

    public String placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return "Order failed: Cart is empty.";
        }

        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("*********************** ORDER DETAILS ***********************\n");
        for (Media item : itemsOrdered) {
            orderDetails.append(item.toString()).append("\n");
        }
        orderDetails.append("Total cost: ").append(totalCost()).append(" $\n");
        orderDetails.append("************************************************************\n");

        // Clear the cart after placing the order
        clear();
        return orderDetails.toString();
    }

    public void printCartDetails() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Cart Details:");
            for (Media item : itemsOrdered) {
                System.out.println(item.toString());
            }
        }
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {  // Assuming Media has a getId() method
                System.out.println("Item found: " + item.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item with ID " + id + " not found.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {  // Assuming Media has a getTitle() method
                System.out.println("Item found: " + item.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Item with title '" + title + "' not found.");
        }
    }

    public boolean removeMediaByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                itemsOrdered.remove(item);
                System.out.println("Item with title '" + title + "' has been removed.");
                return true;
            }
        }
        System.out.println("Item with title '" + title + "' not found.");
        return false;
    }

    public Media getMediaByTitle(String title) {
        System.out.println("Item with title '" + title + "' not found.");
        return null;
    }

    public void clearCart() {

    }
}
