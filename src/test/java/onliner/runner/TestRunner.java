package onliner.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/onliner/features"},
        plugin = {"json:target/cucumber.json", "html:target/cucumber-report.html"},
        glue = {"onliner"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
