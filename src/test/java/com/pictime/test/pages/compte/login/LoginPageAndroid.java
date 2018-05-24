package com.pictime.test.pages.compte.login;

import com.pictime.test.pages.compte.login.LoginPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by zeggaim on 20/05/2016.
 */
public class LoginPageAndroid extends LoginPage {

    public void login(String userName, String password){
        //Click in "meConnecter"
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        action.tap(driver.findElement(By.id("com.pictime.kiabi.activity:id/myaccount_welcome"))).perform();

        // Enter email
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("com.pictime.kiabi.activity:id/login")));
        find(By.id("com.pictime.kiabi.activity:id/login")).clear();
        getDriver().findElement(By.id("com.pictime.kiabi.activity:id/login")).sendKeys(userName);

        //Enter password
        find(By.id("com.pictime.kiabi.activity:id/mdp")).clear();
        getDriver().findElement(By.id("com.pictime.kiabi.activity:id/mdp")).sendKeys(password+"\n\n");
    }

    @Override
    public void validateLogin() {
        waitABit(2000);
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        action.tap(driver.findElement(By.id("com.pictime.kiabi.activity:id/btn_valider"))).perform().waitAction();
    }

    @Override
    public void checkConnectionSuccess() {
        waitABit(5000);
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        WebElement msgWelcome = driver.findElement(By.id("com.pictime.kiabi.activity:id/myaccount_welcome"));
        assertNotEquals(msgWelcome, null);
        System.out.println("Connection réussie");
    }

}
