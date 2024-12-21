package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen() {
        super("Book");
    }

    @Override
    protected Media createMediaItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Book ID:"));
        return new Book(id, title, category, cost);
    }
}
