package selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.webtestsbase.ElementActions;

public class HomePage extends BasePage {

    private static final String PAGE_URL = "https://www.bgames.com.ua/";

    @FindBy(css = "#masthead-search button")
    private WebElement searchButtonElement;

    @FindBy(xpath = ".//input[@id=\"masthead-search-term\"]")
    private WebElement searchStringElement;

    public HomePage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return searchStringElement.isDisplayed();
    }

 /*   public boolean isElementPresent() {
        return ElementActions.isElementPresent(searchStringElement);
    }*/

    public void insertSearchString(String text) {
        searchStringElement.sendKeys(text);
    }

    public SearchResultsPage doSearch(){
        searchButtonElement.click();
        return new SearchResultsPage();
    }

    private void clearSearchString(){
        searchStringElement.clear();
    }

    public String getSearchStringText(){
        return searchStringElement.getAttribute("value");
    }
}
