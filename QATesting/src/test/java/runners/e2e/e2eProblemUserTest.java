package runners.e2e;

import Pages.CartPages;
import Pages.CheckoutPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class e2eProblemUserTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    ItemListPage itemListPage = new ItemListPage(driver);

    CartPages cartPage = new CartPages(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

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
    public void problemUserE2E(){
        loginPage.loginToSauceDemo("problem_user","secret_sauce");
        loginPage.checkUserIsLogged();
        itemListPage.addItemButton();
        itemListPage.checkItemAdded();
        itemListPage.clickCartIcon();
        cartPage.continueCheckout();
        checkoutPage.inputuserData("Ime","Prezime","23000");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishOrderButton();
        checkoutPage.checkOrderIsCompleted();
    }
}
