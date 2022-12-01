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
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options.setHeadless(true));
    LoginPage loginPage = new LoginPage(driver);
    ItemListPage itemListPage = new ItemListPage(driver);

    CartPages cartPage = new CartPages(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @BeforeMethod
    public void refreshPage(){
        String loginP = "https://www.saucedemo.com";
        driver.get(loginP);

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
