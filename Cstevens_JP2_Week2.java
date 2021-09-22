package cstevens_jp2_week2;

/**
 * @Course: SDEV 250 ~ Java Programming II
 * @Author Name: Chad Stevens
 * @Assignment Name: Week 2 Assignment
 * @Date: September 19, 2021
 * @Description: Java FX Event-Driven Code
 */

// Imports
import static java.lang.Math.random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Cstevens_JP2_Week2 extends Application {
    private final CirclePane circlePane;
    private final SquarePane squarePane;
    
           
    BorderPane borderPane = new BorderPane();

    public Cstevens_JP2_Week2() {
        this.circlePane = new CirclePane();
        this.squarePane = new SquarePane();
    }
    
    @Override
    public void start(Stage primaryStage) {        
        
        // Hold six buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        Button btSquare = new Button("Add Square");
        Button btCircle = new Button("Add Circle");
        Button btColor = new Button("Change Color");
        Button btExit = new Button("Exit");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);
        hBox.getChildren().add(btSquare);
        hBox.getChildren().add(btCircle);
        hBox.getChildren().add(btColor);
        hBox.getChildren().add(btExit);
        hBox.setStyle("-fx-border-color: white");
        hBox.setPadding(new Insets(10,10,10,10));
                
        // Register Handlers
        btEnlarge.setOnAction(new EnlargeHandler());
        btShrink.setOnAction(new ShrinkHandler());
        btSquare.setOnAction(new AddSquareHandler());
        btCircle.setOnAction(new AddCircleHandler());
        btColor.setOnAction(new ChangeColorHandler());
        btExit.setOnAction(new ExitHandler());

        // Place the HBox in the bottom of the BorderPane
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        borderPane.setStyle("-fx-background-color: black");
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 600, 450);
        primaryStage.setTitle("Fun with Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();        
    }
    
    // Create handler external classes    
    class AddCircleHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            borderPane.setCenter(circlePane);
            circlePane.addcircle();
        }
    }
    
    class AddSquareHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            borderPane.setCenter(squarePane);
            squarePane.addsquare();
        }
    }
    
    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            circlePane.enlarge();
            squarePane.enlarge();
        }
    }
    
    class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            circlePane.shrink();
            squarePane.shrink();
        }
    }

    class ChangeColorHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            circlePane.color();
            squarePane.color();
        }
    }
    
    class ExitHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            Platform.exit();
        }
    }    
    
}

// CirclePane Subclass
class CirclePane extends StackPane {
    private final Circle circle;

    CirclePane() {
        this.circle = new Circle(50);
    }
    
    public void addcircle() {
        getChildren().add(circle);
        circle.setStroke(Color.WHITE);
        circle.setFill(Color.LIGHTCYAN);
    }
    
    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);
    }
    
    public void shrink() {
        circle.setRadius(circle.getRadius() - 2);
    }
    
    public void color() {
        circle.setFill(Color.color(random(), random(), random()));
    }
}

// SquarePane subclass
class SquarePane extends StackPane {
    private final Rectangle square;

    SquarePane() {
        this.square = new Rectangle(75, 75);
    }
    
    public void addsquare() {
        getChildren().add(square);
        square.setStroke(Color.WHITE);
        square.setFill(Color.LIGHTCYAN);
    }
    
    public void enlarge() {
        square.setWidth(square.getWidth() + 5);
        square.setHeight(square.getHeight() + 5);
    }
    
    public void shrink() {
        square.setWidth(square.getWidth() - 5);
        square.setHeight(square.getHeight() - 5);
    }
    
    public void color() {
        square.setFill(Color.color(random(), random(), random()));
    }    
}

