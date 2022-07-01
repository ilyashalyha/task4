package onliner.pageObject;

import framework.elements.Block;
import framework.elements.Button;
import org.openqa.selenium.By;

public class MainMenu extends BaseOnlinerPage {
    private String mainMenuTemplate = "//span[@class='b-main-navigation__text' and text()='%s']";//"template for main menu locator";
    private Button btnCatalogMainMenu = new Button(By.xpath(String.format(mainMenuTemplate, "Каталог")), "Catalog button in main menu");
    private static Block blkMainMenu = new Block(By.xpath("//ul[@class='b-main-navigation']"), "Main menu block");

    protected MainMenu() {
        super(By.xpath(blkMainMenu.getLocator()), "Main menu");
    }

    public void navigateToCatalog() {
        btnCatalogMainMenu.clickAndWait();
    }

}
