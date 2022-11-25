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
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    final static String loginPageUrl="https://saucedemo.com";
    ItemListPage itemListPage = new ItemListPage(driver);

    @BeforeClass
    public void setupClass(){
        String loginPage = loginPageUrl;
        driver.get(loginPage);
    }
    @BeforeMethod
    private void refreshPage(){

        driver.get(loginPageUrl);
    }
    //login
    //add to cart
    public void loginUser(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
    }
    @Test
    public void addItem(){
        loginUser();
        itemListPage.addItemButton();
        itemListPage.checkItemAdded();

    }
    //login
    //add to cart vise itema
    @Test
    public void addMultipleItems(){
        loginUser();
        itemListPage.addSecondItem();
        itemListPage.checkMultipleItems();
    }
    @Test
    public void removeItem(){
        loginUser();
        itemListPage.removeItem();
    }
}





//login
//add to cart
//remove