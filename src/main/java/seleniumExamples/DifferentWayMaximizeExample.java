package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DifferentWayMaximizeExample {
	
	static WebDriver driver;
	
	static Logger logger = Logger.getLogger(DifferentWayMaximizeExample.class);
	
	public static void main(String [] args) throws IOException {
		
		PropertyConfigurator.configure("log4j.properties");
		
		FileInputStream fileinput = new FileInputStream("config.properties");
		Properties prop=new Properties();
		prop.load(fileinput);
		
		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");
		String url=prop.getProperty("url");
		
		ChromeOptions chrome = new ChromeOptions(); // This is chromeoptions
		chrome.addArguments("--start-maximized"); // chrome will start with maximized window only
		
		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver(chrome); // here we need to pass the chrome driver
			
		}
		driver.navigate().to(url);
		logger.info("Webpage is opened");
		
		
		/*
		 * driver.manage().window().maximize(); logger.
		 * info("Window is maximized by driver.manage().window().maximize() method");
		 * driver.manage().window().minimize(); logger.info("Window is minimized");
		 * driver.quit(); logger.info("Browser is closed");
		 */
		
		/*
		 * Dimension dimension=new Dimension(500, 600);
		 * driver.manage().window().setSize(dimension);
		 * logger.info("Window size were set to : 800x600 "+dimension);
		 */
		
		
	}

}
