package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.*;

public class LoginPage {
    WebDriver driver;

    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private void setUserName(String struserName){
        driver.findElement(userName).sendKeys(struserName);
    }
    private void setPassword(String strpassword){
        driver.findElement(password).sendKeys(strpassword);
    }
    private void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void loginToSauceDemo(String strUserName, String strPassword){
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLoginButton();
    }
    public void checkUserIsLogged(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    public void checkLoginFailed(){
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    public void copyPasswordTest(){
        WebElement el = driver.findElement(password);
        WebElement al = driver.findElement(userName);
        el.sendKeys("steva");
        el.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        el.sendKeys(Keys.chord(Keys.CONTROL,"c"));
        al.sendKeys(Keys.chord(Keys.CONTROL,"v"));
        Assert.assertEquals(al.getText(),"");
    }
}
