package runners.ItemPages;

import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ItemListStandardUserTest {
    WebDriver driver;
    LoginPage loginPage;
    ItemListPage itemListPage;
    final static String loginPageUrl="https://saucedemo.com";

    @BeforeMethod
    public void refreshPage(){
        driver = new ChromeDriver();
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
        itemListPage = new ItemListPage(driver);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void addItem(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemListPage.addItemButton();
        itemListPage.checkItemAdded();

    }
    @Test
    public void addMultipleItems(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemListPage.addItemButton();
        itemListPage.addSecondItem();
        itemListPage.checkMultipleItems();
    }
    @Test
    public void removeItem(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemListPage.addItemButton();
        itemListPage.addSecondItem();
        itemListPage.removeItem();
    }
    @Test
    public void checkRemovedItem(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemListPage.addItemButton();
        itemListPage.removeItem();
        itemListPage.checkItemRemoved();
    }

}

