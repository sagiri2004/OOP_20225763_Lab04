package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.screen.CartScreen;

public class Aims {

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        addSampleMedia(store);

        StoreScreen storeScreen = new StoreScreen(store);

        CartScreen cartScreen = new CartScreen(cart);
    }

    public static void addSampleMedia(Store store) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 22.99f);

        Book book1 = new Book(101, "Effective Java", "Programming", 45.99f);
        book1.addAuthor("Joshua Bloch");
        Book book2 = new Book(102, "Clean Code", "Programming", 39.99f);
        book2.addAuthor("Robert C. Martin");
        Book book3 = new Book(103, "The Pragmatic Programmer", "Programming", 44.99f);
        book3.addAuthor("Andrew Hunt");

        CompactDisc cd1 = new CompactDisc(201, "Thriller", "Pop", 15.99f, 42, "Quincy Jones", "Michael Jackson");
        cd1.addTrack(new Track("Wanna Be Startin' Somethin'", 6));
        cd1.addTrack(new Track("Thriller", 5));
        CompactDisc cd2 = new CompactDisc(202, "Back in Black", "Rock", 18.99f, 42, "Mutt Lange", "AC/DC");
        cd2.addTrack(new Track("Hells Bells", 5));
        cd2.addTrack(new Track("Back in Black", 4));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(cd1);
        store.addMedia(cd2);

        System.out.println("Sample media added to the store.");
    }
}
