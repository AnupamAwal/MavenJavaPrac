package com.crm.qa.pages;

import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase 
{
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/register/']")
	WebElement SignUpButton;
	
	@FindBy(xpath="//img[@src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']")
	WebElement CRMLogo;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/contact.html']")
	WebElement ContactLink;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo()
	{
		return CRMLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		LoginButton.click();
		
		return new HomePage();
	}
	
	
	
	
}
