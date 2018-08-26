package xxx;

import java.io.File;
import java.io.FileWriter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonCreater {

	private static JsonParser parser = new JsonParser();
	
	public static JsonObject createEntry() {

		JsonObject json = new JsonObject();

		json.addProperty("this", "123");
		json.addProperty("is", "456");
		json.addProperty("a", "789");
		json.addProperty("sweet", "111");
		json.addProperty("test", "999");

		return json;
	}
	
	public static JsonObject modifyEntry(String json) {
		
		JsonObject entry = parser.parse(json).getAsJsonObject();
		
		entry.addProperty("XXXX", "ADDED");
		
		return entry;
	}

	public static void createFile(File file, long entries) {

		try (FileWriter writer = new FileWriter(file)) {
			
			for (int i = 0; i < entries; i++) {
				writer.append(createEntry().toString());
				writer.write(System.lineSeparator());
			}
			
			System.out.println("File created with " + entries +" entries");
		} 
		catch (Exception e) {

			System.err.println("Failure creating file : " + e.getMessage());
		}
	}
}
