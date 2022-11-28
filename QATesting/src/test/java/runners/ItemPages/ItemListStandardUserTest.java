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
    public void afterMetod(){
        driver.quit();
    }
    public void loginUser(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
    }
    @Test
    public void addItem(){
        loginUser();
        itemListPage.addItemButton();
        itemListPage.checkItemAdded();

    }
    @Test
    public void addMultipleItems(){
        loginUser();
        itemListPage.addItemButton();
        itemListPage.addSecondItem();
        itemListPage.checkMultipleItems();
    }
    @Test
    public void removeItem(){
        loginUser();
        itemListPage.addItemButton();
        itemListPage.addSecondItem();
        itemListPage.removeItem();
    }
    @Test
    public void checkRemovedItem(){
        loginUser();
        itemListPage.addItemButton();
        itemListPage.removeItem();
        itemListPage.checkItemRemoved();
    }

}

