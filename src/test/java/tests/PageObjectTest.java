package tests;

import selenium.test.pages.HomePage;
import selenium.test.pages.SearchResultsPage;
import org.junit.Test;
import selenium.test.webtestsbase.WebDriverFactory;

import static org.junit.Assert.assertTrue;

public class PageObjectTest extends WebDriverFactory {

    public PageObjectTest(String browser) { super(browser);}

    @Test
    public void testSearch() {
        String toSearch = "Selenium";
        HomePage homePage = new HomePage();
        homePage.insertSearchString(toSearch);
        SearchResultsPage resultsPage = homePage.doSearch();
        assertTrue("No results were found on results page", resultsPage.hasResults());
    }
}
