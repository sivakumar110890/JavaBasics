package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuitAndCloseExample {
	static WebDriver driver;
	
	static Logger logger = Logger.getLogger(QuitAndCloseExample.class);
	
	public static void main(String [] args) throws IOException {
		
		
		FileInputStream fileinput = new FileInputStream("config.properties");
		Properties prop=new Properties();
		prop.load(fileinput);
		
		
		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");
		String url=prop.getProperty("url");
		
		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
		}
		logger.info("Now we have opened the page");
		
		driver.navigate().to(url);

		WebElement NewWindow=driver.findElement(By.linkText("new window"));
		NewWindow.click();
		driver.quit(); // closes all window opened by this driver
		//driver.close(); // Closes current window only
		
	}

}
