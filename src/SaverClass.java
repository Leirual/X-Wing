import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;



public class SaverClass{

	//private String saveDir = ClassLoader.getSystemClassLoader().getResource("save").getPath();
	//public int saveCount = 0;
	public MainUI mainInterface;
	public File file = new File("Save.txt");
	
	/*public void closeProgram() {		// method for saving before close and closing
		boolean answer = ConfirmBox.Display("EXIT Window", "Are you sure you want to exit?");
		if(answer == true){
			int number = mainInterface.getSaveCount();
			number++;
			if(file.exists()){
				try{
					FileWriter writer = new FileWriter(file);
					BufferedWriter bWriter = new BufferedWriter(writer);		
					bWriter.write("Save nr." + number);
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
			System.out.println("Saved game nr. " + number);
		}
	}*/
	
	
	
	/*public void save() throws IOException {
		int number = mainInterface.getSaveCount();
		number++;
		if(file.exists()){
			try{
				FileWriter writer = new FileWriter(file);
				BufferedWriter bWriter = new BufferedWriter(writer);		
				bWriter.write("Save nr." + number);
				bWriter.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}				
		}
		else{
			try {
				file.createNewFile();
				FileWriter writer = new FileWriter(file);
				BufferedWriter bWriter = new BufferedWriter(writer);		
				bWriter.write("Saved 1st game");
				bWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public String load() throws IOException {
		try {
            FileReader reader = new FileReader(file);	// this reads the file
            BufferedReader bReader = new BufferedReader(reader);	// wrapping the fileReader in a buffer
            String line;
            while ((line = bReader.readLine()) != null) {	// printing out text if there is one
                System.out.println(line);
                mainInterface.setLabel3Text("Loaded " + line);
            }
            reader.close();
//            stage.setScene(loadScene);		// setting new scene with load info
        } catch (IOException e) {
        	System.out.println("No games to load");
        }
		return mainInterface.getLabel3Text();
	}
*/
}
