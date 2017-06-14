package selenium.test.webtestsbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by pavelpozniakov on 14.06.17.
 */
public class WebDriverFactory {
    private static final long IMPLICIT_WAIT_TIMEOUT = 5;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }
    /**
     * Starts browser
     */
    public static void startBrowser() {
        if (driver == null) {
            Browser browser = Browser.getBrowser();
            switch (browser) {
                case FIREFOX:
                    driver = new FirefoxDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.FIREFOX));
                    break;
                case CHROME:
                    driver = new ChromeDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.CHROME));
                    break;
                case SAFARI:
                    driver = new SafariDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.SAFARI));
                    break;
                default:
                    throw new IllegalStateException("Unsupported browser type");
                    }
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    /**
     * Finishes browser
     */
    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
