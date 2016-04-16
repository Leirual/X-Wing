
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	Scene scene1, scene2, scene3, scene4;
	Button button1, button2, button3, button4, button5, button6;
//-------------------------------------------------------------------------------------------------------	
	public static void main(String[] args) throws IOException {
		
		launch(args);
	}

	// main Javafx code
	public void start(Stage stage) throws Exception {
//-------------------------------------------------------------------------------------------------------	
		Label label1 = new Label("Main Menu");		// LABEL is a text the user can't interact with
		Label label2 = new Label("The Game");
		Label label3 = new Label("Game Loaded");
		Label label4 = new Label("Game Saved");
//-------------------------------------------------------------------------------------------------------	
		button1 = new Button();			// creating something to click :) - you can define it straight away in the brackets or define it in a setText method
		button1.setText("New Game");
		button1.setOnAction(new EventHandler<ActionEvent>() {	// an anonymous inner class for handling events corresponding to this button (otherwise it should only be THIS in the bracket)
			public void handle(ActionEvent event){
				stage.setScene(scene2);
			}
		});
//-------------------------------------------------------------------------------------------------------
// FILE LOADER
		button2 = new Button();
		button2.setText("Load Game");
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				try {
		            FileReader reader = new FileReader("SaveGame.txt");
		            BufferedReader bReader = new BufferedReader(reader);
		            String line;
		            while ((line = bReader.readLine()) != null) {
		                System.out.println(line);
		            }
		            reader.close();
		            stage.setScene(scene3);
		        } catch (IOException e) {
		        	System.out.println("No games to load");
		        }				
			}
		});
//-------------------------------------------------------------------------------------------------------
// FILE SAVER / REWRITER
		button3 = new Button();
		button3.setText("Save Game");
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				File file = new File("SaveGame.txt");

				if(file.exists()){
					try{
						FileWriter writer = new FileWriter(file);
						BufferedWriter bWriter = new BufferedWriter(writer);		
						bWriter.write("Replaced old file");
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
						bWriter.write("Saved\n1st\ngame");
						bWriter.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}				
				}
				
				stage.setScene(scene4);
			}
		});
//-------------------------------------------------------------------------------------------------------			
		button4 = new Button();
		button4.setText("Return to Main Menu");
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(scene1);
			}
		});
//-------------------------------------------------------------------------------------------------------		
		button5 = new Button();
		button5.setText("Return to Main Menu");
		button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(scene1);
			}
		});
//-------------------------------------------------------------------------------------------------------		
		button6 = new Button();
		button6.setText("Return to Main Menu");
		button6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				stage.setScene(scene1);
			}
		});
//-------------------------------------------------------------------------------------------------------		
		VBox layout1 = new VBox(20);		// a layout that stacks thing one on top of a nother with a spacing
		layout1.getChildren().addAll(label1, button1, button2, button3);		// adding a "child" to the "stage" (a button to the window layout)
		scene1 = new Scene(layout1, 200, 200);		// creating a Scene
//-------------------------------------------------------------------------------------------------------		
		StackPane layout2 = new StackPane();		// a layout that stacks thing one on top of a nother with a spacing
		layout2.getChildren().addAll(label2, button4);		// adding a "child" to the "stage" (a button to the window layout)
		scene2 = new Scene(layout2, 400, 200);		// creating a Scene
//-------------------------------------------------------------------------------------------------------		
		VBox layout3 = new VBox(5);
		layout3.getChildren().addAll(label3, button5);
		scene3 = new Scene(layout3, 500, 50);
//-------------------------------------------------------------------------------------------------------		
		VBox layout4 = new VBox(5);
		layout4.getChildren().addAll(label4, button6);
		scene4 = new Scene(layout4, 500, 500);
//-------------------------------------------------------------------------------------------------------	
		stage.setScene(scene1);		// creating main window
		stage.setTitle("X-wing miniatures game");
		stage.show();
	}	
}
