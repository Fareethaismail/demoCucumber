package org.stepdef;

import org.locators.AssignLeaveLoc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignLeaveExe extends AssignLeaveLoc {
	@Given("user is entering Assign leave page")
	public void user_is_entering_assign_leave_page() {
		clickButton(findelementByXpath(AssignLeaveLoc.assignleave));
		
	    
	}
	@When("enter the {string}")
	public void enter_the_(String d) {
		sendKeys(findelementByXpath(AssignLeaveLoc.assignleave),d);
		clickButton(findelementByXpath(AssignLeaveLoc.type));
		dropDown(findelementByXpath(AssignLeaveLoc.type),"US - Personal");
	    
	}
	@When("enter the {string} and {string}")
	public void enter_the_and(String e, String f) {
		sendKeys(findelementByXpath(AssignLeaveLoc.fdate),e);
		sendKeys(findelementByXpath(AssignLeaveLoc.tdate),f);
		clickButton(findelementByXpath(AssignLeaveLoc.assign));
	    
	}
	@Then("verify the assign leave page")
	public void verify_the_assign_leave_page() {
		String title = driver.getTitle();
		   System.out.println(title);
		
	}
	
	


}
