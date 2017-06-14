package tests;

import selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class SimpleTest {

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser();
    }


    @Test
    public void testFillGoogleForm() {
        String toSearch = "Selenium";
        WebDriverFactory.getDriver().get("http://www.youtube.com");
        WebElement searchString = WebDriverFactory.getDriver().findElement(By.cssSelector("#masthead-search-term"));
        searchString.sendKeys(toSearch);
        String searchStringText = searchString.getAttribute("value");
        assertTrue("Text from page(" + searchStringText + ") not equals to text from test(" + toSearch + ")",
                searchStringText.equals(toSearch));
    }


    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
