package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;

    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Media '" + media.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("This media item already exists in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    public void displayStoreItems() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("********** Store Inventory **********");
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media media = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + media.toString());
            }
            System.out.println("************************************");
        }
    }

    public Media[] getMediaList() {
        return itemsInStore.toArray(new Media[0]);
    }

    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        System.out.println("No media found with title: " + title);
        return null;
    }

    public void removeMediaByTitle(String title) {
        Media mediaToRemove = searchMediaByTitle(title);
        if (mediaToRemove != null) {
            itemsInStore.remove(mediaToRemove);
            System.out.println("Media '" + title + "' has been removed from the store.");
        } else {
            System.out.println("No media found with title: " + title);
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
