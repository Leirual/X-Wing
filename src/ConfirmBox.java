import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

	static boolean answer;
	
	public static boolean Display(String title, String message){
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);		// blocks other window interaction until you deal with this one
		window.setTitle(title);
		window.setMinWidth(300);
		
		Label label = new Label(message);

		Button yesButton = new Button("YES");
		yesButton.setOnAction(e-> {
			answer = true;
			window.close();
		});
		
		Button noButton = new Button("NO");
		noButton.setOnAction(e-> {
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 200, 200);
		window.setScene(scene);
		window.showAndWait();	
		
		return answer;
		
	}
	
}
