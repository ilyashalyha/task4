package onliner.tests;

import framework.BaseTest;
import onliner.tests.forms.CatalogPage;
import onliner.tests.forms.MainPage;
import onliner.tests.forms.TVPage;

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
