package onliner.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import onliner.pageObject.MainPage;

public class MainPageSteps {
    private final MainPage mainPageSteps;

    public MainPageSteps() {
        mainPageSteps = new MainPage();
    }

    @Given("Onliner Main page is opened")
    public void onliner_main_page_is_opened() {
        mainPageSteps.checkOpenedPage();
    }

    @When("I will go to the Catalog menu point")
    public void i_will_go_to_the_catalog_menu_point() {
        mainPageSteps.navigateToCatalog();
    }
}