package seleniumExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotExample {
static WebDriver driver;
	
	public static void main(String [] args) throws IOException, InterruptedException {
		
		
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
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File Destination=new File("screenshot.png");
		
		FileHandler.copy(sourceFile, Destination);
		
	}
}
