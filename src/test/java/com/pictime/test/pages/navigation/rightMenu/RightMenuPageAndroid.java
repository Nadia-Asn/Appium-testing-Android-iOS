package com.pictime.test.pages.navigation.rightMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;

public class RightMenuPageAndroid extends RightMenuPage {

    /*@Override
    public void meConnecter() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        action.tap(driver.findElement(By.id("com.pictime.kiabi.activity:id/myaccount_welcome"))).perform().waitAction();
    }*/
}
