package propertyfileExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenGoogleWithLoadproperty {
	
	public static void main(String [] args) throws IOException {
		WebDriver driver = null;
		
		
		FileInputStream input = new FileInputStream("config.properties");
		Properties prop=new Properties();
		prop.load(input);
		
		String browser=prop.getProperty("browser");
		String driverPath=prop.getProperty("driver.location");
		String url=prop.getProperty("url");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.quit();
	}

}
