package com.pictime.test.pages.navigation.storeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pictime.test.pages.utils.Scroll;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.concurrent.TimeUnit;

/**
 * Created by zeggaim on 20/05/2016.
 */
public class StoreLocatorPageAndroid extends StoreLocatorPage {
	
    public void chooseStore(String magasin){
        //withTimeoutOf(100, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("storelocator_drive_select")));
        
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        
        String xpathBoutton = "//android.support.v7.widget.RecyclerView//android.widget.TextView[@text='"+magasin+"']//ancestor::*[contains(@resource-id,'storelocator_drive_container')]//android.widget.TextView[@text='Faire mes courses']";
        Scroll.scrollDownUntilElementIsVisible(driver, xpathBoutton, (MobileElement)driver.findElement(By.id("content")));
        getDriver().findElement(By.xpath(xpathBoutton)).click();
    }

	@Override
	public void renseignerVille(String magasin) {
		//withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("storelocator_searchbar")));
	}
}
