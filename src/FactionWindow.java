import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
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
//-------------------------------------------------------------------------------------------------------		
public class FactionWindow {

	Scene rebelPick, imperialPick, scumPick, factionScene;
	static String faction;
//-------------------------------------------------------------------------------------------------------			
	public static String Display(String title, String message){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);	// blocks other window interaction until you deal with this one
		window.setTitle(title);
		window.setMinWidth(300);
		window.setMinHeight(300);
		Label label = new Label(message);
//-------------------------------------------------------------------------------------------------------			
		/*CheckBox rebels = new CheckBox("Rebels");			// creating checkboxes (multiple choice)
		CheckBox imperials = new CheckBox("Imperials");
		CheckBox scum = new CheckBox("Scum and Villainy");*/
//-------------------------------------------------------------------------------------------------------				
		ChoiceBox<String> choice = new ChoiceBox<>();		// creating a main choicebox object (singular choice)
		
		choice.getItems().add("Rebels");			// adding objects (or text) to the boxes
		choice.getItems().add("Imperials");
		choice.getItems().add("Scum");
		
		choice.setValue("Rebels");					// default visible value
		
		choice.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> System.out.println(newValue));
		
		
//-------------------------------------------------------------------------------------------------------				
		Button nextButton = new Button("Next");		// creating a button with 2 functions
		nextButton.setOnAction(e-> 
		{
			getChoice(choice);	
			window.close();
		});
//-------------------------------------------------------------------------------------------------------		
		VBox mainLayout = new VBox(10);				// creating the layout
		mainLayout.getChildren().addAll(label, choice, /*rebels, imperials, scum,*/ nextButton);
		mainLayout.setAlignment(Pos.CENTER);				
		Scene factionScene = new Scene(mainLayout, 200, 200);
//-------------------------------------------------------------------------------------------------------				
		window.setScene(factionScene);
		window.showAndWait();	
	
		return faction;								// the whole window method returns the "faction" value, set by the getChoice method bellow
	}
//-------------------------------------------------------------------------------------------------------		
	private static void getChoice(ChoiceBox<String> choice){
		if(choice.getValue().equals("Rebels")){
			faction = "rebels";
		}
		else if(choice.getValue().equals("Imperials")){
			faction = "imperials";
		}
		else if(choice.getValue().equals("Scum")){
			faction = "scum";
		}		
	}	
}
