package FileWriting;

import java.io.FileWriter;
import java.io.IOException;

public class fileWriterExample {
	public static void main(String [] args) throws IOException {

		String FileLocation="sample.txt";
		String Content="I am handsome boy and having many friends";
		FileWriter filewriter= new FileWriter(FileLocation);
		filewriter.write(Content);
		filewriter.close();

	}

}
