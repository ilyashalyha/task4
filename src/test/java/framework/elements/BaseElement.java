package framework.elements;

import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;

import static framework.BaseTest.browser;

public class BaseElement extends Browser {
    protected By locator;
    protected String name;
    protected WebElement element;
    private static final int TIMEOUT_WAIT_0 = 0;
    public Actions actions = new Actions(getDriver());

    protected BaseElement(final By loc, String nameOf) {
        locator = loc;
        name = nameOf;
    }

    public BaseElement(String value) {
        findElementByStringFormat(value);
    }

    public BaseElement(By loc) {
        locator = loc;
    }

    public WebElement getElement() {
        return findElement(locator);
    }

    public void click() {
        waitForIsElementPresent();
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].style.border='3px solid yellow'", element);
            element.click();
        }
    }

    public void click(String value) {
        if (browser.getDriver() instanceof JavascriptExecutor) {
            element = findElementByStringFormat(value);
            ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].style.border='3px solid yellow'", element);
            element.click();
        }
    }

    public void clickAndWait() {
        waitForIsElementPresent();
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].style.border='3px solid yellow'", element);
            element.click();
        }
        browser.waitForPageToLoad();
    }

    public void clickAndWait(String value) {
        element = findElementByStringFormat(value);
        waitForIsElementPresent();
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].style.border='3px solid yellow'", element);
            element.click();
        }
        browser.waitForPageToLoad();
    }

    public WebElement findElement(By locator) {
        return browser.getDriver().findElement(locator);
    }

    public WebElement findElementByStringFormat(String value) {
        return browser.getDriver().findElement(By.xpath(String.format(getLocator(), value)));
    }

    public void moveToElement() {
        actions.moveToElement(getElement()).pause(Duration.ofMillis(500)).build().perform();
    }

    public void moveToElementAndClick() {
        actions.moveToElement(getElement()).click().build().perform();
    }

    public void waitForScriptLoad() {
        actions.pause(1000).build().perform();
    }

    public void clickViaJS() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getElement());
    }

    public void clickViaJS(String value) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        element = findElementByStringFormat(value);
        executor.executeScript("arguments[0].click();", element);
    }

    public void sendKey(String key) {
        actions.sendKeys(key).build().perform();
    }

    public List<WebElement> findElements() {
        return driver.findElements(By.xpath(getLocator()));
    }

    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    public String getLocator() {
        String text = String.valueOf(locator);
        return cutLocatorType(text);
    }

    public String cutLocatorType(String locator) {
        StringBuilder builder = new StringBuilder(locator);
        int firstPart = builder.indexOf(" ");
        return builder.substring(firstPart);
    }

    public void waitForIsElementPresent() {
        isPresent(Integer.parseInt(getTimeoutForScriptLoad()));
        if (!element.isDisplayed()) {
            performTroubleShooting();
        }
        Assert.assertTrue(element.isDisplayed(), "Element is absent");
    }

    private void performTroubleShooting(){
        int length = decrementLocator(locator).toString().length();
        try {
            System.out.println("---------------- Troubleshooting starting --------------------");
            for (int i = 0; i < length; i++) {
                decrementLocator(locator);
                boolean result = isPresent(TIMEOUT_WAIT_0);
                System.out.println("Re-try with locator: \t" + locator.toString() + String.format(new String(new char[i]).replace('\0', ' ') + " :%s",result? "FOUND!":"NOT FOUND"));
                if (result) {
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            System.out.println("---------------- Troubleshooting finished --------------------");
        }
    }

    private By decrementLocator(By locator){
        for (Field field : locator.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                String strLocator = (String)field.get(locator);
                field.set(locator,strLocator.substring(0, strLocator.length()-1));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                System.err.println(e.getMessage());
            }
        }
        return locator;
    }

    public boolean isPresent() {
        return isPresent(TIMEOUT_WAIT_0);
    }

    public boolean isPresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(Browser.getInstance().getDriver(), Duration.ofSeconds(timeout));
        browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_WAIT_0));
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> {
                try {
                    assert driver != null;
                    List<WebElement> list = driver.findElements(locator);
                    for (WebElement el : list) {
                        if (el != null && el.isDisplayed()) {
                            element = el;
                            return element.isDisplayed();
                        }
                    }
                    element = driver.findElement(locator);
                } catch (Exception e) {
                    return false;
                }
                return element.isDisplayed();
            });
        } catch (Exception e) {
            return false;
        }
        try {
            browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getTimeoutForScriptLoad())));
            return element.isDisplayed();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }




}