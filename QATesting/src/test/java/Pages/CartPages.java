package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPages {
    WebDriver driver;
    By checkoutButton = By.id("checkout");
    By continueShopping = By.id("continue-shopping");
    By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    By itemPrice = By.className("inventory_item_price");
    By item = By.className("inventory_item_name");
    public CartPages(WebDriver driver){this.driver = driver;}

    public void itemIsAdded(){
        Assert.assertTrue(driver.findElement(By.className("inventory_item_name")).isDisplayed());
    }
    public void removeBackpackItem(){
        driver.findElement(removeBackpackButton).click();
        boolean removed = driver.findElements(By.linkText("Remove")).size()!=0;
        Assert.assertFalse(removed);
    }
    public void continueCheckout(){
        driver.findElement(checkoutButton).click();
    }
}
