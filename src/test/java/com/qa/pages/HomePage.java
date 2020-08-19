package com.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//*[contains(text(),'prueba 123')]")
	@CacheLookup
    WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
    WebElement contactsLink;
	
	@FindBy(xpath="//*[contains(text(),'New Contact')]")
    WebElement newContactLink;
	
	@FindBy(xpath="//*[contains(text(),'Deals')]")
    WebElement dealsLink;
	
	@FindBy(xpath="//*[contains(text(),'Tasks')]")
    WebElement tasksLink;
	
	// Initializing the Page Objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	
	
}
