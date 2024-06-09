package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\manis\\WS\\SeleniumFramework\\src\\test\\java\\Cucumber", glue="StepDefinition", tags= "@ErrorValidation", monochrome= true,plugin= {"html:target/cucumber.html"} )
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
