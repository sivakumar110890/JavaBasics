package seleniumExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample {
	static WebDriver driver;



	public static void main(String [] args) throws IOException {



		FileInputStream fileinput=new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(fileinput);

		String browser=prop.getProperty("browser");
		String DriverPath=prop.getProperty("driver.location");
		String url = prop.getProperty("url");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", DriverPath);
			driver = new FirefoxDriver();
		}

		driver.get(url);

		
		
		
		WebElement username=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/div/table[1]/tbody/tr/td/table/tbody/tr[1]/td[2]/input"));
		username.sendKeys("sivakumar.a");

		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("Chinnu@09876543");

		WebElement submit=driver.findElement(By.name("Submit"));
		submit.click();

	/*	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(3,TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		*/
		
		
		WebElement comviva=driver.findElement(By.xpath("//*[@id=\"LOCK_Organization_Name\"]/span"));
		comviva.click();

	}}
