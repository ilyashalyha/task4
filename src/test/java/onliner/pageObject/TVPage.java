package onliner.pageObject;

import framework.elements.Block;
import framework.elements.CheckBox;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TVPage extends BaseOnlinerPage {
    private static Label lblTVHeader = new Label(By.xpath("//h1[contains(text(), 'Телевизоры')]"), "TV page header");
    private CheckBox cbxManufacturer = new CheckBox(By.xpath("//ul[@class='schema-filter__list']/li/label/span/input[@value='%s']"), "template for manufacturer name checkbox");
    private TextBox tbxMaxPrice = new TextBox(By.xpath("//input[@placeholder='до']"), "max price textbox");
    private CheckBox cbxDiagonal = new CheckBox(By.xpath("//span[@class='schema-filter__checkbox-text' and text()='%s\"']"), "template for diagonal checkbox");
    private CheckBox cbxResolution = new CheckBox(By.xpath("//span[text()='%s']"), "template for resolution checkbox");
    private Block blkProductName = new Block(By.xpath("//div[@class='schema-product__title']//span[@data-bind='html: " +
            "product.extended_name || product.full_name']"), "product name in product block");
    private Block blkProductResolution = new Block(By.xpath("//div[@class='schema-product__description']/span"),
            "resolution in product block");
    private Block blkProductDiagonal = new Block(By.xpath("//div[@class='schema-product__description']/span"),
            "diagonal in product block");
    private Block blkProductPrice = new Block(By.xpath("//div[@class='schema-product__price']//span[contains(text(), 'р.')]"),
            "price in product block");
    private Block blkProduct = new Block(By.xpath("//div[@class='schema-product__group']"), "Product block");


    public TVPage() {
        super(By.xpath(lblTVHeader.getLocator()), "TV page");
    }

    public void checkOpenedTVPage() {
        assert lblTVHeader.isDisplayed();
    }

    public void setManufacturer(String manufacturer) {
        cbxManufacturer.clickViaJS(manufacturer.toLowerCase());
    }

    public void setMaxPrice(String maxPrice) {
        tbxMaxPrice.clickViaJS();
        tbxMaxPrice.sendKey(maxPrice);
    }

    public void setDiagonal(String minDiagonal, String maxDiagonal) {
        cbxDiagonal.clickViaJS(minDiagonal);
        cbxDiagonal.clickViaJS(maxDiagonal);
    }

    public void setResolution(String resolution) {
        cbxResolution.clickViaJS(resolution);
    }

    public boolean checkProductsName(String containsThisProductName) {
        List<WebElement> allProductNames = blkProductName.findElements();
        for (WebElement elements :
                allProductNames) {
            String productNameValue = elements.getText().toLowerCase();
            if (!productNameValue.contains(containsThisProductName.toLowerCase())) {
                return false;
            }
        } return true;
    }

    public boolean checkResolution(String containsThisResolution) {
        List<WebElement> allProductNames = blkProductResolution.findElements();
        for (WebElement elements :
                allProductNames) {
            String productNameValue = elements.getText();
            if (!productNameValue.contains(containsThisResolution)) {
                return false;
            }
        } return true;
    }

    public boolean checkDiagonal(String min, String max) {
        List<WebElement> allProductNames = blkProductDiagonal.findElements();
        for (WebElement elements :
                allProductNames) {
            String productNameValue = elements.getText();
            String onlyInch = productNameValue.substring(0, 2);
            int inchSize = Integer.parseInt(onlyInch);
            if (inchSize < Integer.parseInt(min) || inchSize > Integer.parseInt(max)) {
                return false;
            }
        } return true;
    }

    public boolean checkPrice(String lessThanThisPrice) {
        List<WebElement> allProductNames = blkProductPrice.findElements();
        for (WebElement elements :
                allProductNames) {
            String productNameValue = elements.getText();
            try {
                String onlyPrice = productNameValue.substring(0, productNameValue.length() - 6);
                int price = Integer.parseInt(onlyPrice);
                if (price >= Integer.parseInt(lessThanThisPrice)) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return true;
            }
        } return true;
    }

    public void checkFilterResults(String manufacturerName, String price, String minDiagonal, String maxDiagonal, String resolution) {
        waitForScriptLoad();
        softAssertTrue(checkProductsName(manufacturerName), "Checking manufacturerName");
        softAssertTrue(checkResolution(resolution), "Checking resolution");
        softAssertTrue(checkDiagonal(minDiagonal, maxDiagonal), "Checking diagonal");
        softAssertTrue(checkPrice(price), "Checking price");
        assertAll();
    }
}