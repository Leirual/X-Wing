
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainUI extends Application{

	//public static Main game;
	
	Stage mainWindow;
	Scene loginScene, mainScene, loadScene, saveScene, rebelScene, imperialScene, scumScene;
	Button newGameButton, loadGameButton, saveGameButton, backFromLoadButton, backFromSaveButton, newWindowButton, closeButton, loginButton;
	private File file = new File("Save.txt");
	Label label3;
	
	public static int saveCount = 0;
	//public SaverClass saver;
	

	

	//-------------------------------------------------------------------------------------------------------	
	public static void main(String[] args) throws IOException {
		launch(args);
	}

	// main Javafx code
	public void start(Stage stage) throws Exception {
		mainWindow = stage;					// creating main window using an external variable
//-------------------------------------------------------------------------------------------------------	
		Label label2 = new Label("The Game");
		Label label3 = new Label("Game Loaded");
		Label label4 = new Label("Game Saved");
		Label buildListRebels = new Label("Build your Rebel list");
		Label buildListImperial = new Label("Build your Imperial list");
		Label buildListScum = new Label("Build your Scum list");
//-------------------------------------------------------------------------------------------------------			
		newGameButton = new Button("New Game");			// creating something to click :) - you can define it straight away in the brackets or define it in a setText method
		newGameButton.setOnAction(new EventHandler<ActionEvent>() {	// an anonymous inner class for handling events corresponding to this button (otherwise it should only be THIS in the bracket)
			public void handle(ActionEvent event){
				String faction = FactionWindow.Display("New Game", "Choose your faction");
				switch(faction){
				case "rebels":
					stage.setScene(rebelScene);
					break;
				case "imperials":
					stage.setScene(imperialScene);
					break;
				case "scum":
					stage.setScene(scumScene);
					break;
				default:
					stage.setScene(mainScene);
					break;
				}
			}
		});
//-------------------------------------------------------------------------------------------------------
// FILE LOADER
		loadGameButton = new Button("Load Game");
		loadGameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				/*try {
					saver.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				try {
		            FileReader reader = new FileReader(file);	// this reads the file
		            BufferedReader bReader = new BufferedReader(reader);	// wrapping the fileReader in a buffer
		            String line;
		            while ((line = bReader.readLine()) != null) {	// printing out text if there is one
		                System.out.println(line);
		                label3.setText("Loaded " + line);
		            }
		            reader.close();
		            stage.setScene(loadScene);		// setting new scene with load info
		        } catch (IOException e) {
		        	System.out.println("No games to load");
		        }
			}
		});
//-------------------------------------------------------------------------------------------------------
// FILE SAVER / REWRITER
		saveGameButton = new Button("Save Game");
		saveGameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				saveCount++;
				
				/*try {
					saver.save();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				if(file.exists()){
					try{
						FileWriter writer = new FileWriter(file);
						BufferedWriter bWriter = new BufferedWriter(writer);		
						bWriter.write("Save nr." + saveCount);
						bWriter.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}				
				}
				else{
					try {
						file.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					try{
						FileWriter writer = new FileWriter(file);
						BufferedWriter bWriter = new BufferedWriter(writer);		
						bWriter.write("Saved 1st game");
						bWriter.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}				
				}
				
				label4.setText("Saved game nr. " + saveCount);
				stage.setScene(saveScene);
			}
		});
//-------------------------------------------------------------------------------------------------------			
/*		button4 = new Button("Return to Main Menu");
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(scene1);
			}
		});*/
//-------------------------------------------------------------------------------------------------------		
		backFromLoadButton = new Button("Return to Main Menu");
		backFromLoadButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(mainScene);
			}
		});
//-------------------------------------------------------------------------------------------------------		
		backFromSaveButton = new Button("Return to Main Menu");
		backFromSaveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(mainScene);
			}
		});
//-------------------------------------------------------------------------------------------------------				
		newWindowButton = new Button("Open new window");
		newWindowButton.setOnAction(e-> {
			boolean result = ConfirmBox.Display("I'm a box!", "Are you smart enough?");
			if(result==true){
				stage.setTitle("Smarty pants...");
			}
			else{
				stage.setTitle("You live and learn...");
			}
		});
//-------------------------------------------------------------------------------------------------------		
		closeButton = new Button("Close");
		closeButton.setOnAction(e->closeProgram());
