package onliner.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pageObject.TVPage;

public class TVPageSteps {
    private final TVPage tvPageSteps;

    public TVPageSteps() {
        tvPageSteps = new TVPage();
    }

    @Given("TV page is opened")
    public void tv_page_is_opened() {
        tvPageSteps.checkOpenedTVPage();
    }

    @When("I select {string} in the Manufacturer section")
    public void i_select_in_the_manufacturer_section(String manufacturer) {
        tvPageSteps.setManufacturer(manufacturer);
    }

    @When("I enter {string} in the max price field")
    public void i_enter_in_the_max_price_field(String maxPrice) {
        tvPageSteps.setMaxPrice(maxPrice);
    }

    @When("I select {string} and {string} in the Diagonal section")
    public void i_select_and_in_the_diagonal_section(String minDiagonal, String maxDiagonal) {
        tvPageSteps.setDiagonal(minDiagonal, maxDiagonal);
    }

    @When("I select {string} in the Resolution section")
    public void i_select_in_the_resolution_section(String resolution) {
        tvPageSteps.setResolution(resolution);
    }

    @Then("Required products are displayed according to the filter parameters {string}, {string}, {string}, {string}, {string}")
    public void required_products_are_displayed_according_to_the_filter_parameters(
            String manufacturer, String maxPrice, String minDiagonal, String maxDiagonal, String resolution) {
        tvPageSteps.checkFilterResults(manufacturer, maxPrice, minDiagonal, maxDiagonal, resolution);
    }
}
