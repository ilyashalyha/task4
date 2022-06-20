package onliner.tests.forms;

import framework.BaseForm;

public class BaseOnlinerPage extends BaseForm {

    private String lblMainMenuPointLocator = "//span[@class='b-main-navigation__text' and text()='%s']";

    public void navigateMainMenu(String value) {
        findElementByStringFormat(lblMainMenuPointLocator, value).click();

    }
}
