package selenium.test.pages;

import org.junit.Assert;
import selenium.test.utils.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.test.webtestsbase.ElementActions;

import static org.hamcrest.core.Is.is;


/**
 * Created by pavelpozniakov on 14.06.17.
 */
public abstract class BasePage {

    WebDriver driver;
    ElementActions  elementActions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        elementActions = new ElementActions(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * Method to open page with url
     */
    public void open(String url) {
        try {
            driver.get(url);
            MyLogger.log.info("Page was opened with url: " + url);

        } catch (Exception e) {
            MyLogger.log.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

    public void checkTitle(String expectedTitle) {
        try {
            Assert.assertThat("Title do not match", driver.getTitle(), is(expectedTitle));
        }catch (Exception e) {
            MyLogger.log.error("Can not work with page ");
            Assert.fail("Can not work with page ");
        }
    }

}
