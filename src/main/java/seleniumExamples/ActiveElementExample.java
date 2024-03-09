package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ActiveElementExample {

	static Logger logger = Logger.getLogger(ActiveElementExample.class);
	static WebDriver driver;

	static WebElement q; // this we are mentioning the name , id 

	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("log4j.properties");


		FileInputStream fileinput= new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(fileinput);
		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
			driver.get("https://www.google.com");
			PageFactory.initElements(driver, ActiveElementExample.class);

			/*
			 * driver.switchTo().activeElement().sendKeys("search term \n"); logger.
			 * info("Now without using find element we are using activeElement to continue the operation"
			 * );
			 */

			q.sendKeys("search term \n"); // Here the q is the element of search box 
			logger.info("This case executed because we are using pagefactory");
		}
	}

}
