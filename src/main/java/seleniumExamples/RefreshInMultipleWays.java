package seleniumExamples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshInMultipleWays {
	static WebDriver driver;

	public static void main(String [] args) throws IOException, InterruptedException, AWTException {


		FileInputStream fileinput = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(fileinput);

		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");
		String url=prop.getProperty("url");

		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
		}

		driver.navigate().to(url);
		//driver.navigate().refresh();  // First method to refresh the page 
		//driver.get(driver.getCurrentUrl()); // Second method to refresh the page

		Robot robot = new Robot();   // third method to refresh using robot method
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
		
	}}
