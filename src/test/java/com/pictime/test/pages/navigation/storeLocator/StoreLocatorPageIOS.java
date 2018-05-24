package com.pictime.test.pages.navigation.storeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.concurrent.TimeUnit;

/**
 * Created by zeggaim on 20/05/2016.
 */
public class StoreLocatorPageIOS extends StoreLocatorPage {
    public void chooseStore(String magasin){
    	IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
    	driver.rotate(ScreenOrientation.LANDSCAPE);
        withTimeoutOf(100, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("Faire mes courses")));
        WebElement store = getDriver().findElement(By.xpath("//UIAStaticText[@name='"+magasin+"']/parent::*/UIAButton[@name='Faire mes courses']"));
        store.click();	
    }

	@Override
	public void renseignerVille(String magasin) {
		getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[2]/UIATextField[1]")).sendKeys(magasin);
		IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		driver.getKeyboard().pressKey(Keys.ENTER);
	}
}
