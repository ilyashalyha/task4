package onliner.tests.forms;

import framework.elements.Block;
import framework.elements.InfoField;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TVPage extends BaseOnlinerPage {

    private InfoField ifdTVHeader = new InfoField(By.xpath("//h1[contains(text(), 'Телевизоры')]"), "TV page header");
    private String cbxManufacturer = "//ul[@class='schema-filter__list']/li/label/span/input[@value='%s']";
    private TextBox tbxMaxPrice = new TextBox(By.xpath("//input[@placeholder='до']"), "max price textbox");
    private String cbxDiagonal = "//span[@class='schema-filter__checkbox-text' and text()='%s\"']";
    private String cbxResolution = "//span[text()='%s']";
    private Block blkProductName = new Block(By.xpath("//div[@class='schema-product__title']//span[@data-bind='html: " +
            "product.extended_name || product.full_name']"), "product name in product block");

    public void checkOpenedPage() {
        assertByElementIsAvailable(ifdTVHeader);
    }



    public void setManufacturer(String manufacturer) {
        moveToElementByJS(cbxManufacturer, manufacturer.toLowerCase());
    }

    public void setMaxPrice(String maxPrice) {
        JSClick(tbxMaxPrice.getElement());
        sendKey(maxPrice);
    }

    public void setDiagonal(String minDiagonal, String maxDiagonal) {
        moveToElementByJS(cbxDiagonal, minDiagonal);
        moveToElementByJS(cbxDiagonal, maxDiagonal);
    }

    public void setResolution(String resolution) {
        moveToElementByJS(cbxResolution, resolution);
    }

    public boolean checkProductsName(String containsThisProductName) {
        List<WebElement> allProductNames = findElements(blkProductName.getElement().toString());
        for (WebElement elements :
                allProductNames) {
            String productNameValue = elements.getText().toLowerCase();
            if (!productNameValue.contains(containsThisProductName)) {
                return false;
            }
        } return true;
    }

    public void checkFilterResults(String manufacturerName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkProductsName(manufacturerName), "Checking manufacturerName");
        softAssert.assertAll();
        //, String minDiagonal, String maxDiagonal, String resolution, String price
    }
}
