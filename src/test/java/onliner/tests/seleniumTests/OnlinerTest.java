package onliner.tests.seleniumTests;

import framework.BaseTest;
import onliner.tests.pageObjects.CatalogPage;
import onliner.tests.pageObjects.MainPage;
import onliner.tests.pageObjects.TVPage;

public class OnlinerTest extends BaseTest {

    @Override
    public void runTest() {
        browser.navigate("https://www.onliner.by/");
        MainPage mainPage = new MainPage();
        mainPage.navigateMainMenu("Каталог");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.checkOpenedPage();
        catalogPage.navigateMenu("Электроника", "Телевидение и видео", "Телевизоры");
        TVPage tvPage = new TVPage();
        tvPage.checkOpenedPage();
        tvPage.setManufacturer("Samsung");


    }
}
