package com.pictime.test.pages.navigation.homePage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by elalailii on 01/03/2017.
 */
public class HomePageAndroid extends HomePage {

    @Override
    public void clickNextTuto(){
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        WebDriverWait wait = new WebDriverWait(driver, 50000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("vous aimez")));
        withTimeoutOf(5000, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("com.pictime.kiabi.activity:id/hp_tuto_explanations")));

        //withTimeoutOf(5000, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("option_three")));
        WebElement w = driver.findElement(By.id("com.pictime.kiabi.activity:id/hp_tuto_explanations"));
        //driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
         w.click();
        //WebDriverWait wait = new WebDriverWait(driver, 50000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("vous aimez")));
        //withTimeoutOf(5000, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("vous aimez")));

        //withTimeoutOf(5000, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("option_three")));

        //System.out.println("loulou");
        //driver.findElement(By.id("option_three")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        //driver.switchTo().alert().accept();
        //waitFor(driver.findElement(By.id("com.pictime.kiabi.activity:id/hp_tuto_explanations")));
        waitABit(2000);
        //driver.findElement(By.id("com.pictime.kiabi.activity:id/hp_tuto_explanations")).click();
    }
}
