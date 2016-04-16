
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	Stage window;
	Scene scene1, scene2;
	Button button1, button2;
	
	public static void main(String[] args) {
		launch(args);
	}

	// main Javafx code
	public void start(Stage primaryStage) throws Exception {
		// WINDOW
		window = primaryStage;
		
		// Label 1
		Label label1 = new Label("Push the button to go to scene 2");		// LABEL is a text the user can't interact with
		
		// Button 1
		button1 = new Button();			// creating something to click :) - you can define it straight away in the brackets or define it in a setText method
		button1.setText("New Game");
		button1.setOnAction(new EventHandler<ActionEvent>() {	// an anonymous inner class for handling events corresponding to this button (otherwise it should only be THIS in the bracket)
			public void handle(ActionEvent event){
				window.setScene(scene2);
			}
		});
		
		// Layout 1
		VBox layout1 = new VBox(20);		// a layout that stacks thing one on top of a nother with a spacing
		layout1.getChildren().addAll(label1, button1);		// adding a "child" to the "stage" (a button to the window layout)
		scene1 = new Scene(layout1, 200, 200);		// creating a Scene
		
		// Label 2
		Label label2 = new Label("Now what do you want to do?");
		
		// Button 2
		button2 = new Button();
		button2.setText("Back to main menu");
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				window.setScene(scene1);
			}
		});
		
		// Layout2
		StackPane layout2 = new StackPane();		// a layout that stacks thing one on top of a nother with a spacing
		layout2.getChildren().addAll(label2, button2);		// adding a "child" to the "stage" (a button to the window layout)
		scene2 = new Scene(layout2, 400, 200);		// creating a Scene
	
		// Starting the WINDOW
		window.setScene(scene2);		// creating main window
		window.setTitle("X-wing miniatures game");
		window.show();
	}	
}
