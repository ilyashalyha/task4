package onliner.tests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(features = {"src/test/java/onliner/tests/features"},
        glue = {"src/test/java/onliner/tests/stepdefinitions"})
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }
}
