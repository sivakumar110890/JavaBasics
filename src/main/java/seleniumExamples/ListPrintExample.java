package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListPrintExample {

	static WebDriver driver;	
	static Logger logger = Logger.getLogger(ListPrintExample.class);

	public static void main(String [] args) throws IOException, InterruptedException {
		FileInputStream fileinput = new FileInputStream("config.properties");
		Properties prop=new Properties();
		prop.load(fileinput);

		PropertyConfigurator.configure("log4j.properties");


		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
		}

		driver.navigate().to("https://www.google.com");

		WebElement SearchBox= driver.findElement(By.name("q"));
		SearchBox.sendKeys("sugges");

		Thread.sleep(5000);

		List<WebElement> Listofsuggestions=driver.findElements(By.xpath("//ul[@role=\"listbox\"]//following::li"));

		for(WebElement webelement:Listofsuggestions) {
			System.out.println("The suggestions are :"+webelement.getText());

			logger.info(webelement.getText());
		}



	}

}
