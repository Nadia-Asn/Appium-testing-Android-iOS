package com.pictime.test.pages.compte.accoutCreation;

import com.pictime.test.pages.utils.Contexte;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

public class AccountCreationPageAndroid extends AccountCreationPage {

    @Override
    public void createAccount() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);

        action.tap(driver.findElement(By.id("com.pictime.kiabi.activity:id/myaccount_welcome"))).perform();

        waitABit(5000);
        action.tap(driver.findElement(By.id("com.pictime.kiabi.activity:id/btn_creer"))).perform();
    }

    @Override
    public void fillAccountInformation(String prenom, String nom, String email, String password, String code) {

        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        Contexte.switchToWebview(driver, "sign");
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));
        driver.findElement(By.xpath("//*[@id=\"title\"]")).click();

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]/option[2]")));
        driver.findElement(By.xpath("//*[@id=\"title\"]/option[2]")).click();

        waitABit(2000);
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.click();
        firstName.sendKeys(prenom);

        waitABit(2000);
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastName.click();
        lastName.sendKeys(nom);

        waitABit(2000);
        WebElement emailMap = driver.findElement(By.xpath("//*[contains(@id,'emailMap')]"));
        emailMap.click();
        emailMap.sendKeys(generateMailAdr());

        waitABit(2000);
        WebElement passwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwd.click();
        passwd.sendKeys(password);

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].scrollIntoView()", passwd);
        driver.findElement(By.xpath("//*[@id=\"birthDay\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthDay\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthMonth\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthMonth\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthYear\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthYear\"]/option[26]")).click();

        WebElement captcha = driver.findElement(By.xpath("//*[@id=\"captchaAccountCreation\"]"));
        captcha.click();
        captcha.sendKeys(code);
    }

    @Override
    public void validateAccountCreation() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        driver.findElement(By.xpath("//*[@id=\"formCreateAccount\"]/div[14]/a")).click();
        Contexte.switchToNative(driver);
        waitABit(5000);
    }

    @Override
    public void assertCreationAccountOK() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        Contexte.switchToNative(driver);
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("com.pictime.kiabi.activity:id/btn_valider")));
        waitABit(5000);
    }

    @Override
    public String generateMailAdr() {
        return "selenium" + String.valueOf(System.currentTimeMillis() / 1000) + "@yopmail.com";
    }
}
