package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen() {
        super("DVD");
    }

    @Override
    protected Media createMediaItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String director = JOptionPane.showInputDialog(this, "Enter director name:");
        int length = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter DVD length:"));
        float cost = Float.parseFloat(costField.getText());
        return new DigitalVideoDisc(title, category, director, length, cost);
    }
}
