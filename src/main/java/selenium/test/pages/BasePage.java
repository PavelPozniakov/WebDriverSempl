package selenium.test.pages;

import selenium.test.utils.TimeUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.test.webtestsbase.WebDriverFactory;


/**
 * Created by pavelpozniakov on 14.06.17.
 * Main class for pages. Page class - must be extended from this
 */
public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 5;

    protected abstract void openPage();

    /**
     * checks is page opened
     * @return true if opened
     */
    public abstract boolean isPageOpened();

    public BasePage(boolean openPageByUrl){
        if(openPageByUrl){
            openPage();
        }
        PageFactory.initElements(getDriver(), this);
        waitForOpen();
    }

    /**
     * Waiting for page opening
     */
    protected void waitForOpen(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS) {
            TimeUtils.waitForSeconds(1);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if(!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }

    /**
     * getting webdriver instance
     * @return initialized in tests webdriver instance
     */
    protected WebDriver getDriver(){
        return WebDriverFactory.getDriver();
    }

}
