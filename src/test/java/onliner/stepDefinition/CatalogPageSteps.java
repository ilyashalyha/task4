package onliner.stepDefinition;

import io.cucumber.java.en.When;
import onliner.pageObject.CatalogPage;

public class CatalogPageSteps {
    private final CatalogPage catalogPageSteps;

    public CatalogPageSteps() {
        catalogPageSteps = new CatalogPage();
    }

    @When("Catalog page is opened")
    public void catalog_page_is_opened() {
        catalogPageSteps.checkOpenedCatalogPage();
    }

    @When("I navigate to TV page through menu")
    public void i_navigate_to_tv_page_through_menu() {
        catalogPageSteps.navigateMenu("Электроника", "Телевидение и видео", "Телевизоры");
    }


}
