package onliner.pageObject;

import framework.BaseForm;
import org.openqa.selenium.By;

public class BaseOnlinerPage extends BaseForm {

    protected BaseOnlinerPage(By locator, String title) {
        super(locator, title);
    }

}
