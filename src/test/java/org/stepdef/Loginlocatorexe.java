package org.stepdef;

import org.locators.LoginpageLocators;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginlocatorexe extends LoginpageLocators {

@Given("user is entering orngHRM page")
public void user_is_entering_orng_hrm_page() {
	loadDriver("chrome");
	launch("https://opensource-demo.orangehrmlive.com/");
    
}
@When("enter your {string} and {string}")
public void enter_your_and(String a, String b) {
	sendKeys(findelementByXpath(LoginpageLocators.username),a);
	sendKeys(findelementByXpath(LoginpageLocators.password),b);
    
}
@When("click the login button")
public void click_the_login_button() {
	clickButton(findelementByXpath(LoginpageLocators.login));
   
}
@Then("verify home page")
public void verify_home_page() {
	
	String title = driver.getTitle();
	   System.out.println(title);
    
}

	
	

}
