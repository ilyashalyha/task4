package onliner.stepDefinition;

import framework.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static framework.BaseTest.browser;

public class Hooks {

    @Before
    public void initializeDriver() {
        browser = Browser.getInstance();
        browser.navigate(Browser.getURL());
    }

    @After
    public void close() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}
