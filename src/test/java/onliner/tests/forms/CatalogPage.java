package onliner.tests.forms;

import framework.elements.Button;
import framework.elements.Dropdown;
import framework.elements.InfoField;
import org.openqa.selenium.By;

public class CatalogPage extends BaseOnlinerPage{

    private InfoField ifdCatalogHeader = new InfoField(By.xpath("//div[@class='catalog-navigation__title']"),
            "Catalog header text");
    private String menuItemTemplate = "//span[text()='%s']";
    private String subMenuItemTemplate = "//div[@class = 'catalog-navigation-list__aside-title' and contains(text(), '%s')]";
    private String subSubMenuPointTemplate = "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//a[@class='catalog-navigation-list__dropdown-item']//span[text()=' %s ']";

    public void checkOpenedPage() {
        assertByElementIsAvailable(ifdCatalogHeader);
    }

    public void navigateMenu(String menuItem, String subMenuItem, String subSubMenuPoint) {
        moveToElementAndClick(menuItemTemplate, menuItem);
        findElementByStringFormat(subMenuItemTemplate, translateToUniqueSpace(subMenuItem)).click();
        findElementByStringFormat(subSubMenuPointTemplate, subSubMenuPoint).click();
        //moveToElement(subMenuItemTemplate, translateToUniqueSpace(subMenuItem));
        //moveToElementAndClick(subSubMenuPointTemplate, subSubMenuPoint);
        //moveToDoubleElementAndClick(subMenuItemTemplate, translateToUniqueSpace(subMenuItem), subSubMenuPointTemplate, subSubMenuPoint);

    }


}
