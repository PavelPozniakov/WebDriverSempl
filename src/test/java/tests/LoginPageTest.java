package tests;

import org.junit.Assert;
import org.junit.Test;
import selenium.test.webtestsbase.WebDriverFactory;


public class LoginPageTest extends WebDriverFactory {
    public LoginPageTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogOn() {

        loginPage.open("https://www.bgames.com.ua/");
        loginPage.checkTitle("Кубик интернет-магазин | лучшие настольные игры Харьков Киев Днепропетровск Одесса Львов | купить настольную игру");
        loginPage.enterLogin("thesin.pp@gmail.com");
        loginPage.enterPass("2332kot!");
        loginPage.clickButtonLogin();

        Assert.assertTrue(loginPage.isLogged());
    }

    @Test
    public void invalidLogOn() {
        loginPage.open("https://www.bgames.com.ua/");
        loginPage.checkTitle("Кубик интернет-магазин | лучшие настольные игры Харьков Киев Днепропетровск Одесса Львов | купить настольную игру");
        loginPage.enterLogin("thesin.pp@gmail.com");
        loginPage.enterPass("909090");
        loginPage.clickButtonLogin();

        Assert.assertTrue(!loginPage.isLogged());
    }

}
