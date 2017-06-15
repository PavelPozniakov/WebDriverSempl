package selenium.test.webtestsbase;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.test.utils.MyLogger;

/**
 * Created by pavelpozniakov on 15.06.17.
 */
public class ElementActions {
    WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String xpathLocator, String text) {
        try {
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            MyLogger.log.info(text + " was inputed");
        } catch (Exception e) {
            MyLogger.log.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }

    public void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            MyLogger.log.info(text + " was inputed");
        } catch (Exception e) {
            MyLogger.log.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }

    public void clickOnElement(String xpathLocator) {
        try {
            driver.findElement(By.xpath(xpathLocator)).click();
            MyLogger.log.info("Element was clicked");

        } catch (Exception e) {
            MyLogger.log.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            MyLogger.log.info("Element was clicked");

        } catch (Exception e) {
            MyLogger.log.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }

    public boolean isElementPresent(String xpathLocator) {
        try {
            WebElement webElement = driver.findElement(By.xpath(xpathLocator));
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
