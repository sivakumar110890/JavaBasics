package seleniumExamples;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class cookiesExample {
	
	public static void main(String [] args ) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chrome_latest\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(opt) ;
		driver.navigate().to("https://payilagam.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		
		for
		(Cookie cookie : cookies) 
		{
			System.out.println("Before deleting the cookies : "+cookie);
		}
		
		driver.manage().deleteAllCookies();		
		Set<Cookie> cookiessecondround = driver.manage().getCookies();
		for(Cookie cookies2:cookiessecondround)
		{
			System.out.println("After Deleting the cookies: "+cookiessecondround);
		}
		driver.navigate().back();
		driver.navigate().forward();
		
		Set<Cookie> cookiesthird=driver.manage().getCookies();
		for(Cookie cookie3:cookiesthird) {
			System.out.println("After refresh the site : "+cookiesthird);
			
			
		}
	
		

}}
