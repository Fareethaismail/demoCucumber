package org.stepdef;


import org.baseclass.com.BaseClass;
import org.locators.Reportleave1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Reportlevelexe extends Reportleave1{
	
	@Given("user is entering leave page first option")
	public void user_is_entering_leave_page_first_option() {
		clickButton(findelementByXpath(Reportleave1.reportclick1));
		clickButton(findelementByXpath(Reportleave1.option));
		clickButton(findelementByXpath(Reportleave1.generate));
		dropDown(findelementByXpath(Reportleave1.generate), "Employee");
	    
	}
	@When("enter your {string}")
	public void enter_your(String name) {
		sendKeys(findelementByXpath(Reportleave1.name),name);
		clickButton(findelementByXpath(Reportleave1.date));
	    
	}
	@And("click the view button one")
	public void click_the_view_button_one() {
		clickButton(findelementByXpath(Reportleave1.button));
	    
	}
	@Then("verify the page")
	public void verify_the_page() {
		
		String title = driver.getTitle();
		   System.out.println(title);
	}




}
