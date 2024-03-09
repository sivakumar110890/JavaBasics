package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v108.indexeddb.model.Key;

public class PrintAllLinksFromSiteExample {
	
	static WebDriver driver;
	
	static Logger logger = Logger.getLogger(PrintAllLinksFromSiteExample.class);
	
	public static void main(String[] args) throws IOException {
		FileInputStream fileinput = new FileInputStream("config.properties");
		Properties prop=new Properties();
		prop.load(fileinput);
		
		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");
		
		
		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
		}
		
		driver.navigate().to("https://www.google.com");
		
		WebElement SearchBox= driver.findElement(By.name("q"));
		SearchBox.sendKeys("12 angry men"+Keys.ENTER);
		
		//List<WebElement> allAnchorTag=driver.findElements(By.xpath("//a")); // based on achor tag
		List<WebElement> allAnchorTag=driver.findElements(By.xpath("//*[@id=\"search\"]//following::h3//following::div/cite"));
		
		for(WebElement totallinks:allAnchorTag) {
			//System.out.println(totallinks.getAttribute("href")); // based on anchor tag
			System.out.println(totallinks.getText()); // based on anchor tag
		}
	}
		

}
