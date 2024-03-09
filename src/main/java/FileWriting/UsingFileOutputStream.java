package FileWriting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UsingFileOutputStream {
	public static void main(String [] args ) throws IOException {
		
		String fileLocation="UsingFOS.txt";
		String content="This is the content for UsingFOS";
		
		FileOutputStream fileoutput=new FileOutputStream(fileLocation);
		byte[] writetext=content.getBytes();
		fileoutput.write(writetext);
		fileoutput.close();
	}

}
