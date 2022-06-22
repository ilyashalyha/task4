package onliner.tests.seleniumTests;

import framework.BaseTest;
import onliner.tests.pageObjects.CatalogPage;
import onliner.tests.pageObjects.MainPage;
import onliner.tests.pageObjects.TVPage;

public class forExperiments extends BaseTest {
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
        tvPage.setMaxPrice("1500");
        tvPage.setDiagonal("40", "50");
        tvPage.setResolution("1920x1080 (Full HD)");
        tvPage.checkFilterResults("Samsung", "1920x1080 (Full HD)", "40", "50", "1500");
    }

    /*

    TVPage
    @Then("TV page is opened")
    public void tv_page_is_opened() {
        tvPageSteps.checkOpenedPage();
        throw new io.cucumber.java.PendingException();
    }

    @And("I enter {string} in the max price field")
    public void i_enter_in_the_max_price_field(String maxPrice) {
        tvPageSteps.setMaxPrice(maxPrice);
        throw new io.cucumber.java.PendingException();
    }

    @And("I select {string} and {string} in the Diagonal section")
    public void i_select_and_in_the_diagonal_section(String minDiagonal, String maxDiagonal) {
        tvPageSteps.setDiagonal(minDiagonal, maxDiagonal);
        throw new io.cucumber.java.PendingException();
    }

    @And("I select {string} in the Resolution section")
    public void i_select_1920x1080_full_hd_in_the_resolution_section(String resolution) {
        tvPageSteps.setResolution(resolution);
        throw new io.cucumber.java.PendingException();
    }

    @Then("Required products are displayed according to the filter parameters")
    public void required_products_are_displayed_according_to_the_filter_parameters(String manufacturer, String maxPrice, String minDiagonal,
                                      String maxDiagonal, String resolution) {
        tvPageSteps.checkFilterResults(manufacturer, maxPrice, minDiagonal, maxDiagonal, resolution);
        throw new io.cucumber.java.PendingException();
    }


    @And("I enter <maxPrice> in the MaxPrice field")
    public void iEnterMaxPriceInTheMaxPriceField(String maxPrice) {
        tvPageSteps.setMaxPrice(maxPrice);
        throw new io.cucumber.java.PendingException();
    }

    @When("I select {string} in the Manufacturer section")
    public void iSelectManufacturerInTheManufacturerSection(String manufacturer) {
        tvPageSteps.setManufacturer(manufacturer);
        throw new io.cucumber.java.PendingException();
    }

    MainPage

    @Given("Onliner Main page is opened")
    public void onliner_main_page_is_opened() throws Throwable {
        browser = Browser.getInstance();
        browser.navigate("https://www.onliner.by/");
        mainPageSteps.checkOpenedPage();
        throw new io.cucumber.java.PendingException();
    }

    @When("I will go to the Catalog menu point")
    public void i_will_go_to_the_catalog_menu_point() throws Throwable {
        mainPageSteps.navigateMainMenu("Каталог");
        throw new io.cucumber.java.PendingException();
    }

    CatalogPage

    @And("Catalog page is opened")
    public void catalog_page_is_opened() {
        catalogPageSteps.checkOpenedPage();
        throw new io.cucumber.java.PendingException();
    }

    @And("I navigate to TV page through menu")
    public void i_navigate_to_page_through_menu() {
        catalogPageSteps.navigateMenu("Электроника", "Телевидение и видео", "Телевизоры");
        throw new io.cucumber.java.PendingException();
    }
     */
}
