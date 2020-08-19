package com.qa.util;



import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	
	public TestBase()
	{
	
		prop = new Properties();
		try {
			
			prop.load(getClass().getResourceAsStream("/com/qa/config/config.properties"));
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.contentEquals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.contentEquals("ff")) {
			System.setProperty("webdriver.gecko.driver","./src/test/resources/firefoxdriver/GeckoDriver.exe");
			driver= new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
}
