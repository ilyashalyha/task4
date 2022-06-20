package framework;

import framework.elements.InfoField;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static framework.BaseTest.browser;

public class BaseForm extends Browser{

    public ResourceBundle locBundle;

    private Actions actions = new Actions(driver);

    public void checkOpenedPageByTitle(String title) {
        String titleLocator = "//h2[@class='pageheader']";
        Assert.assertEquals(driver.findElement(By.xpath(titleLocator)).getText(), title);
    }

    public void checkOpenedPageByText(String value, String res) {
        Assert.assertEquals(value, res);
    }

    public void assertIsOpenedPage(String locator) {
        Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());
    }

    public void assertByElementIsAvailable(InfoField element) {
        Assert.assertTrue(element.isDisplayed());
    }

    public void assertOpenedPageByText(InfoField infoField, String value) {
        Assert.assertEquals(infoField.getElement().getText(), value);
    }

    public List<WebElement> findElements(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public WebElement findElementByStringFormat(String locator, String value) {
        return browser.getDriver().findElement(By.xpath(String.format(locator, value)));
    }

    public void moveToElement(String locator, String value) {
        actions.moveToElement(findElementByStringFormat(locator, value)).pause(Duration.ofMillis(500)).build().perform();
    }

    public void moveToDoubleElementAndClick(String locator1, String value1, String locator2, String value2) {
        actions.moveToElement(findElementByStringFormat(locator1, value1)).pause(Duration.ofMillis(500)).
                moveToElement(findElementByStringFormat(locator2, value2)).click().build().perform();
    }

    public void moveToElementAndClick(String locator, String value) {
        actions.moveToElement(findElementByStringFormat(locator, value)).click().build().perform();
    }

    public void moveToElementByJS(String locator, String value) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", findElementByStringFormat(locator, value));
    }

    public void JSClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void sendKey(String key) {
        actions.sendKeys(key).build().perform();
    }

    public void waitForElement() {
        actions.pause(Duration.ofMillis(1000)).build().perform();
    }

    public File findDownloadedFile(String fileName) {
        File steamFileDir = new File(Paths.get("").toAbsolutePath().toString());

        boolean flag = false;
        File steamFile = null;
        for (int i = 0; i < Integer.parseInt(getTimeoutForDownloadFile()); i++) {
            File[] steamFileDirList = steamFileDir.listFiles();
            for (int j = 0; j < steamFileDirList.length; j++) {
                if (steamFileDirList[j].getName().equals(fileName)) {

                    flag = true;
                    steamFile = steamFileDirList[j];
                    break;
                }
            }
            if (!flag) {
                waitForElement();
            } else break;
        }

        return steamFile;
    }

    public void checkFileNameAndKill(String fileName) {
        Assert.assertEquals(findDownloadedFile(fileName).getName(), fileName);
        if (findDownloadedFile(fileName).delete()) {
            System.out.println("Downloaded file deleted");
        } else System.out.println("Downloaded file is not deleted");
    }

    public void setLocBundle(String locCode) {
        Locale locale = new Locale(locCode);
        locBundle = ResourceBundle.getBundle("localization/loc", locale);
    }

    public ResourceBundle getLocBundle() {
        return locBundle;
    }

    public String getLoc(String locPoint) {
        return getLocBundle().getString(locPoint);
    }

    public void setUpLocale(String locCode) {
        setLocBundle(locCode);
    }

    public String translateToUniqueSpace(String text) {

        StringBuilder builder = new StringBuilder(text);
        int start = builder.indexOf(" и ");

        return builder.replace(start + 2, start + 3, " ").toString();
    }

}
