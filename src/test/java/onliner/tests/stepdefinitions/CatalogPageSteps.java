package onliner.tests.stepdefinitions;

import io.cucumber.java.en.When;
import onliner.tests.pageObjects.CatalogPage;

public class CatalogPageSteps {
    private final CatalogPage catalogPageSteps;

    public CatalogPageSteps() {
        catalogPageSteps = new CatalogPage();
    }

    @When("Catalog page is opened")
    public void catalog_page_is_opened() {
        catalogPageSteps.checkOpenedPage();
    }
    @When("I navigate to TV page through menu")
    public void i_navigate_to_tv_page_through_menu() {
        catalogPageSteps.navigateMenu("Электроника", "Телевидение и видео", "Телевизоры");
    }


}
