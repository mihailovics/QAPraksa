package runners.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.*;
import Pages.LoginPage;

public class LoginTests {
    final static String loginPageUrl="https://saucedemo.com";
    WebDriver driver;
    LoginPage loginPage;


    @BeforeMethod
    private void refreshPage(){
        driver = new ChromeDriver();
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void loginStandardUser(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        loginPage.checkUserIsLogged();
    }
    @Test
    public void loginLockedOutUser(){
        loginPage.loginToSauceDemo("locked_out_user","secret_sauce");
        loginPage.checkLoginFailed();
    }
    @Test
    public void checkInvalidCredentials(){
        loginPage.loginToSauceDemo("steva","secret");
        loginPage.checkLoginFailed();
    }
    @Test
    public void loginGlitchedUser(){
        throw new SkipException("preskoci");
        //loginPage.loginToSauceDemo("performance_glitch_user","secret_sauce");
        //loginPage.checkUserIsLogged();

    }

    @Test
    public void loginProblemUser(){
        loginPage.loginToSauceDemo("problem_user","secret_sauce");
        loginPage.checkUserIsLogged();
    }
    @Test
    public void loginBlankUser(){
        loginPage.loginToSauceDemo("","secret_sauce");
        loginPage.checkLoginFailed();
    }
    @Test
    public void loginBlankPassword(){
        loginPage.loginToSauceDemo("standard_user","");
        loginPage.checkLoginFailed();
    }
    @Test
    public void copyPassTest(){
        loginPage.copyPasswordTest();
    }

}
