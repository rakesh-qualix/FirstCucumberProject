package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
// The path of the feature file
@CucumberOptions(features = "E:/TMS OPEN SOURCE PROJECT/FreeCrmBDDFramework/src/main/java/Feature/login.feature",
		// means where exactly my step definition files i.e. the path of the
		// stepDefinition
		glue = { "stepDefinition" },
		// format is used to generate different types of reporting
		format = { "pretty", "html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml" },
		// format={"pretty","html:test-output"},
		// If monochrome is true , it will generate pretty output.display the console
		// output in a proper readable format.
		monochrome = true,
		// It will fail execution if there is any pending or undefined steps are there.
		strict = true,
		// It will mapped feature file with step definition that any steps is missing or not
		//First time recommended to use dryRun=true
		// dryRun=true
		dryRun = false)
public class TestRunner {

}
