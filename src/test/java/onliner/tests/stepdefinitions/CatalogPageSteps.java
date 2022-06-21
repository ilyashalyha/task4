package onliner.tests.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.tests.pageObjects.CatalogPage;

public class CatalogPageSteps {
    private final CatalogPage catalogPageSteps;

    public CatalogPageSteps() throws Throwable {
        catalogPageSteps = new CatalogPage();
    }

    @And("Catalog page is opened")
    public void catalog_page_is_opened() throws Throwable {
        catalogPageSteps.checkOpenedPage();
        throw new io.cucumber.java.PendingException();
    }

    @And("I navigate to TV page through menu")
    public void i_navigate_to_page_through_menu() throws Throwable {
        catalogPageSteps.navigateMenu("Электроника", "Телевидение и видео", "Телевизоры");
        throw new io.cucumber.java.PendingException();
    }
}
