import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
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

	/*static String faction = "coś";
	String item;*/
	
//-------------------------------------------------------------------------------------------------------			
	public static void /*String*/ Display(String title, String message){	// the main method for displaying the entire window
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
		/*ChoiceBox<String> choice = new ChoiceBox<>();		// creating a main choicebox object (singular choice)
		choice.getItems().add("Rebels");			// adding objects (or text) to the boxes
		choice.getItems().add("Imperials");
		choice.getItems().add("Scum");
		choice.setValue("none");					// default visible value
		choice.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> System.out.println(newValue));	//listening*/
//-------------------------------------------------------------------------------------------------------		
		ComboBox<String> factionBox;
		factionBox = new ComboBox<>();
		factionBox.getItems().addAll("Rebels", "Imperials", "Scum");
		factionBox.setPromptText("Choose your faction!");
		factionBox.setValue("none");				// setting the default value for the box
		
		//factionBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> System.out.println(newValue));	// printing the selection
		//factionBox.setOnAction(e-> System.out.println("User selected " + factionBox.getValue()));		// same as above
//-------------------------------------------------------------------------------------------------------
		Button nextButton = new Button("Next");		// creating a button with 2 functions
		nextButton.setOnAction(e->{
			getFaction(factionBox);					// do the getFaction method and close the window, setting the faction variable
			//window.close();
		});	
//-------------------------------------------------------------------------------------------------------		
		VBox mainLayout = new VBox(10);				// creating the layout
		mainLayout.getChildren().addAll(label, /*tree,*/ factionBox,  /*listView,*/ /*choice, rebels, imperials, scum,*/ nextButton);
		mainLayout.setAlignment(Pos.CENTER);				
		Scene factionScene = new Scene(mainLayout, 200, 200);
//-------------------------------------------------------------------------------------------------------				
		window.setScene(factionScene);
		window.showAndWait();	
	}
//-------------------------------------------------------------------------------------------------------		
// FUNCTION FOR CHECKING WHICH FACTION WAS CHOSEN AND LAUNCHING THE APROPRIATE WINDOW OR ERROR
	private static void getFaction(ComboBox<String> comboBox){
		if(comboBox.getValue().equals("Rebels")){
			RebelWindow.Display("Rebel Window", "Choose your forces");
		}
		else if(comboBox.getValue().equals("Imperials")){
			ImperialWindow.Display("Imperial Window", "Choose your forces");
		}
		else if(comboBox.getValue().equals("Scum")){
			ScumWindow.Display("Scum Window", "Choose your forces");
		}
		else if(comboBox.getValue().equals("none"))/*(comboBox.getSelectionModel().getSelectedIndex() == -1)*/{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Warning");
            alert.setHeaderText("Login");
            alert.setContentText("Pick a faction to proceed.");
            alert.showAndWait();	
		}
	}
	

}
