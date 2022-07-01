package onliner.pageObject;

import framework.elements.Block;
import org.openqa.selenium.By;

public class MainPage extends BaseOnlinerPage {

    private static Block blkProjectPanel = new Block(By.xpath("//div[@class='project-navigation project-navigation_overflow project-navigation_scroll']"),
            "Project panel on the main page");


    public MainPage() {
        super(By.xpath(blkProjectPanel.getLocator()), "Main page");
    }

    public void navigateToCatalog() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.navigateToCatalog();
    }

    public void checkOpenedPage() {
        assert blkProjectPanel.isDisplayed();

    }

}
