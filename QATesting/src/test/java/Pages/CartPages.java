package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPages {
    WebDriver driver;
    By checkoutButton = By.id("checkout");
    By continueShopping = By.id("continue-shopping");
    By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    By itemPrice = By.className("inventory_item_price");

    public CartPages(WebDriver driver){this.driver = driver;}

    public void itemIsAdded(){

    }
    public void continueCheckout(){
        driver.findElement(checkoutButton).click();
    }
}
