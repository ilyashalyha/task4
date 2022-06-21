package onliner.tests.pageObjects;

import framework.elements.InfoField;
import org.openqa.selenium.By;

public class MainPage extends BaseOnlinerPage {

    private InfoField ifdCatalogHeader = new InfoField(By.xpath("//h2/a[contains(text(), 'Каталог')]"), "Catalog header on the Main page");

    public void checkOpenedPage() {
        assertByElementIsAvailable(ifdCatalogHeader);
    }

}
