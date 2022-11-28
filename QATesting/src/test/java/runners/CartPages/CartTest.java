package runners.CartPages;

import Pages.CartPages;
import Pages.ItemListPage;
import Pages.LoginPage;
import Pages.SortPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest {
    final static String loginPageUrl = "https://saucedemo.com";
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    ItemListPage itemPage = new ItemListPage(driver);
    CartPages cartPage = new CartPages(driver);
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
}
