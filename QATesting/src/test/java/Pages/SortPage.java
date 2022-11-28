package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SortPage {
    WebDriver driver;

    public SortPage(WebDriver driver){
        this.driver = driver;
    }

    By sortButton = By.className("product_sort_container");


    public void sortFromAtoZ(){
        Select sortButtons = new Select(driver.findElement(sortButton));
        driver.findElement(sortButton).click();
        sortButtons.selectByValue("az");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).getText(),"Sauce Labs Backpack");
    }
    public void sortFromZtoA(){
        Select sortButtons = new Select(driver.findElement(sortButton));
        driver.findElement(sortButton).click();
        sortButtons.selectByValue("za");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).getText(),"Test.allTheThings() T-Shirt (Red)");
    }
    public void sortFromLowtoHigh(){
        Select sortButtons = new Select(driver.findElement(sortButton));
        driver.findElement(sortButton).click();
        sortButtons.selectByValue("lohi");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div")).getText(),"$7.99");
    }
    public void sortFromHightoLow(){
        Select sortButtons = new Select(driver.findElement(sortButton));
        driver.findElement(sortButton).click();
        sortButtons.selectByValue("hilo");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div")).getText(),"$49.99");
    }



}
