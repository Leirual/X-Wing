import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

	Stage stage;
	Scene scene1, scene2;
	Button button1, button2;	
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		
		Label label1 = new Label("Pierwszy ekran");
		Label label2 = new Label("Drugi ekran");
		
		button1 = new Button("Idź do drugiego ekranu");
		button1.setText("No dajesz!");
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(scene2);
			}
		});
		
		button2 = new Button();
		button2.setText("No to powrót");
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(Test.this.scene1);
			}
		});
		
		VBox layout1 = new VBox(30);
		layout1.getChildren().addAll(button1, label1);
		scene1 = new Scene(layout1, 250, 250);
				
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(label2, button2);
		scene2 = new Scene(layout2, 300, 300);
		
		stage.setScene(scene1);
		stage.setTitle("Test");
		stage.show();
		
		
	}

	
	
	
	
}
