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

	static String faction = "coś";
	String item;
	
//-------------------------------------------------------------------------------------------------------			
	public static void /*String*/ Display(String title, String message){
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
		choice.setValue("Rebels");					// default visible value
		choice.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> System.out.println(newValue));	//listening*/
//-------------------------------------------------------------------------------------------------------		
		ComboBox<String> comboBox;
		comboBox = new ComboBox<>();
		comboBox.getItems().addAll("Rebels", "Imperials", "Scum");
		comboBox.setPromptText("Choose your faction!");
		
		comboBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> System.out.println(newValue));
		comboBox.setOnAction(e-> System.out.println("User selected " + comboBox.getValue()));		// same as above
//-------------------------------------------------------------------------------------------------------
		Button nextButton = new Button("Next");		// creating a button with 2 functions
		nextButton.setOnAction(e->{
			getFaction(comboBox);					// do the getFaction method and close the window, setting the faction variable
			window.close();
		});	
//-------------------------------------------------------------------------------------------------------		
		
		
		VBox mainLayout = new VBox(10);				// creating the layout
		mainLayout.getChildren().addAll(label, /*tree,*/ comboBox,  /*listView,*/ /*choice, rebels, imperials, scum,*/ nextButton);
		mainLayout.setAlignment(Pos.CENTER);				
		Scene factionScene = new Scene(mainLayout, 200, 200);
//-------------------------------------------------------------------------------------------------------				
		window.setScene(factionScene);
		window.showAndWait();	
	
		//return faction;								// the whole window method returns the "faction" value, set by the getChoice method bellow
	}
//-------------------------------------------------------------------------------------------------------		
	private static void getFaction(ComboBox<String> comboBox){
		if(comboBox.getValue().equals("Rebels")){
			RebelWindow.Display("Rebel Window", "Choose your forces");
		}
		else if(comboBox.getValue().equals("Imperials")){
			faction = "imperials";
		}
		else if(comboBox.getValue().equals("Scum")){
			faction = "scum";
		}
		else if(comboBox.getSelectionModel().getSelectedIndex() == -1){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Warning");
            alert.setHeaderText("Login");
            alert.setContentText("Pick a faction to proceed.");
            alert.showAndWait();	
		}
	}
	
	// creating tree branches
	public static TreeItem<String> makeBranch(String name, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<String>(name);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;		
	}

}
