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
        //getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"ME CONNECTER\"]")).click();
        //getDriver().findElement(By.xpath("//*[contains(text(), 'ME CONNECTER')]")).click();

        getDriver().findElement(By.xpath("//*[@name=\"ME CONNECTER\"]")).click();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("mail")));
        getDriver().findElement(By.xpath("//*[@name=\"e-mail\"]")).clear();
        getDriver().findElement(By.xpath("//*[@name=\"e-mail\"]")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@name=\"mot de passe\"]")).sendKeys(password+"\n");

        // à remettre when merge ids to branch
        //withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("emailInput")));
        //getDriver().findElement(By.id("emailInput")).clear();
        //getDriver().findElement(By.id("emailInput")).sendKeys(email);
        //getDriver().findElement(By.id("passwordInput")).sendKeys(password+"\n");
    }

    @Override
    public void validateLogin() {
        getDriver().findElement(By.id("Je me connecte")).click();
    }

    @Override
    public void checkConnectionSuccess() {
        getDriver().findElement(By.id("Compte")).click();
        WebElement msgWelcome = getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"BONJOUR\"]"));
        assertNotEquals(msgWelcome, null);
    }
}