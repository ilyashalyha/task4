package onliner.tests.stepdefinitions;

import framework.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static framework.BaseTest.browser;

public class Hooks {
    @Before
    public void initializeDriver() {
        browser = Browser.getInstance();
        browser.navigate("https://www.onliner.by/");
    }

    @After
    public void close() {
        browser.exit();
    }
}
