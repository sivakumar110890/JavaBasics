package fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsingBufferedReader2 {
	
	public static void main (String[] args) throws IOException {
		String Location="UsingBufferReader.txt";
		
		FileReader filereader = new FileReader(Location);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		
		String currentLine ;
		
		while((currentLine=bufferedreader.readLine())!=null) {
			System.out.println(currentLine);
			
		}
		
	}

}
