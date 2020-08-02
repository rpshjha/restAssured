package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
		features = {"src/test/resources/features" }, 
		glue = { "steps" }, 
		tags = { "@MRTMB-14937" },
		dryRun = false,
		strict = true,
		monochrome = false)

public class RunCucumberFeature extends AbstractTestNGCucumberTests {
}
