package runners.e2e;

import Pages.CartPages;
import Pages.CheckoutPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class e2eStandardUserTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    ItemListPage itemListPage = new ItemListPage(driver);

    CartPages cartPage = new CartPages(driver);
    CheckoutPage chekoutPage = new CheckoutPage(driver);

    @BeforeMethod
    public void setupClass(){
        String loginP = "https://www.saucedemo.com";
        driver.get(loginP);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void standardUserE2E(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        loginPage.checkUserIsLogged();
        itemListPage.addItemButton();
        itemListPage.checkItemAdded();
        itemListPage.clickCartIcon();
        cartPage.continueCheckout();
        chekoutPage.inputuserData("Ime","Prezime","23000");
        chekoutPage.clickContinueButton();
        chekoutPage.clickFinishOrderButton();
        chekoutPage.checkOrderIsCompleted();
        }
}
