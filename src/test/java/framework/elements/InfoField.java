package framework.elements;

import org.openqa.selenium.By;

public class InfoField extends BaseElement{

    public InfoField(By xpath) {
        super(xpath);
    }

    public InfoField(By xpath, String nameOf) {
        super(xpath, nameOf);
    }
}
