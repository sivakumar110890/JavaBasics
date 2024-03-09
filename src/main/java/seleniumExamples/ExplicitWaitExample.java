package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {
	
	static WebDriver driver;
	
	public static void main (String[] args) throws IOException {
		
		FileInputStream fileinput=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(fileinput);
		
		String browser=properties.getProperty("browser");
		String driverPath=properties.getProperty("driver.location");
		String url=properties.getProperty("url");
		
		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		
		
		
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("student");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("Password123");
		
		//WebElement submit=driver.findElement(By.id("submit"));
		//submit.click();
		
		
		//WebDriverWait wait = new WebDriverWait (driver, 20);
		//WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		//submit.click();
	}

}
