package jSONPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWritingExample {
	
	public static void main(String[] args) throws IOException {
		
		JSONObject json=new JSONObject();
		json.put("Name", "Sivakumar");
		json.put("Age", 32);
		json.put("Character", "Awesome");
		
		
		JSONArray array=new JSONArray();
		array.add("Playing foosball");
		array.add("Listening songs");
		
		json.put("Hobbies", array);
		
		FileWriter filewrite=new FileWriter("jsonWritefile.json");
		BufferedWriter buffered = new BufferedWriter(filewrite);
		buffered.write(json.toJSONString());
		buffered.close();
		
	}

}
