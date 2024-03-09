package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TextUnderlinedOrNot {
	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fileinput = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(fileinput);
		
		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");
		
		if(browser.equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
			
			driver.get("https://www.google.com");
			
			WebElement Tamil=driver.findElement(By.partialLinkText("தமிழ்"));
			String BeforeHover=Tamil.getCssValue("text-decoration");
			System.out.println("Before Hover the value : "+BeforeHover);
			
			Actions actions=new Actions(driver);
			actions.moveToElement(Tamil).perform();
			Thread.sleep(5000);
			String AfterHover=Tamil.getCssValue("text-decoration");
			System.out.println("After Hover the value : "+AfterHover);
			
			
			if(AfterHover.contains("underline")) {
				System.out.println("The text Tamil is underlined");
			}
			else {
				System.out.println("The text tamil is not underlined");
			}
			driver.quit();
		}
	}

}
