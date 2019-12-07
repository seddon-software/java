package panes;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class VerticalBoxes extends Application {
	// never called - just there to keep Eclipse happy
	public static void main(String[] args) {
        launch(args);
    }
	
	public VBox createVBox(int n) {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(15, 12, 15, 12));
	    vbox.setSpacing(10);
	    vbox.setStyle("-fx-background-color: #336699;");

	    Button buttonA = new Button("Button" + n + "A");
	    Button buttonB = new Button("Button" + n + "B");
	    buttonA.setPrefSize(100, 20);
	    buttonB.setPrefSize(100, 20);
	    vbox.getChildren().addAll(buttonA, buttonB);
	    return vbox;
	}

	private VBox[] createVBoxes() {
		VBox[] verticalBoxes = new VBox[5];
		for(int i = 0; i < 5; i++) {
			verticalBoxes[i] = createVBox(i);
			// note non-static method
	        verticalBoxes[i].setAlignment(Pos.CENTER);
		}
		return verticalBoxes;
		
	}
	
	private Button createButton(int n) {
		// each button has text, style class, action
        Button button = new Button();
        button.setText("Button " + n);
        button.getStyleClass().add("custom-button");
        button.setOnAction( (ActionEvent event) -> System.out.println("This is button " + n));
		return button;
	}

	private Button[] createButtons() {
		// buttons have alignment property
		Button[] buttons = new Button[5];
		for(int i = 0; i < 5; i++) {
			buttons[i] = createButton(i);
	        BorderPane.setAlignment(buttons[i], Pos.CENTER);
		}
		return buttons;
	}
	
	@Override
	// entry point for JavaFX applications
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Panes");
        BorderPane root = new BorderPane();
        VBox[] verticalBoxes = createVBoxes();
        root.setTop(verticalBoxes[0]);
        root.setBottom(verticalBoxes[1]);
        root.setLeft(verticalBoxes[2]);
        root.setRight(verticalBoxes[3]);
        root.setCenter(verticalBoxes[4]);
		Scene scene = new Scene(root, 400, 400);
		// add a stylesheet to scene
		scene.getStylesheets().add("resources/mystyles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
