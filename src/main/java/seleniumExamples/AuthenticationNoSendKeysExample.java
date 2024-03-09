package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationNoSendKeysExample {
	
	static WebDriver driver;
	
	// Some pop up need to enter the credentials to access the site but here we cannot find the elements 
	// of username & password 
	
	
	public static void main (String [] args) throws IOException {
		FileInputStream file = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");
		String urlwithusercredentials=prop.getProperty("urlwithusercredentials");
		
		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();		}
		
		driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth"); // here we need to pass the credentials in url only 
		// urlwithusercredentials=http://admin:admin@the-internet.herokuapp.com/basic_auth
	}

}
