package framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    public static Browser browser;

    @BeforeTest
    public void before() {
        browser = Browser.getInstance();
        browser.navigate(Browser.getURL());
    }

    @AfterTest(alwaysRun = true)
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}
