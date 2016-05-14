
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

public class Main extends Application{

	Stage window;
	Scene scene0, scene1, scene2, scene3, scene4;
	Button button1, button2, button3, button4, button5, button6, button7, button8, loginButton;
	private File file = new File("SaveGame.txt");
	int saveCount = 0;
//-------------------------------------------------------------------------------------------------------	
	public static void main(String[] args) throws IOException {
		
		launch(args);
	}

	// main Javafx code
	public void start(Stage stage) throws Exception {
		window = stage;					// creating main window using an external variable
//-------------------------------------------------------------------------------------------------------	
		Label label2 = new Label("The Game");
		Label label3 = new Label("Game Loaded");
		Label label4 = new Label("Game Saved");
//-------------------------------------------------------------------------------------------------------			
		button1 = new Button("New Game");			// creating something to click :) - you can define it straight away in the brackets or define it in a setText method
		button1.setOnAction(new EventHandler<ActionEvent>() {	// an anonymous inner class for handling events corresponding to this button (otherwise it should only be THIS in the bracket)
			public void handle(ActionEvent event){
				stage.setScene(scene2);
			}
		});
//-------------------------------------------------------------------------------------------------------
// FILE LOADER
		button2 = new Button("Load Game");
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				try {
		            FileReader reader = new FileReader(file);	// this reads the file
		            BufferedReader bReader = new BufferedReader(reader);	// wrapping the fileReader in a buffer
		            String line;
		            while ((line = bReader.readLine()) != null) {	// printing out text if there is one
		                System.out.println(line);
		                label3.setText("Loaded " + line);
		            }
		            reader.close();
		            stage.setScene(scene3);		// setting new scene with load info
		        } catch (IOException e) {
		        	System.out.println("No games to load");
		        }
			}
		});
//-------------------------------------------------------------------------------------------------------
// FILE SAVER / REWRITER
		button3 = new Button("Save Game");
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				saveCount++;
				//file.deleteOnExit();		// this will delete the file after the program is done using it
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
				stage.setScene(scene4);
			}
		});
//-------------------------------------------------------------------------------------------------------			
		button4 = new Button("Return to Main Menu");
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(scene1);
			}
		});
//-------------------------------------------------------------------------------------------------------		
		button5 = new Button("Return to Main Menu");
		button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(scene1);
			}
		});
//-------------------------------------------------------------------------------------------------------		
		button6 = new Button("Return to Main Menu");
		button6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(scene1);
			}
		});
//-------------------------------------------------------------------------------------------------------				
		button7 = new Button("Open new window");
		button7.setOnAction(e-> {
			boolean result = ConfirmBox.Display("I'm a box!", "Are you smart enough?");
			if(result==true){
				stage.setTitle("Smarty pants...");
			}
			else{
				stage.setTitle("You live and learn...");
			}
		});
//-------------------------------------------------------------------------------------------------------		
		button8 = new Button("Close");
		button8.setOnAction(e->closeProgram());
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
			if(loginString.toLowerCase().equals("kris") && passwordString.equals("banan")){
				stage.setScene(scene1);
			}
			else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Warning");
                alert.setHeaderText("Login");
                alert.setContentText("Wrong login or password");
                alert.showAndWait();	
			}
		});
		Label label1 = new Label("Welcome " + loginInput.getText() + ", man!");		// LABEL is a text the user can't interact with
		
		GridPane.setConstraints(login, 0, 0);		// must be accessed in a static way (through the class, not the object)
		GridPane.setConstraints(loginInput, 1, 0);
		GridPane.setConstraints(password, 0, 1);
		GridPane.setConstraints(passwordInput, 1, 1);
		GridPane.setConstraints(loginButton, 0, 2);
		grid.getChildren().addAll(login, loginInput, password, passwordInput, loginButton);
		
		scene0 = new Scene(grid, 400, 400);
//-------------------------------------------------------------------------------------------------------			
		VBox leftMenu = new VBox(20);		// a layout that stacks things one on top of another with a spacing
		leftMenu.getChildren().addAll(button1, button2, button3);		// adding a "child" to the "stage" (a button to the window layout)
		
		HBox topMenu = new HBox(20);
		topMenu.getChildren().addAll(label1, button7, button8);
		
		BorderPane borderPane = new BorderPane();		// making a BorderPane main menu
		borderPane.setLeft(leftMenu);
		borderPane.setTop(topMenu);		
		
		scene1 = new Scene(borderPane, 400, 400);
//-------------------------------------------------------------------------------------------------------		
		StackPane layout2 = new StackPane();		
		layout2.getChildren().addAll(label2, button4);		
		scene2 = new Scene(layout2, 400, 200);		
//-------------------------------------------------------------------------------------------------------		
		VBox layout3 = new VBox(5);
		layout3.getChildren().addAll(label3, button5);
		scene3 = new Scene(layout3, 500, 50);
//-------------------------------------------------------------------------------------------------------		
		VBox layout4 = new VBox(5);
		layout4.getChildren().addAll(label4, button6);
		scene4 = new Scene(layout4, 500, 500);
//-------------------------------------------------------------------------------------------------------	
		window.setScene(scene0);		// setting up the main window
		window.setTitle("X-wing miniatures game");
		window.setOnCloseRequest(e-> {
			e.consume();				// taking care of a java event on our own (stopping it from continuing)
			closeProgram();
		});
		window.show();	
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
			window.close();
		}
	}
}
