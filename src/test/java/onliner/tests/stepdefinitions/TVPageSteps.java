package onliner.tests.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.tests.pageObjects.TVPage;

public class TVPageSteps {
    private final TVPage tvPageSteps;

    public TVPageSteps() {
        tvPageSteps = new TVPage();
    }

    @Given("TV page is opened")
    public void tv_page_is_opened() {
        tvPageSteps.checkOpenedPage();
    }
    @When("I select {string} in the Manufacturer section")
    public void i_select_in_the_manufacturer_section(String string) {
        tvPageSteps.setManufacturer(string); //manufacturer
    }
    @When("I enter {string} in the max price field")
    public void i_enter_in_the_max_price_field(String string) {
        tvPageSteps.setMaxPrice(string); //maxPrice
    }
    @When("I select {string} and {string} in the Diagonal section")
    public void i_select_and_in_the_diagonal_section(String string, String string2) {
        tvPageSteps.setDiagonal(string, string2); //minDiagonal, maxDiagonal
    }
    @When("I select {string} in the Resolution section")
    public void i_select_in_the_resolution_section(String string) {
        tvPageSteps.setResolution(string); //resolution
    }
    //@Then("Required products are displayed according to the filter parameters")
    //public void required_products_are_displayed_according_to_the_filter_parameters() {
    //    tvPageSteps.checkFilterResults(manufacturer, maxPrice, minDiagonal, maxDiagonal, resolution);
    //    throw new io.cucumber.java.PendingException();
    //}


    @Then("Required products are displayed according to the filter parameters {string}, {string}, {string}, {string}, {string}")
    public void required_products_are_displayed_according_to_the_filter_parameters(String string, String string2, String string3, String string4, String string5) {
        tvPageSteps.checkFilterResults(string, string2, string3, string4, string5);
    }
}
