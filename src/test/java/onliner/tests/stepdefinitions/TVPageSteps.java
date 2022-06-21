package onliner.tests.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.tests.pageObjects.TVPage;

public class TVPageSteps {
    private final TVPage tvPageSteps;

    public TVPageSteps() {
        tvPageSteps = new TVPage();
    }

    @Then("TV page is opened")
    public void tv_page_is_opened() throws Throwable {
        tvPageSteps.checkOpenedPage();
        throw new io.cucumber.java.PendingException();
    }

    @And("I enter {string} in the max price field")
    public void i_enter_in_the_max_price_field(String maxPrice) throws Throwable {
        tvPageSteps.setMaxPrice(maxPrice);
        throw new io.cucumber.java.PendingException();
    }

    @And("I select {string} and {string} in the Diagonal section")
    public void i_select_and_in_the_diagonal_section(String minDiagonal, String maxDiagonal) throws Throwable {
        tvPageSteps.setDiagonal(minDiagonal, maxDiagonal);
        throw new io.cucumber.java.PendingException();
    }

    @And("I select {string} in the Resolution section")
    public void i_select_1920x1080_full_hd_in_the_resolution_section(String resolution) throws Throwable {
        tvPageSteps.setResolution(resolution);
        throw new io.cucumber.java.PendingException();
    }

    @Then("Required products are displayed according to the filter parameters")
    public void required_products_are_displayed_according_to_the_filter_parameters(String manufacturer, String maxPrice, String minDiagonal,
                                      String maxDiagonal, String resolution) throws Throwable {
        tvPageSteps.checkFilterResults(manufacturer, maxPrice, minDiagonal, maxDiagonal, resolution);
        throw new io.cucumber.java.PendingException();
    }

    @When("I select <manufacturer> in the Manufacturer section")
    public void iSelectManufacturerInTheManufacturerSection(String manufacturer) throws Throwable {
        tvPageSteps.setManufacturer(manufacturer);
        throw new io.cucumber.java.PendingException();
    }

    @And("I enter <maxPrice> in the MaxPrice field")
    public void iEnterMaxPriceInTheMaxPriceField(String maxPrice) throws Throwable {
        tvPageSteps.setMaxPrice(maxPrice);
        throw new io.cucumber.java.PendingException();
    }
}
