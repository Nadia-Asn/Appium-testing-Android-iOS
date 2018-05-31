package com.pictime.test.pages.navigation.rightMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;

/**
 * Created by ahassounin
 */
public abstract class RightMenuPageIOS extends  RightMenuPage{


    @Override
    public void meConnecter() {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        TouchAction action = new TouchAction(driver);
        waitABit(1000);
        action.tap(driver.findElement(By.id("Me connecter"))).perform();
    }
}
