package testRun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)

@CucumberOptions (  
		tags = "@smoke" , 
		features = "src/test/features/TestCase1.feature",
		glue= {"stepDefinition", "hooks"} , 
		plugin = { "pretty", "junit:target/cucumber-reports.html" , "json:target/cucumber-reports" },
		publish = true, 
		monochrome = false		
		)


public class TestRunner {

}

