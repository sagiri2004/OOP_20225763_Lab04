package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen() {
        super("CD");
    }

    @Override
    protected Media createMediaItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String director = JOptionPane.showInputDialog(this, "Enter director name:");
        String artist = JOptionPane.showInputDialog(this, "Enter artist name:");
        int length = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter CD length:"));
        float cost = Float.parseFloat(costField.getText());
        return new CompactDisc(0, title, category, cost, length, director, artist);
    }
}
