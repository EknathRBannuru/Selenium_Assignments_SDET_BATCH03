package com.qa.BBDTestRunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= "C:\\Users\\nayaka\\eclipse-workspace\\SeleniumAssignment\\src\\test\\java\\com\\qa\\Features\\OrangHRM.feature",
		glue="com.qa.StepDefinition",
		dryRun = false,
		strict = true,
		monochrome = true,
		format = {"pretty" , "html:test-output"},

		// {"~@SmokeTest"}
		// {"@SmokeTest"}
		// {"@SmokeTest, @UsabilityTest"} --> either or 
		// {"@SmokeTest", "@UsabilityTest"} --> Anding
		tags= {"@SmokeTest, @RegressionalTest",}
		)


public class OrangeHRMTestRunner {
	

}