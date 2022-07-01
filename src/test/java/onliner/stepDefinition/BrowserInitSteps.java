package onliner.stepDefinition;

import framework.Browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static framework.BaseTest.browser;

public class BrowserInitSteps {

    @When("I initialize driver")
    public void initializeDriver() {
        browser = Browser.getInstance();
    }

    @Then("Open browser")
    public void openBrowser() {
        browser.navigate("https://www.onliner.by/");
    }
}
