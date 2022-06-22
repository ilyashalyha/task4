package framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public abstract class BaseTest {

    public static Browser browser;

    public abstract void runTest();

    //@BeforeTest
    public void before() {
        browser = Browser.getInstance();
    }

    //@Test
    public void xTest() {
        Class<? extends BaseTest> currentClass = this.getClass();
        runTest();
    }

    //@AfterTest(alwaysRun = true)
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}
