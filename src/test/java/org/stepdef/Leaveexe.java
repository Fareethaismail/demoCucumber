package org.stepdef;

import org.locators.LeaveLocator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leaveexe extends LeaveLocator {
	@Given("user is entering leave page")
	public void user_is_entering_leave_page() {
		clickButton(findelementByXpath(LeaveLocator.leaveclick));
		clickButton(findelementByXpath(LeaveLocator.reportclick));
		clickButton(findelementByXpath(LeaveLocator.option1));
		
		

	  
	}
	@When("select the date")
	public void select_the_date() {
		clickButton(findelementByXpath(LeaveLocator.fromdate));
		dropDown(findelementByXpath(LeaveLocator.fromdate),"2020-01-01 - 2020-12-31");
	    
	}
	@When("click the view button")
	public void click_the_view_button() {
		
		clickButton(findelementByXpath(LeaveLocator.view));
	}
	@Then("verify leave page")
	public void verify_leave_page() {
		String title = driver.getTitle();
		   System.out.println(title);
	}



	


}
