package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class ItemListPage {
    WebDriver driver;


    By addItem1Button = By.id("add-to-cart-sauce-labs-backpack");
    By addItem2Button = By.id("add-to-cart-sauce-labs-bike-light");
    public ItemListPage(WebDriver driver){this.driver = driver;}
    public void addItemButton(){
        driver.findElement(addItem1Button).click();
    }
    public void addSecondItem(){
        driver.findElement(addItem2Button).click();
    }
    public void checkItemAdded(){
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge,driver.findElement(By.className("shopping_cart_badge")));
    }
    public void checkMultipleItems(){
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(),"2");
    }





}
