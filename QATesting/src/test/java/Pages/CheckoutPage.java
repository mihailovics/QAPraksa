package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CheckoutPage {
    WebDriver driver;
    By continueButton = By.id("continue");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zipCode = By.id("postal-code");
    By cancelButton = By.id("cancel");
    By finishButton = By.id("finish");
    By orderCompletedMessage = By.className("pony_express");
    public CheckoutPage(WebDriver driver){this.driver = driver;}

    public void inputUserData(String strFirstName, String strLastName,String strZipCode){
        driver.findElement(firstName).sendKeys(strFirstName);
        driver.findElement(lastName).sendKeys(strLastName);
        driver.findElement(zipCode).sendKeys(strZipCode);
    }
    public void continueFailed(){
        driver.findElement(continueButton).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public void clickFinishOrderButton(){
        driver.findElement(finishButton).click();
    }
    public void checkOrderIsCompleted(){
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        soft.assertTrue(driver.findElement(orderCompletedMessage).isDisplayed());
        soft.assertAll();
    }
}
