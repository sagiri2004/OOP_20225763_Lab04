package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Jungle Book", "Animation", "Jon Favreau", 118, 15.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella", "Fairy Tale", "Kenneth Branagh", 105, 12.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", "Jon Favreau", 118, 14.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladdin", "Fairy Tale", "Guy Ritchie", 128, 13.99f);

        Store store = new Store();

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);

        store.displayStoreItems();
        store.removeMedia(dvd2);
        store.displayStoreItems();

        DigitalVideoDisc dvdNotInStore = new DigitalVideoDisc("Mulan", "Fairy Tale", "Tony Bancroft", 88, 11.99f);
        store.removeMedia(dvdNotInStore);
    }
}
