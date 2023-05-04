import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.shape.Rectangle;

public class PaneOrganizer {

    /*
    This is the PaneOrganizer constructor. Follow the TODOs in the handout to fill it in
     */
    private BorderPane root;
    private MyRectangle movingRect;
    public PaneOrganizer(){
        this.root = new BorderPane();
        this.getRoot().setStyle("-fx-background-color: #e4cbff;");
        this.createButtonPane();
        this.createLabelPane();
        this.createRectsPane();
    }



    /*
     This method sets up the button pane. Follow the TODOs to in the handout fill it out
     You will call it in the PaneOrganizer constructor
     */
    private void createButtonPane(){
        Pane buttonPane = new Pane(); //This instantiates the button pane
        buttonPane.setPrefSize(Constants.BUTTON_PANE_WIDTH, Constants.BUTTON_PANE_HEIGHT); //This sets its size
        buttonPane.setStyle(Constants.BUTTON_PANE_COLOR); //This sets its color


        Button button = new Button("Quit"); //This instantiates the button
        root.setLeft(buttonPane);
        buttonPane.getChildren().add(button);
        button.setOnAction((ActionEvent e) -> System.exit(0));
        buttonPane.setFocusTraversable(false);
        button.setFocusTraversable(false);
    }

    private void handleKeyPress(KeyEvent e){
        KeyCode keyPressed = e.getCode();
        switch(keyPressed){
            case LEFT:
                movingRect.moveLeft();
                break;
            case RIGHT:
                movingRect.moveRight();
                break;
            default:
                break;
        }


        //this makes sure that once the user input is handled, the event is consumed
        e.consume();
    }

    private void createRectsPane(){
        Pane rectsPane = new Pane();
        rectsPane.setPrefSize(Constants.RECTS_PANE_WIDTH, Constants.RECTS_PANE_HEIGHT);
        rectsPane.setStyle("-fx-background-color: #ADD8E6");
        root.setCenter(rectsPane);
        MyRectangle stationaryRect = new MyRectangle(Constants.STATIONARY_RECT_XLOC,Constants.STATIONARY_RECT_YLOC,Constants.STATIONARY_RECT_COLOR,rectsPane);
        //i see that stationaryEct is not called again but deleting it would delete the rectangle from the scene so i am confused
        movingRect = new MyRectangle(Constants.MOVING_RECT_XLOC, Constants.MOVING_RECT_YLOC, Constants.MOVING_RECT_COLOR, rectsPane);
        rectsPane.setOnKeyPressed(KeyEvent-> this.handleKeyPress(KeyEvent));
        rectsPane.setFocusTraversable(true);


    }
    public void createLabelPane(){
        HBox labelPane = new HBox();
        labelPane.setPrefWidth(Constants.LABEL_PANE_WIDTH);
        labelPane.setPrefHeight(Constants.LABEL_PANE_HEIGHT);
        labelPane.setStyle("-fx-background-color: #87CEFA");
        Label l = new Label("Lab 4");
        labelPane.getChildren().add(l);
        labelPane.setAlignment(Pos.CENTER);
        root.setBottom(labelPane);

    }

    public BorderPane getRoot(){
        return this.root;
    }
}
