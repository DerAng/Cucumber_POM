package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestBase;

public class LoginPage extends TestBase {
	
	
	// Page Factory - OR:
	
	@FindBy(name="email")
    WebElement username;
	
	
	@FindBy(name="password")
    WebElement password;
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
    WebElement loginBtn;
	
	@FindBy(css="div[class='ui fluid large blue submit button']")
    WebElement login2Btn;
	
	
	
     @FindBy(css="div[class='header item']")
     WebElement crmLogo;

     
	
	// Initializing the Page Objects:
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	// Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws Exception {
		Thread.sleep(3000);
		loginBtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		login2Btn.click();
		
		
	    return new HomePage();
	}
	
	
	
}
