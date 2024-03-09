package fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsingBufferReader {
	
	public static void main(String [] args) throws IOException {
		
		String Location = "UsingBufferReader.txt";
		FileReader filereader = new FileReader(Location);
		BufferedReader reader = new BufferedReader(filereader);
		
		String currentline;
		
		while((currentline=reader.readLine())!=null) {
			System.out.println(currentline);
		}
		
			
	}

}
