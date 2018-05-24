package com.pictime.test.pages.compte.login;

import com.pictime.test.pages.compte.login.LoginPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by zeggaim on 20/05/2016.
 */
public class LoginPageIOS extends LoginPage {

    public void login(String email, String password){
        getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"ME CONNECTER\"]")).click();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("emailInput")));
        getDriver().findElement(By.id("emailInput")).clear();
        getDriver().findElement(By.id("emailInput")).sendKeys(email);
        getDriver().findElement(By.id("passwordInput")).sendKeys(password+"\n");
    }

    @Override
    public void validateLogin() {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        action.tap(driver.findElement(By.id("Je me connecte"))).perform().waitAction();
    }

    @Override
    public void checkConnectionSuccess() {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        action.tap(driver.findElement(By.id("Compte"))).perform().waitAction();

        WebElement msgWelcome = driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"BONJOUR\"]"));
        assertNotEquals(msgWelcome, null);
    }
}