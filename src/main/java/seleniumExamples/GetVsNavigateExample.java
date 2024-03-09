package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetVsNavigateExample {
	
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
		/*
		 * driver.get(url); System.out.
		 * println("This page is opened by driver get method and till DOM loads get will wait"
		 * ); driver.close();
		 */
		
		Thread.sleep(5000);
		driver.navigate().to(url);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		System.out.println("This page is opened by driver navigate method and navigate stores history to go back and forward");
	}
		

}
