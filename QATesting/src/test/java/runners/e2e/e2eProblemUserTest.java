package runners.e2e;

import Pages.CartPages;
import Pages.CheckoutPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class e2eProblemUserTest {
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
    public void problemUserE2E(){
        loginPage.loginToSauceDemo("problem_user","secret_sauce");
        loginPage.checkUserIsLogged();
        itemListPage.addItemButton();
        itemListPage.checkItemAdded();
        itemListPage.clickCartIcon();
        cartPage.continueCheckout();
        checkoutPage.inputUserData("Ime","Prezime","23000");
        checkoutPage.continueFailed();

    }
}
