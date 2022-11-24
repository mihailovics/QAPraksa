package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ItemListPage {
    WebDriver driver;

    By addItemButton = By.id("add-to-cart-sauce-labs-backpack");
    public ItemListPage(WebDriver driver){this.driver = driver;}
    public void addItemButton(){
        driver.findElement(addItemButton).click();
    }
    public void checkItemAdded(){
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge,driver.findElement(By.className("shopping_cart_badge")));
    }





}
