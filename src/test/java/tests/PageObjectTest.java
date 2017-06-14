package tests;

import selenium.test.pages.YouTubePage;
import selenium.test.pages.YouTubeSearchResultsPage;
import selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PageObjectTest {

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser();
    }

    @Test
    public void testSearch() {
        String toSearch = "Selenium";
        YouTubePage youTubePage = new YouTubePage();
        youTubePage.insertSearchString(toSearch);
        YouTubeSearchResultsPage resultsPage = youTubePage.doSearch();
        assertTrue("No results were found on results page", resultsPage.hasResults());
    }


    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}
