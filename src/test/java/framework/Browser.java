package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ResourceBundle;

public class Browser {
    public static WebDriver driver;
    private static Browser instance;
    private static final String PROPERTIES_FILE = "conf.properties";
    private static final String BROWSER_PROP = "browser";
    private static PropertiesResourceManager props;
    private static final String DEFAULT_PAGE_LOAD_TIMEOUT = "pageLoadTimeout";
    private static final String DEFAULT_SCRIPT_LOAD_TIMEOUT = "scriptLoadTimeout";
    private static final String DEFAULT_IMPLICIT_TIMEOUT = "implicitWait";
    private static final String DEFAULT_DOWNLOAD_FILE_TIMEOUT = "downloadFileTimeout";
    private static final String URL = "url";
    private static String timeoutForPageLoad;
    private static String timeoutForScriptLoad;
    private static String timeoutForImplicitWait;
    private static String timeoutForDownloadFile;
    public static BrowserFactory.Browsers currentBrowser;
    public static ResourceBundle locBundle;

    public static String getBrowserProp() {
        return props.getProperty(BROWSER_PROP);
    }

    public static String getTimeoutForPageLoad() {
        return timeoutForPageLoad;
    }

    public static String getTimeoutForScriptLoad() {
        return timeoutForScriptLoad;
    }

    public static String getTimeoutForImplicitWait() {
        return timeoutForImplicitWait;
    }

    public static String getTimeoutForDownloadFile() {
        return timeoutForDownloadFile;
    }

    public static String getURL() {
        return props.getProperty(URL);
    }

    public boolean isBrowserAlive() {
        return instance != null;
    }

    private static void initProperties() {
        props = new PropertiesResourceManager(PROPERTIES_FILE);
        currentBrowser = BrowserFactory.Browsers.valueOf(getBrowserProp().toUpperCase());
        timeoutForPageLoad = props.getProperty(DEFAULT_PAGE_LOAD_TIMEOUT);
        timeoutForScriptLoad = props.getProperty(DEFAULT_SCRIPT_LOAD_TIMEOUT);
        timeoutForImplicitWait = props.getProperty(DEFAULT_IMPLICIT_TIMEOUT);
        timeoutForDownloadFile = props.getProperty(DEFAULT_DOWNLOAD_FILE_TIMEOUT);
    }

    public static Browser getInstance() {
        if (instance == null) {
            initProperties();
            driver = BrowserFactory.setUp(currentBrowser);
            instance = new Browser();
        }
        return instance;
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeoutForPageLoad)));

        try {
            wait.until((ExpectedCondition<Boolean>) d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                return result instanceof Boolean && (Boolean) result;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public void navigate(final String url) {
        driver.navigate().to(url);
        waitForPageToLoad();
    }

    public WebDriver getDriver() {
        return driver;
    }
}