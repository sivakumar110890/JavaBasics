package FileWriting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author sivakumar.a
 *
 */
public class UsingPAth {
	public static void main(String [] args) throws IOException {
		String FileLocation="usingPath.txt";
		String content="This is the content of using path";
		
		Path path = Paths.get(FileLocation);
		Files.write(path, content.getBytes());
		
}}
