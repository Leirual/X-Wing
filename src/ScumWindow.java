import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ScumWindow {
	
	static String treeItemSelected;
	static String listItemSelected;
//-------------------------------------------------------------------------------------------------------		
	public static void /*ListView<String>*/ Display(String title, String message){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);	// blocks other window interaction until you deal with this one
		window.setTitle(title);
		window.setMinWidth(300);
		window.setMinHeight(300);
		Label label = new Label(message);
//-------------------------------------------------------------------------------------------------------				
		TreeView<String> tree = new TreeView<>();		// creating new TreeView
		TreeItem<String> root, ships, upgrades;			// creating items of the type TreeItem<String>
	//root
		root = new TreeItem<>();		// establishing that root is a new TreeItem
		root.setExpanded(true);			// expanded by deafault
	//ships
		ships = makeBranch("Ships", root);		//creating branches with a custom makeBranch method that returns a TreeItem<String>
		makeBranch("X-wing", ships);
		makeBranch("Y-wing", ships);
	//upgrades
		upgrades = makeBranch("Upgrades", root);
		makeBranch("Elite", upgrades);
		makeBranch("Astromech", upgrades);
		makeBranch("Crew", upgrades);
	//create tree
		tree = new TreeView<String>(root);
		tree.setShowRoot(false);			// doesn't show the root
		tree.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> {
			treeItemSelected = newValue.getValue().toString();
		});
//-------------------------------------------------------------------------------------------------------	
		TreeView<String> squad = new TreeView<>();		// creating new TreeView
		TreeItem<String> root2;			// creating items of the type TreeItem<String>
	//root
		root2 = new TreeItem<>();		// establishing that root is a new TreeItem
		root2.setExpanded(true);			// expanded by deafault
	//ships
		ships = makeBranch("Ships", root2);		//creating branches with a custom makeBranch method that returns a TreeItem<String>
		makeBranch("X-wing", root2);
		makeBranch("Y-wing", root2);

	//create tree
		tree = new TreeView<String>(root2);
		tree.setShowRoot(false);			// doesn't show the root
		tree.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> {
			treeItemSelected = newValue.getValue().toString();
		});
		
		
		
//-------------------------------------------------------------------------------------------------------		
		ListView<String> listView = new ListView<>();
		//listView.getItems().addAll("Rebels", "Imperials", "Scum");
		//listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listView.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)-> {
			listItemSelected = newValue;
		});
//-------------------------------------------------------------------------------------------------------				
		Button addButton = new Button("Add");		// creating a button with 2 functions
		addButton.setOnAction(e-> 
		{
			listView.getItems().addAll(treeItemSelected);			
		});	
//-------------------------------------------------------------------------------------------------------		
		Button removeButton = new Button("Remove");		// creating a button with 2 functions
		removeButton.setOnAction(e-> 
		{
			listView.getItems().remove(listItemSelected);
		});
//-------------------------------------------------------------------------------------------------------				
		VBox mainLayout = new VBox(10);				// creating the layout
		mainLayout.getChildren().addAll(label, tree, addButton, listView, removeButton);
		mainLayout.setAlignment(Pos.CENTER);				
		Scene factionScene = new Scene(mainLayout, 200, 200);
	
		window.setScene(factionScene);
		window.showAndWait();
	}
//-------------------------------------------------------------------------------------------------------			
	public static TreeItem<String> makeBranch(String name, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<String>(name);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;		
	}
}
