import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DefaultTest {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setupClass(){
        String loginPage = "https://saucedemo.com";
        driver.get(loginPage);
    }


    @Test
    public void loginTest(){
        WebElement password = driver.findElement(By.id("password"));
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement loginButton = driver.findElement(By.name("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @AfterMethod
    private void tearDown(){
        driver.quit();
    }

}
