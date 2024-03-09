package seleniumExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImplicitWaitExample {
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/div/table[1]/tbody/tr/td/table/tbody/tr[1]/td[2]/input"));
		username.sendKeys("sivakumar.a");

		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("Chinnu@09876543");

		WebElement submit=driver.findElement(By.name("Submit"));
		submit.click();


		WebElement comviva=driver.findElement(By.xpath("//*[@id=\"LOCK_Organization_Name\"]/span"));
		comviva.click();



		//driver.quit();

	}


}


