package runners;

import Pages.LoginPage;
import Pages.SortPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class SortTests {
    final static String loginPageUrl = "https://saucedemo.com";
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    SortPage sortPage = new SortPage(driver);
    @BeforeClass
    public void setupClass(){
        String loginPage = loginPageUrl;
        driver.get(loginPage);
    }
    @BeforeMethod
    private void refreshPage(){
        driver.get(loginPageUrl);
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void sortFromAtoZ(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        sortPage.sortFromAtoZ();
    }
    @Test
    public void sortFromZtoA(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        sortPage.sortFromZtoA();
    }
    @Test
    public void sortFromLowToHigh(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        sortPage.sortFromLowtoHigh();
    }
    @Test
    public void sortFromHighToLow(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        sortPage.sortFromHightoLow();
    }

}
