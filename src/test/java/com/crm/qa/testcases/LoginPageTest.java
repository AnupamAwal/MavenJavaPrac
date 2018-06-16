package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
	}
	@AfterMethod
	void quitBrowser()
	{
		driver.quit();
	}
	@Test(priority=2)
	void checkCRMLogo()
	{
		Assert.assertTrue(loginpage.validateCRMLogo());
	}
	
	@Test(priority=1)
	void checkLoginPageTitle()
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=3)
	void checkLogin()
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
}
