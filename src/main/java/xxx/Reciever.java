package xxx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Reciever {

	private static JsonParser parser = new JsonParser();
	
	public static void recieve(InputStream stream) {
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))){
		
			int counter = 0;
			while(reader.ready()) {
				
				String line = reader.readLine();
				JsonObject json = parser.parse(line).getAsJsonObject();
				
				if(counter % 1000 == 0)
					System.out.println(json.toString());
					
				counter++;
			}
		}
		catch(Exception e) {
			
			System.err.println("Failure receiving payload " + e.getMessage());
		}
	}
}
