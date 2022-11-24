package runners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemo {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setupClass(){
        String loginPage = "https://saucedemo.com";
        driver.get(loginPage);
    }
    @Test
    public void loginTest(){


        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.name("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");


    }
    @Test
    public void addItem(){
        loginTest();
        WebElement addButton = driver.findElement(By.className("btn_inventory"));
        addButton.click();
        WebElement cartBagde = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBagde,driver.findElement(By.className("shopping_cart_badge")));

    }

}
