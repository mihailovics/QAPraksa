package runners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.util.List;


public class DefaultTest {

    WebDriver driver = new ChromeDriver();
    String loginPage = "https://saucedemo.com";
    @BeforeMethod
    public void setupClass(){
        driver.get(loginPage);
    }

    @AfterMethod
    public void shutDown(){
        driver.quit();
    }


    @Test
    public void loginTest(){
        driver.get(loginPage);
        WebElement password = driver.findElement(By.id("password"));
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement loginButton = driver.findElement(By.name("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void addItem(){
        loginTest();
        WebElement addButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addButton.click();
        WebElement cartBagde = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBagde,driver.findElement(By.className("shopping_cart_badge")));

    }
    @Test
    public void removeItem(){
        addItem();
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeButton.click();
        List<WebElement> cartBadges = driver.findElements(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadges.stream().count(),0);

    }




}
