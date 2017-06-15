package selenium.test.webtestsbase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import selenium.test.utils.MyLogger;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by pavelpozniakov on 14.06.17.
 */
@RunWith(value = Parameterized.class)
public class WebDriverFactory {
//    private static final long IMPLICIT_WAIT_TIMEOUT = 5;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }

//        private boolean isTestPass = false;

        private String browser;

        public WebDriverFactory(String browser) {
            this.browser = browser;
        }

        @Parameterized.Parameters
        public static Collection testData() {
            return Arrays.asList(new Object[][]{
                /*{"fireFox"},*/ {"chrome"},/* { "safari" }*/
            });
        }

        @Rule
        public TestName testName = new TestName();

        @Before
        public void SetUp() {

            if ("fireFox".equals(browser)) {
                MyLogger.log.info("FireFox will be started");
                File fileFF = new File("./drivers/geckodriver");
                System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
                driver = new FirefoxDriver();
                MyLogger.log.info(" FireFox is started");
            } else if ("chrome".equals(browser)) {
                MyLogger.log.info("Chrome will be started");
                File fileFF = new File("./drivers/chromedriver");
                System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
                driver = new ChromeDriver();
                MyLogger.log.info(" Chrome is started");
            } else if ("safari".equals(browser)) {
                MyLogger.log.info("Safari will be started");
                driver = new SafariDriver();
                MyLogger.log.info(" Opera is started");
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @After
        public void finishBrowser() {
            if (!(driver == null)) {
                driver.quit();
                driver = null;
            }
        }


  /*      public void checkAC(String message, String actual, String expected) {
            if (!actual.equals(expected)) {
                MyLogger.log.error("AC failed: " + message);
            }
            Assert.assertThat(message + "Browser - " + browser + " ScreenShot " + pathToScreenShot, actual, is(expected));
            setTestPass();
        }

        public void checkAC(String message, Boolean actual, Boolean expected) {
            if (!(actual == expected)) {
                MyLogger.log.error("AC failed: " + message);
            }
            Assert.assertThat(message + "Browser - " + browser + " ScreenShot " + pathToScreenShot, actual, is(expected));
            setTestPass();
        }

        private void setTestPass() {
            isTestPass = true;
        }
*/
}
