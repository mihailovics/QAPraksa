package runners.e2e;

import Pages.CartPages;
import Pages.CheckoutPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class e2eStandardUserTest {
    final static String loginP = "https://www.saucedemo.com";
    ChromeOptions options;
    WebDriver driver;
    LoginPage loginPage;
    ItemListPage itemListPage;
    CartPages cartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void refreshPage(){
        options = new ChromeOptions();
        driver = new ChromeDriver(options.setHeadless(true));
        driver.get(loginP);
        loginPage = new LoginPage(driver);
        itemListPage = new ItemListPage(driver);
        cartPage = new CartPages(driver);
        checkoutPage = new CheckoutPage(driver);
    }
    @AfterMethod
    public void closeBrowser(){
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
        checkoutPage.inputUserData("Ime","Prezime","23000");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishOrderButton();
        checkoutPage.checkOrderIsCompleted();
        }
}
