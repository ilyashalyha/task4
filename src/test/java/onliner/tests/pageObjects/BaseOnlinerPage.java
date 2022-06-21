package onliner.tests.pageObjects;

import framework.BaseForm;
import framework.elements.StringFormat;
import org.openqa.selenium.By;

public class BaseOnlinerPage extends BaseForm {

    private StringFormat lblMainMenuPointLocator = new StringFormat(By.xpath("//span[@class='b-main-navigation__text' and text()='%s']"), "template for main menu locator");

    public void navigateMainMenu(String value) {
        findElementByStringFormat(lblMainMenuPointLocator.getLocator(), value).click();

    }
}
