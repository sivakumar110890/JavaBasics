package FileWriting;

import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter {
	

	public static void main(String [] args) throws IOException {
		String FileLocation="UsingBufferedwriter.txt";
		String content="This text is written by BufferedWriter";
		
		FileWriter filewriter=new FileWriter(FileLocation);
		BufferedWriter bufferedwriter = new BufferedWriter();
		
		
		
	}

}
