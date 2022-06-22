package onliner.tests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/onliner/tests/features"},
        glue = {"onliner/tests"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
