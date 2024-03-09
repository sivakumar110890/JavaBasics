package seleniumExamples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysEnterExample {

	static Logger logger = Logger.getLogger(SendKeysEnterExample.class);
	static WebDriver driver;

	public static void main (String[] args) throws IOException, AWTException {

		FileInputStream fileinput= new FileInputStream("config.properties");
		Properties prop = new Properties();		
		prop.load(fileinput);

		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");


		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();

		}

		driver.navigate().to("https://www.google.com");

		WebElement SearchBox= driver.findElement(By.name("q"));
		
		/*
		 * SearchBox.sendKeys("Happy life"+Keys.ENTER); // first method to submit using
		 * keys.ENTER selenium
		 * logger.info("This is the first method using keys.ENTER option");
		 */
		
		
		/*
		 * SearchBox.sendKeys("Second method \n"); // second method
		 * logger.info("In this method using \n automatically enter button press");
		 */
		
		//SearchBox.sendKeys("Third method"); SearchBox.submit(); // This submit method
		 //also clicks the html tag submit button
		
		SearchBox.sendKeys("search term");
		Robot robot=new Robot();  // Fourth method
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		 	}

}
