package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		plugin = {"pretty", 
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt",
				"timeline:test-output-thread/"
		},
		monochrome =true,
		glue = {"StepDefinition"},
		features = {"src/test/resources/Features"},
		strict = true
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel= false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}

