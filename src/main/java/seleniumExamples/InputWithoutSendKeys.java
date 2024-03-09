package seleniumExamples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputWithoutSendKeys {
	static WebDriver driver;
	private Object keyEvent;
	
	public static void main(String [] args) throws IOException, AWTException {
	
	FileInputStream fileinput = new FileInputStream("config.properties");
	Properties prop = new Properties();
	prop.load(fileinput);
	
	String browser=prop.getProperty("browser");
	String DriverPath=prop.getProperty("driver.location");
	
	if(browser.equalsIgnoreCase("CHROME")){
		System.setProperty("webdriver.chrome.driver", DriverPath);
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		/*
		 * JavascriptExecutor js=(JavascriptExecutor) driver;
		 * js.executeScript("document.getElementsByName('q')[0].value='search option')",
		 * "");
		 */
		
		driver.switchTo().activeElement();   // where cursor is there know that 
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_S);    // now cursor is in public so 
		robot.keyRelease(KeyEvent.VK_S);
		
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		
		
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
	}
	}

}