//-------------------------------------------------------------------------------------------------------		
		GridPane grid = new GridPane();				// making a GridPane login screen
		grid.setPadding(new Insets(20,10,0,10));
		grid.setVgap(5);
		grid.setHgap(5);
		
		Label login = new Label("login");						// creating login and password fields
		TextField loginInput = new TextField();
		Label password = new Label("password");
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("Password");				// it's different than default text
		
		loginButton = new Button("Login");						// login button
		loginButton.setOnAction(e->	
		{
			String loginString = loginInput.getText();			// checking to see if the login and password are correct
			String passwordString = passwordInput.getText();
			if(loginString.toLowerCase().equals("k") && passwordString.equals("a")){
				stage.setScene(mainScene);
			}
			else{												// creating an error box
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Warning");
                alert.setHeaderText("Login");
                alert.setContentText("Wrong login or password");
                alert.showAndWait();	
			}
		});
		Label label1 = new Label("Welcome " + loginInput.getText() + ", man!");		// LABEL is a text the user can't interact with
		
		GridPane.setConstraints(login, 0, 0);		// creating a gridpane - must be accessed in a static way (through the class, not the object)
		GridPane.setConstraints(loginInput, 1, 0);
		GridPane.setConstraints(password, 0, 1);
		GridPane.setConstraints(passwordInput, 1, 1);
		GridPane.setConstraints(loginButton, 0, 2);
		grid.getChildren().addAll(login, loginInput, password, passwordInput, loginButton);
		
		loginScene = new Scene(grid, 400, 400);
//-------------------------------------------------------------------------------------------------------			
		VBox leftMenu = new VBox(20);		// a layout that stacks things one on top of another with a spacing
		leftMenu.getChildren().addAll(newGameButton, loadGameButton, saveGameButton);		// adding a "child" to the "stage" (a button to the window layout)
		
		HBox topMenu = new HBox(20);
		topMenu.getChildren().addAll(label1, newWindowButton, closeButton);
		
		BorderPane borderPane = new BorderPane();		// making a BorderPane main menu
		borderPane.setLeft(leftMenu);
		borderPane.setTop(topMenu);		
		
		mainScene = new Scene(borderPane, 400, 400);
//-------------------------------------------------------------------------------------------------------		
		VBox rebelLayout = new VBox();
		rebelLayout.getChildren().addAll(buildListRebels);		
		rebelScene = new Scene(rebelLayout, 400, 200);
		
		VBox imperialLayout = new VBox();		
		imperialLayout.getChildren().addAll(buildListImperial);		
		imperialScene = new Scene(imperialLayout, 400, 200);
		
		VBox scumLayout = new VBox();		
		scumLayout.getChildren().addAll(buildListScum);		
		scumScene = new Scene(scumLayout, 400, 200);
//-------------------------------------------------------------------------------------------------------		
		VBox layout3 = new VBox(5);
		layout3.getChildren().addAll(label3, backFromLoadButton);
		loadScene = new Scene(layout3, 500, 50);
//-------------------------------------------------------------------------------------------------------		
		VBox layout4 = new VBox(5);
		layout4.getChildren().addAll(label4, backFromSaveButton);
		saveScene = new Scene(layout4, 500, 500);
//-------------------------------------------------------------------------------------------------------	
		mainWindow.setScene(loginScene);		// setting up the main window
		mainWindow.setTitle("X-wing miniatures game");
		mainWindow.setOnCloseRequest(e-> {
			e.consume();				// taking care of a java event on our own (stopping it from continuing)
			closeProgram();
		});
		mainWindow.show();	
	}

//-------------------------------------------------------------------------------------------------------		
	private void closeProgram() {		// method for saving before close and closing
		boolean answer = ConfirmBox.Display("EXIT Window", "Are you sure you want to exit?");
		if(answer == true){
			saveCount++;
			if(file.exists()){
				try{
					FileWriter writer = new FileWriter(file);
					BufferedWriter bWriter = new BufferedWriter(writer);		
					bWriter.write("Save nr." + saveCount);
					bWriter.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}				
			}
			else{
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try{
					FileWriter writer = new FileWriter(file);
					BufferedWriter bWriter = new BufferedWriter(writer);		
					bWriter.write("Saved 1st game");
					bWriter.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}				
			}
			System.out.println("Saved game nr. " + saveCount);
			mainWindow.close();
		}
	}
	
/*	public static int getSaveCount() {
		return saveCount;
	}

	public static void setSaveCount(int saveCount) {
		MainUI.saveCount = saveCount;
	}*/
}
