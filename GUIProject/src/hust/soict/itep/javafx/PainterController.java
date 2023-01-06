package hust.soict.itep.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private Boolean eraser = false;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if(eraser == false){
            Circle newCircle = new Circle(event.getX(),event.getY(),4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }else{
            Circle newCircle = new Circle(event.getX(),event.getY(),10, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    @FXML
    void eraserTool(ActionEvent event) {
        if(eraser == false){
            eraser = true;
        }
        else {
            eraser = false;
        }
    }
}
