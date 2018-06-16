package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;  
	
	public TestBase() 
	{
		try
		{
		prop = new Properties();
		FileInputStream ip;
		ip = new FileInputStream("C:\\Users\\Anupam\\Mavenjavaprac\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e)
		{e.printStackTrace();}
		catch(IOException e)
		{e.printStackTrace();}
		
	}
	
	public static void initialization()
	{
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Work\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Work\\chromedriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadOut_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicite_Wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
