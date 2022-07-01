package onliner.pageObject;

import framework.elements.Button;
import framework.elements.Dropdown;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CatalogPage extends BaseOnlinerPage{

    private static Label lblCatalogHeader = new Label(By.xpath("//div[@class='catalog-navigation__title']"), "Catalog header on the Catalog page");
    private Button sftMenuItemTemplate = new Button(By.xpath("//span[text()='%s']"), "template for menu");
    private Dropdown drdSubMenuItemTemplate = new Dropdown(By.xpath("//div[@class = 'catalog-navigation-list__aside-title' and contains(text(), '%s')]"), "submenu point in menu dropdown");
    private Dropdown drdSubSubMenuPointTemplate = new Dropdown(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//a[@class='catalog-navigation-list__dropdown-item']//span[text()=' %s ']"), "subsubmenu point in menu dropdown");

    public CatalogPage() {
        super(By.xpath(lblCatalogHeader.getLocator()), "CatalogPage");
    }

    public void navigateMenu(String menuItem, String subMenuItem, String subSubMenuPoint) {
        sftMenuItemTemplate.click(menuItem);
        drdSubMenuItemTemplate.findElementByStringFormat(translateToUniqueSpace(subMenuItem)).click();
        drdSubSubMenuPointTemplate.clickAndWait(subSubMenuPoint);
    }

    public void checkOpenedCatalogPage() {
        assert lblCatalogHeader.isDisplayed();
    }
}
