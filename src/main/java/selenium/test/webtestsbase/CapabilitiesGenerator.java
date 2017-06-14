package selenium.test.webtestsbase;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by pavelpozniakov on 14.06.17.
 */

public class CapabilitiesGenerator {
    public static DesiredCapabilities getDefaultCapabilities(Browser browser) {
        switch (browser) {
            case FIREFOX:
                if (System.getProperty("webdriver.gecko.driver") == null) {
                    File fileFF = new File("./drivers/geckodriver");
                    System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
                }
                else { throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.firefox();
            case CHROME:
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    File fileFF = new File("./drivers/chromedriver");
                    System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
                }
                else { throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.chrome();
            case SAFARI:
                return new DesiredCapabilities();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }

}
