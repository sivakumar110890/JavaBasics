package loggingExample;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class PropertyFileExample {
	
	static Logger logger = Logger.getLogger(PropertyFileExample.class);
	
	public static void main(String [] args) {
		
		
		DOMConfigurator.configure("log4j.xml");	
		
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warn message");
		logger.error("This is error message");
		logger.fatal("This is fatal message");
		
	}

}
