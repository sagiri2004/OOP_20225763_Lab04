package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

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

    public void printCartDetails() {
        System.out.println("*********************** CART ***********************");
        System.out.println("Ordered Items:");
        int index = 1;
        for (Media item : itemsOrdered) {
            System.out.println(index + ". " + item.toString());
            index++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("****************************************************");
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found item: " + item.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with title: " + title);
        }
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println("Found item: " + item.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with ID: " + id);
        }
    }

    public boolean removeMediaByTitle(String title) {
        Iterator<Media> iterator = itemsOrdered.iterator();
        while (iterator.hasNext()) {
            Media media = iterator.next();
            if (media.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Item removed: " + title);
                return true;
            }
        }
        System.out.println("No item found with title: " + title);
        return false;
    }

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost.");
    }

    public Media getMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        System.out.println("No media found with title: " + title);
        return null;
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Cart has been cleared.");
    }
}
