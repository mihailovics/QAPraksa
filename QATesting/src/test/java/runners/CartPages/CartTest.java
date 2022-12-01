package runners.CartPages;

import Pages.CartPages;
import Pages.ItemListPage;
import Pages.LoginPage;
import Pages.SortPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CartTest {
    final static String loginPageUrl = "https://saucedemo.com";
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;
    ItemListPage itemPage;
    CartPages cartPage;

    @BeforeMethod
    public void refreshPage() {
        driver = new ChromeDriver();
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
        itemPage = new ItemListPage(driver);
        cartPage = new CartPages(driver);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void itemAdded(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemPage.addItemButton();
        itemPage.clickCartIcon();
        cartPage.itemIsAdded();
    }
    @Test
    public void removeFirstItem(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemPage.addItemButton();
        itemPage.clickCartIcon();
        cartPage.removeBackpackItem();
    }
    @Test
    public void continueShopping(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemPage.addItemButton();
        itemPage.clickCartIcon();
        cartPage.continueToShopping();
    }
}
