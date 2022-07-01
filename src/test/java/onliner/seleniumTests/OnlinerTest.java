package onliner.seleniumTests;

import framework.BaseTest;
import onliner.pageObject.CatalogPage;
import onliner.pageObject.MainPage;
import onliner.pageObject.TVPage;
import org.testng.annotations.Test;

public class OnlinerTest extends BaseTest {

    @Test
    public void runTest() {
        browser.navigate("https://www.onliner.by/");
        MainPage mainPage = new MainPage();
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateMenu("Электроника", "Телевидение и видео", "Телевизоры");
        TVPage tvPage = new TVPage();
        tvPage.setManufacturer("Samsung");
        tvPage.setMaxPrice("1500");
        tvPage.setDiagonal("40", "50");
        tvPage.setResolution("1920x1080 (Full HD)");
        tvPage.checkFilterResults("Samsung", "1500", "40", "50", "1920x1080 (Full HD)");
    }
}
