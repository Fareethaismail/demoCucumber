package org.locators;

import org.baseclass.com.BaseClass;

public class AssignLeaveLoc extends BaseClass{
	public static String assignleave="//a[text()='Assign Leave']";
	public static String nameemp = "//input[@name='assignleave[txtEmployee][empName]']";
	public static String type = "//select[@name='assignleave[txtLeaveType]']";
	public static String fdate= "//input[@name='assignleave[txtFromDate]']";
	public static String tdate="//input[@name='assignleave[txtToDate]']";
	public static String assign = "//input[@id='assignBtn']";
	

}
