package panes;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Grid extends Application {
	static final Image rooster = new Image("myResources/rooster.jpg");
	
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

	public GridPane addGridPane() {
	    GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 10, 0, 10));

	    for(int col = 0; col < 10; col++)
	    		for(int row = 0; row < 10; row++) {
	    			fillInCell(grid, col, row); 
	    		}
//	    // Title in column 3, row 1
//	    Text chartTitle = new Text("Current Year");
//	    chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//	    grid.add(chartTitle, 2, 0);
//
//	    // Subtitle in columns 2-3, row 2
//	    //void javafx.scene.layout.GridPane.add(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)
//	    Text chartSubtitle = new Text("col 1 (2 columns ...)\nrow 1(1)");
//	    grid.add(chartSubtitle, 1, 1, 2, 1);
//
//	    // House icon in column 1, rows 1-2
//	    grid.add(new ImageView(rooster), 0, 0, 1, 2); 
//
//	    // Left label in column 1 (bottom), row 3
//	    Text goodsPercent = new Text("Goods\n80%");
//	    GridPane.setValignment(goodsPercent, VPos.BOTTOM);
//	    grid.add(goodsPercent, 0, 2); 
//
//	    // Chart in columns 2-3, row 3
//	    grid.add(new ImageView(rooster), 1, 2, 2, 1); 
//
//	    Text servicesPercent = new Text("col 3\nrow 2");
//	    GridPane.setValignment(servicesPercent, VPos.TOP);
//	    grid.add(servicesPercent, 3, 2);

	    grid.setGridLinesVisible(true);
	    return grid;
	}

	private void fillInCell(GridPane grid, int col, int row) {
		Text category = new Text("" + col + row);
	    category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(category, col, row);
	}
	@Override
	// entry point for JavaFX applications
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grid Pane");
        GridPane root = addGridPane();
		Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
