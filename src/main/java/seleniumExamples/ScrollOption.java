package seleniumExamples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollOption {

	public static Properties prop;
	public static WebDriver driver;


	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@SuppressWarnings("deprecation")
	public static void main(String [] args) throws IOException, InterruptedException, AWTException {
		FileInputStream fileinput = new FileInputStream("config.properties");
		prop = new Properties();
		prop.load(fileinput);

		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");

		System.out.println(browser);


		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", DriverPath); 
			driver = new ChromeDriver();
			driver.get("https://en.wikiquote.org/wiki/William_Shakespeare");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			

		}

		/*
		 * JavascriptExecutor js=(JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,1000)"); Thread.sleep(6000);   // This method scroll window by moving to particular resolution
		 * driver.quit();  
		 */
		
		WebElement HinduElement=driver.findElement(By.linkText("The Sonnets"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", HinduElement);
		Thread.sleep(5000);
		
		
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);  // Using robot object scrolling up and down 
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		Thread.sleep(5000);
		
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
	
		Thread.sleep(5000);
		driver.quit();
	}

}
