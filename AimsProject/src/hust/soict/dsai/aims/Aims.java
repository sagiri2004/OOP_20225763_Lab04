package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        addSampleMedia(store);

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    viewCart(cart, scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore(Store store, Cart cart, Scanner scanner) {
        System.out.println("Items in store:");
        for (Media media : store.getMediaList()) {
            System.out.println(media.toString());
        }

        storeMenu(scanner, store, cart);
    }

    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                seeMediaDetails(scanner, store);
                break;
            case 2:
                addMediaToCart(scanner, store, cart);
                break;
            case 3:
                System.out.print("Enter the title of the media to play: ");
                String titleToPlay = scanner.nextLine();
                Media mediaToPlay = store.searchMediaByTitle(titleToPlay);
                if (mediaToPlay != null) {
                    playMedia(mediaToPlay);
                } else {
                    System.out.println("Media with the title '" + titleToPlay + "' not found.");
                }
                break;
            case 4:
                viewCart(cart, scanner);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    public static void seeMediaDetails(Scanner scanner, Store store) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(scanner, media);
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addToCart(media);
                break;
            case 2:
                playMedia(media);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }


    public static void addToCart(Media media) {
        System.out.println(media.getTitle() + " added to the cart.");
    }

    public static void addMediaToCart(Scanner scanner, Store store, Cart cart) {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();

        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println(media.getTitle() + " added to cart.");
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void viewCart(Cart cart, Scanner scanner) {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Current items in the cart:");
            for (Media media : cart.getItemsOrdered()) {
                System.out.println(media.toString());
            }
            System.out.println("Total cost: $" + cart.totalCost());
        }

        cartMenu(scanner, cart);
    }

    public static void cartMenu(Scanner scanner, Cart cart) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                filterMediasInCart(scanner, cart);
                break;
            case 2:
                sortMediasInCart(scanner, cart);
                break;
            case 3:
                removeMediaFromCart(cart, scanner);
                break;
            case 4:
                playMediaFromCart(cart, scanner);
                break;
            case 5:
                placeOrder(cart);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    public static void filterMediasInCart(Scanner scanner, Cart cart) {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.print("Please choose a number: 1-2: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter the ID to filter by: ");
                int id = scanner.nextInt();
                cart.searchById(id);
                break;
            case 2:
                System.out.print("Enter the title to filter by: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void sortMediasInCart(Scanner scanner, Cart cart) {
        System.out.println("Sort by: ");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.print("Please choose a number: 1-2: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void removeMediaFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        boolean removed = cart.removeMediaByTitle(title);
        if (removed) {
            System.out.println("Media removed from the cart.");
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    public static void playMediaFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();

        Media media = cart.getMediaByTitle(title);
        if (media != null) {
            playMedia(media);
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    public static void placeOrder(Cart cart) {
        if (!cart.getItemsOrdered().isEmpty()) {
            System.out.println("An order has been created.");
            cart.clearCart();
            System.out.println("The cart is now empty.");
        } else {
            System.out.println("Your cart is empty. Cannot place an order.");
        }
    }

    public static void updateStore(Store store, Scanner scanner) {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.print("Please choose an option: 1-2: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addMediaToStore(store, scanner);
                break;
            case 2:
                removeMediaFromStore(store, scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void addMediaToStore(Store store, Scanner scanner) {
        System.out.println("Choose the type of media to add:");
        System.out.println("1. Digital Video Disc (DVD)");
        System.out.println("2. Book");
        System.out.println("3. Compact Disc (CD)");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Media media = null;

        switch (choice) {
            case 1:
                System.out.print("Enter title of DVD: ");
                String dvdTitle = scanner.nextLine();
                System.out.print("Enter category of DVD: ");
                String dvdCategory = scanner.nextLine();
                System.out.print("Enter director of DVD: ");
                String dvdDirector = scanner.nextLine();
                System.out.print("Enter length of DVD: ");
                int dvdLength = scanner.nextInt();
                System.out.print("Enter cost of DVD: ");
                float dvdCost = scanner.nextFloat();
                scanner.nextLine();

                media = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
                break;

            case 2:
                System.out.print("Enter title of Book: ");
                String bookTitle = scanner.nextLine();
                System.out.print("Enter category of Book: ");
                String bookCategory = scanner.nextLine();
                System.out.print("Enter cost of Book: ");
                float bookCost = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Enter the number of authors: ");
                int numAuthors = scanner.nextInt();
                scanner.nextLine();

                Book book = new Book(0, bookTitle, bookCategory, bookCost);
                for (int i = 0; i < numAuthors; i++) {
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();
                    book.addAuthor(authorName);
                }
                media = book;
                break;

            case 3:
                System.out.print("Enter title of CD: ");
                String cdTitle = scanner.nextLine();
                System.out.print("Enter category of CD: ");
                String cdCategory = scanner.nextLine();
                System.out.print("Enter director of CD: ");
                String cdDirector = scanner.nextLine();
                System.out.print("Enter artist of CD: ");
                String artist = scanner.nextLine();
                System.out.print("Enter number of tracks in CD: ");
                int numTracks = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter cost of CD: ");
                float cdCost = scanner.nextFloat();
                scanner.nextLine();

                CompactDisc cd = new CompactDisc(0, cdTitle, cdCategory, cdCost, 0, cdDirector, artist);
                for (int i = 0; i < numTracks; i++) {
                    System.out.print("Enter track name: ");
                    String trackName = scanner.nextLine();
                    System.out.print("Enter track length (in seconds): ");
                    int trackLength = scanner.nextInt();
                    scanner.nextLine();
                    Track track = new Track(trackName, trackLength);
                    cd.addTrack(track);
                }
                media = cd;
                break;

            default:
                System.out.println("Invalid choice. Media not added.");
                return;
        }

        store.addMedia(media);
        System.out.println("Media added to the store.");
    }


    public static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.print("Enter title of media to remove: ");
        String title = scanner.nextLine();
        store.removeMediaByTitle(title);
        System.out.println("Media removed from the store.");
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
