package onliner.tests.pageObjects;

import framework.elements.Button;
import framework.elements.Dropdown;
import framework.elements.InfoField;
import org.openqa.selenium.By;

public class CatalogPage extends BaseOnlinerPage{

    private InfoField ifdCatalogHeader = new InfoField(By.xpath("//div[@class='catalog-navigation__title']"),
            "Catalog header text");
    private Button sftMenuItemTemplate = new Button(By.xpath("//span[text()='%s']"), "template for menu");
    private Dropdown drdSubMenuItemTemplate = new Dropdown(By.xpath("//div[@class = 'catalog-navigation-list__aside-title' and contains(text(), '%s')]"), "submenu point in menu dropdown");
    private Dropdown drdSubSubMenuPointTemplate = new Dropdown(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//a[@class='catalog-navigation-list__dropdown-item']//span[text()=' %s ']"), "subsubmenu point in menu dropdown");

    public void checkOpenedPage() {
        assertByElementIsAvailable(ifdCatalogHeader);
    }

    public void navigateMenu(String menuItem, String subMenuItem, String subSubMenuPoint) {
        moveToElementAndClick(sftMenuItemTemplate.getLocator(), menuItem);
        findElementByStringFormat(drdSubMenuItemTemplate.getLocator(), translateToUniqueSpace(subMenuItem)).click();
        findElementByStringFormat(drdSubSubMenuPointTemplate.getLocator(), subSubMenuPoint).click();

    }


}
