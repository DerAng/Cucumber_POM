package com.qa.stepDefinitions;



import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;



public class HomePageSteps extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	
	

	@Given("^user opens browser$")	
	public void user_opens_browser() throws Throwable{
	    
		TestBase.initialization();
	}
	
	
	
	@Then("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		loginPage= new LoginPage();
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals("Free CRM software can boost your sales by 30%", title);
	}
	
	
	@Then("^user logs into app$")
	public void user_enters_username_and_password() throws Throwable {
		
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	

	
	
	@Then("^validate home page title$")
	public void validate_home_page_title() throws Throwable {
		
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("Cogmento CRM", homeTitle);
		
	}
	
	
	
	@Then("^validate logged in username$")
	public void validate_logged_in_username() throws Throwable {
		Thread.sleep(3000);
		boolean flag = homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
	
	
	
	
	
}
