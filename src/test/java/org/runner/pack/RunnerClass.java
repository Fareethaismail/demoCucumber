package org.runner.pack;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\FAREETHA\\eclipse-workspace\\CucumberSample\\FeaturesFile\\OrangeHRM.feature",glue="org.stepdef",monochrome=true,publish=true,dryRun=false)
public class RunnerClass {
	

}
