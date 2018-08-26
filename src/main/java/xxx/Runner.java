package xxx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.JsonObject;

public class Runner {

	public static void main(String...strings) throws Exception {
		
		File inputFile = new File("/Users/xxx/Desktop/test.json");
		JsonCreater.createFile(inputFile, 1000000);
		
		File outputFile = new File("/Users/xxx/Desktop/new.json");
		FileWriter fileWriter = new FileWriter(outputFile);
		
		InputStream inputStream = new FileInputStream(inputFile);
		
		//Reciever.recieve(inputStream);
		
		try(BufferedWriter writer = new BufferedWriter(fileWriter)){
			try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
				while(bufferedReader.ready()){
					
					String line = bufferedReader.readLine();
					JsonObject json = JsonCreater.modifyEntry(line);
					
					writer.write(json.toString());
				}
				System.out.println("Finished Writing File " + outputFile.getPath());
			}
			catch(Exception e) {
				System.err.println("Issue reading file : " + e.getMessage());
			}
		}
		catch(Exception e) {
			System.err.println("Issue writing file " + e.getMessage());
		}
	}
}
