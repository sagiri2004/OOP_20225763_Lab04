package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private static Store store;

    public StoreScreen(Store store) {
        StoreScreen.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createHeader());
        north.add(createMenuBar());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        smUpdateStore.getItem(0).addActionListener(e -> new AddBookToStoreScreen().setVisible(true));
        smUpdateStore.getItem(1).addActionListener(e -> new AddCompactDiscToStoreScreen().setVisible(true));
        smUpdateStore.getItem(2).addActionListener(e -> new AddDigitalVideoDiscToStoreScreen().setVisible(true));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));

        cartButton.addActionListener(e -> openCartScreen());

        header.add(Box.createRigidArea(new Dimension(10, 0)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 0)));

        return header;
    }

    private void openCartScreen() {
        new CartScreen(store.getCart());
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 2, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 6 && i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public void updateStoreDisplay() {
        Container cp = getContentPane();
        cp.removeAll();

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public static void init() {
        store = new Store();

        store.addMedia(new Book(1, "Harry Potter", "Fantasy", 19.99f));
        store.addMedia(new Book(2, "The Hobbit", "Adventure", 15.99f));

        store.addMedia(new DigitalVideoDisc("The Lord of the Rings", "Fantasy", "Peter Jackson", 149, 24.99f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 22.99f));

        store.addMedia(new CompactDisc(3, "Thriller", "Pop", 14.99f, 42, "Quincy Jones", "Michael Jackson"));
        store.addMedia(new CompactDisc(4, "Back in Black", "Rock", 17.99f, 40, "Mutt Lange", "AC/DC"));

        StoreScreen storeScreen = new StoreScreen(store);
        storeScreen.updateStoreDisplay();
    }

    public static void main(String[] args) {
        init();
    }
}
