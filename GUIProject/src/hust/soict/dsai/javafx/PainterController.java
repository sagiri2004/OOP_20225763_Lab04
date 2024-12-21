package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton pen;

    @FXML
    private RadioButton eraser;

    @FXML
    private ColorPicker colorPicker;

    // Clear all drawings
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color inkColor = pen.isSelected() ? colorPicker.getValue() : Color.WHITE;
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void initialize() {
        assert drawingAreaPane != null : "fx:id=\"drawingAreaPane\" was not injected: check your FXML file 'Painter.fxml'.";
        assert pen != null : "fx:id=\"pen\" was not injected: check your FXML file 'Painter.fxml'.";
        assert eraser != null : "fx:id=\"eraser\" was not injected: check your FXML file 'Painter.fxml'.";
        assert colorPicker != null : "fx:id=\"colorPicker\" was not injected: check your FXML file 'Painter.fxml'.";

        pen.setSelected(true);
    }
}
