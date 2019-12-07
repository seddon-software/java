package basic;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button button1 = new Button();
        Button button2 = new Button();
        button1.setText("Say 'Hello World'");
        button1.setOnAction( (ActionEvent event) -> System.out.println("Hello World!"));
        button2.setText("Say 'Goodbye Universe'");
        button2.setOnAction( (ActionEvent event) -> System.out.println("Goodbye Universe!"));
        button1.setCenterShape(true);
        FlowPane root = new FlowPane(Orientation.VERTICAL);
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}