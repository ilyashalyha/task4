package onliner.tests.stepdefinitions;

import framework.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.tests.pageObjects.MainPage;

import static framework.BaseTest.browser;

public class MainPageSteps {
    private final MainPage mainPageSteps;

    public MainPageSteps() {
        mainPageSteps = new MainPage();
    }

    @Given("Onliner Main page is opened")
    public void onliner_main_page_is_opened() {
        browser = Browser.getInstance();
        browser.navigate("https://www.onliner.by/");
        mainPageSteps.checkOpenedPage();
    }
    @When("I will go to the Catalog menu point")
    public void i_will_go_to_the_catalog_menu_point() {
        mainPageSteps.navigateMainMenu("Каталог");
    }



}
