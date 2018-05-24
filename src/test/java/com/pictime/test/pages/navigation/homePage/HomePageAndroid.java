package com.pictime.test.pages.navigation.homePage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by elalailii on 01/03/2017.
 */
public class HomePageAndroid extends HomePage {

    @Override
    public void clickNextTuto(){
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        driver.findElement(By.id("com.pictime.kiabi.activity:id/hp_tuto_explanations")).click();
    }
}
