package framework;

import java.util.Locale;
import java.util.ResourceBundle;

public class WorkWithLocales extends Browser {

    public void setLocBundle(String locCode) {
        Locale locale = new Locale(locCode);
        locBundle = ResourceBundle.getBundle("localization/loc", locale);
    }

    public ResourceBundle getLocBundle() {
        return locBundle;
    }

    public String getLoc(String locPoint) {
        return getLocBundle().getString(locPoint);
    }

    public void setUpLocale(String locCode) {
        setLocBundle(locCode);
    }
}
