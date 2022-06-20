package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

public abstract class BrowserFactory {

    public static WebDriver setUp(Browser.Browsers type) {
        WebDriver driver;

        switch (type) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                HashMap<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", Paths.get("").toAbsolutePath().toString());
                prefs.put("download.prompt_for_download", false);
                prefs.put("safebrowsing.enabled", true);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForScriptLoad())));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForImplicitWait())));
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList", 2);
                //profile.setPreference("browser.download.manager.showWhenStarting", false);
                profile.setPreference("browser.download.dir", Paths.get("").toAbsolutePath().toString());
                FirefoxOptions option = new FirefoxOptions();
                option.setProfile(profile);
                option.setImplicitWaitTimeout(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForImplicitWait())));
                option.setPageLoadTimeout(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForPageLoad())));
                option.setScriptTimeout(Duration.ofSeconds(Long.parseLong(Browser.getTimeoutForScriptLoad())));
                driver = new FirefoxDriver(option);
                driver.manage().window().maximize();
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        return driver;
    }
}
