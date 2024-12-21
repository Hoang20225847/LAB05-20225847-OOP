package hust.soict.hedspi.javafx;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {
	
	private RadioButton pen;
	
	private RadioButton eraser;

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();

    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Rectangle clipArea = new Rectangle(0, 0, drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
    	drawingAreaPane.setClip(clipArea);
    	Color colorOption = Color.BLACK;
    	if (eraser.isSelected()) {
    		colorOption = Color.WHITE;
    	}
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, colorOption);
    	drawingAreaPane.getChildren().add(newCircle);

    }
    void initialize() {
        assert drawingAreaPane != null : "fx:id=\"drawingAreaPane\" was not injected: check your FXML file 'Painter.fxml'.";

    }

}
