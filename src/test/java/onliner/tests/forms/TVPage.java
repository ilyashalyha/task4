package onliner.tests.forms;

import framework.elements.Block;
import framework.elements.CheckBox;
import framework.elements.InfoField;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TVPage extends BaseOnlinerPage {

    private InfoField ifdTVHeader = new InfoField(By.xpath("//h1[contains(text(), 'Телевизоры')]"), "TV page header");
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

    public void checkOpenedPage() {
        assertByElementIsAvailable(ifdTVHeader);
    }



    public void setManufacturer(String manufacturer) {
        moveToElementByJS(cbxManufacturer.getLocator(), manufacturer.toLowerCase());
    }

    public void setMaxPrice(String maxPrice) {
        JSClick(tbxMaxPrice.getElement());
        sendKey(maxPrice);
    }

    public void setDiagonal(String minDiagonal, String maxDiagonal) {
        moveToElementByJS(cbxDiagonal.getLocator(), minDiagonal);
        moveToElementByJS(cbxDiagonal.getLocator(), maxDiagonal);
    }

    public void setResolution(String resolution) {
        moveToElementByJS(cbxResolution.getLocator(), resolution);
    }

    public boolean checkProductsName(String containsThisProductName) {
        List<WebElement> allProductNames = findElements(blkProductName.getLocator());
        for (WebElement elements :
                allProductNames) {
            String productNameValue = elements.getText().toLowerCase();
            if (!productNameValue.contains(containsThisProductName.toLowerCase())) {
                return false;
            }
        } return true;
    }

    public boolean checkResolution(String containsThisResolution) {
        List<WebElement> allProductNames = findElements(blkProductResolution.getLocator());
        for (WebElement elements :
                allProductNames) {
            String productNameValue = elements.getText();
            if (!productNameValue.contains(containsThisResolution)) {
                return false;
            }
        } return true;
    }

    public boolean checkDiagonal(String min, String max) {
        List<WebElement> allProductNames = findElements(blkProductDiagonal.getLocator());
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
        List<WebElement> allProductNames = findElements(blkProductPrice.getLocator());
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

    public void checkFilterResults(String manufacturerName, String resolution, String minDiagonal, String maxDiagonal, String price) {
        waitForElement();
        softAssertTrue(checkProductsName(manufacturerName), "Checking manufacturerName");
        softAssertTrue(checkResolution(resolution), "Checking resolution");
        softAssertTrue(checkDiagonal(minDiagonal, maxDiagonal), "Checking diagonal");
        softAssertTrue(checkPrice(price), "Checking price");
        assertAll();


        //softAssert.assertTrue(checkProductsName(manufacturerName), "Checking manufacturerName");
        //softAssert.assertTrue(checkResolution(resolution), "Checking resolution");
        //softAssert.assertTrue(checkDiagonal(minDiagonal, maxDiagonal));
        //softAssert.assertTrue(checkPrice(price));
        //softAssert.assertAll();
    }
}
