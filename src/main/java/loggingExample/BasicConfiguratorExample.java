package loggingExample;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicConfiguratorExample {
	
	static Logger logger = Logger.getLogger(BasicConfiguratorExample.class);
	
	public static void main(String [] args) {
		
		BasicConfigurator.configure();
		logger.debug("This is Debug Logger");
		logger.info("This is Info Logger");
		logger.warn("This is WARN Logger");
		logger.error("This is ERROR Logger");
		logger.fatal("This is fatal Logger");
		
		
	}

}
