package runners.CheckoutPages;

import Pages.CartPages;
import Pages.CheckoutPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests {
    final static String loginPageUrl = "https://saucedemo.com";
    WebDriver driver;
    LoginPage loginPage;
    ItemListPage itemPage;
    CartPages cartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void refreshPage() {
        driver = new ChromeDriver();
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
        itemPage = new ItemListPage(driver);
        cartPage = new CartPages(driver);
        checkoutPage = new CheckoutPage(driver);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void checkOrderIsCompleted(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemPage.addItemButton();
        itemPage.clickCartIcon();
        cartPage.continueCheckout();
        checkoutPage.inputUserData("Stevan","Mihailovic","23000");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishOrderButton();
        checkoutPage.checkOrderIsCompleted();
    }
    @Test
    public void cancelOrderFromInput(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemPage.addItemButton();
        itemPage.clickCartIcon();
        cartPage.continueCheckout();
        checkoutPage.cancelOrderFromInput();
    }
    @Test
    public void cancelOrderAtFinish(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemPage.addItemButton();
        itemPage.clickCartIcon();
        cartPage.continueCheckout();
        checkoutPage.inputUserData("Stevan","Mihailovic","23000");
        checkoutPage.clickContinueButton();
        checkoutPage.cancelOrderAtOverview();
    }
}
