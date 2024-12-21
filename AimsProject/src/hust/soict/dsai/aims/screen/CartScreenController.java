package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.PlayerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;

public class CartScreenController {
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnClearCart;

    @FXML
    private Button placeOrder;

    private Cart cart;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        ObservableList<Media> mediaList = FXCollections.observableArrayList(cart.getItemsOrdered());
        tblMedia.setItems(mediaList);

        updateCostLabel();
    }

    @FXML
    private void btnPlayPressed() throws PlayerException {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            selectedMedia.play();
        } else {
            showAlert("No item selected", "Please select a media item to play.");
        }
    }

    @FXML
    private void btnRemovePressed() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            tblMedia.getItems().remove(selectedMedia);
            updateCostLabel();
        } else {
            showAlert("No item selected", "Please select a media item to remove.");
        }
    }

    @FXML
    private void btnClearCartPressed() {
        cart.clear();
        tblMedia.getItems().clear();
        updateCostLabel();
    }

    @FXML
    private void placeOrderPressed() {
        if (!cart.getItemsOrdered().isEmpty()) {
            cart.placeOrder();
            tblMedia.getItems().clear();
            updateCostLabel();
            showAlert("Order Placed", "Your order has been placed successfully!");
        } else {
            showAlert("Cart is empty", "Please add items to the cart before placing an order.");
        }
    }

    private void updateCostLabel() {
        costLabel.setText(String.format("%.2f $", cart.totalCost()));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
