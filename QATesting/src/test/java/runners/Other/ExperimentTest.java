package runners.Other;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ExperimentTest {
    WebDriver driver = new ChromeDriver();
    Actions actions;
    WebElement element;

    @BeforeClass
    public void setupClass() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void dropDown() {
        driver.quit();
    }

    @Test
    public void getTitle() {
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }
    @Test
    public void rightClick() {
        actions = new Actions(driver);
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        actions.contextClick(element).perform();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage,"You selected a context menu");
    }
    @Test
    public void hoverUser() {
        actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]"));
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
        Assert.assertTrue(element.isDisplayed(), "user2 expected");
    }
    @Test
    public void dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select options = new Select(driver.findElement(By.id("dropdown")));
        options.selectByValue("1");
        WebElement option1 = driver.findElement(By.cssSelector("option[value='1']"));
        Assert.assertTrue(option1.isSelected());

    }








}
