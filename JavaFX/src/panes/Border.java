package panes;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class Border extends Application {
	// never called - just there to keep Eclipse happy
	public static void main(String[] args) {
        launch(args);
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
			// note static method
			BorderPane.setAlignment(buttons[i], Pos.CENTER);
		}
		return buttons;
	}
	
	@Override
	// entry point for JavaFX applications
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Panes");
        BorderPane root = new BorderPane();
        Button[] buttons = createButtons();
        root.setTop(buttons[0]);
        root.setBottom(buttons[1]);
        root.setLeft(buttons[2]);
        root.setRight(buttons[3]);
        root.setCenter(buttons[4]);
		Scene scene = new Scene(root, 400, 400);
		// add a stylesheet to scene
		scene.getStylesheets().add("stylesheets/mystyles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
