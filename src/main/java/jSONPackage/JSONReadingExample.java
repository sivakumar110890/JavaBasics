package jSONPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReadingExample {
	
	
	public static void main(String [] args) throws IOException, ParseException {
		
		JSONParser jsonparse=new JSONParser();
		FileReader filereader=new FileReader("jsonWritefile.json");
		Object parsedobject=jsonparse.parse(filereader);
		JSONObject jsonobject =(JSONObject) parsedobject;
		
		Object name=(String)jsonobject.get("Name");
		Long Age=(Long)jsonobject.get("Age");
		
		JSONArray array=(JSONArray)jsonobject.get("Hobbies");
		Iterator iterator=array.iterator();
		System.out.println("Name is : "+name);
		System.out.println("Age is : "+Age);
		
		while(iterator.hasNext()) {
			System.out.println("Hobbies is : "+iterator.next());
		}
		
		
	
		
		
		
	}

	
}
