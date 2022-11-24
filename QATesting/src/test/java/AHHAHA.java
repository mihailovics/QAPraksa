import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AHHAHA {
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

        WebElement addButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addButton.click();
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge,driver.findElement(By.className("shopping_cart_badge")));

    }
}
