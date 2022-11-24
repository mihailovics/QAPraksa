
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ExperimentTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void addElement(){

        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        List<WebElement> itemElements = driver.findElements(By.id("elements"));
        addButton.click();
        Assert.assertEquals(itemElements,1);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
