package selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.utils.MyLogger;

/**
 * Created by pavelpozniakov on 15.06.17.
 */
public class LoginPage extends BasePage {


    @FindBy(name = "email_address")
    WebElement loginInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(xpath = ".//input[@class='login-submit']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        elementActions.enterText(loginInput, login);
    }

    public void enterPass(String password) {
        elementActions.enterText(passwordInput, password);
    }

    public void clickButtonLogin() {
        elementActions.clickOnElement(loginButton);
    }

    public boolean isLogged() {
        return elementActions.isElementPresent(".//td[@class='z1']//a[9]");
    }

}
