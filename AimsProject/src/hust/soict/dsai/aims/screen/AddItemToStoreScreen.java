package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;

    public AddItemToStoreScreen(String itemType) {
        setTitle("Add " + itemType + " to Store");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createFormPanel(), BorderLayout.CENTER);
        cp.add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));

        formPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        formPanel.add(titleField);

        formPanel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        formPanel.add(categoryField);

        formPanel.add(new JLabel("Cost:"));
        costField = new JTextField();
        formPanel.add(costField);

        return formPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(e -> {
            try {
                Media item = createMediaItem();
                System.out.println(item.getClass().getSimpleName() + " added: " + item.toString());
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for cost.");
            }
        });
        buttonPanel.add(addButton);
        return buttonPanel;
    }

    protected abstract Media createMediaItem();
}
