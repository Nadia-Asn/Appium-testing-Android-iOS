package com.pictime.test.pages.navigation.tabBar;

import java.util.List;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

/**
 * 
 * Created by ahassounin
 *
 */

public class TabBarAndroid extends TabBar {

	@Override
	public void searchProduct(String nomProduit) {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		TouchAction action = new TouchAction(driver);
		WebElement we = driver.findElement(By.id("com.pictime.kiabi.activity:id/bottom_navigation_search"));
		we.click();
		driver.getKeyboard().sendKeys(nomProduit);
	}

	@Override
	public void chooseProductInSuggestion() {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		waitABit(2000);
		List<WebElement> el1 = driver.findElements(By.id("com.pictime.kiabi.activity:id/suggestion_item"));
		el1.get(2).click();
	}

	@Override
	public void myAccount() {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		TouchAction action = new TouchAction(driver);
		waitABit(1000);
		driver.findElement(By.id("com.pictime.kiabi.activity:id/bottom_navigation_account")).click();
		waitABit(1000);

	}

	@Override
	public void stores() {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		TouchAction action = new TouchAction(driver);
		waitABit(1000);
		action.tap(driver.findElement(By.id("com.pictime.kiabi.activity:id/bottom_navigation_magasin"))).perform().waitAction();
	}

	@Override
	public void gotoCollection() {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		waitABit(1000);
		//WebElement w = driver.findElement(By.id("com.pictime.kiabi.activity:id/textview_dropdown"));
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView()", w);

		waitABit(6000);
		driver.findElement(By.id("com.pictime.kiabi.activity:id/bottom_navigation_account")).click();
		driver.findElement(By.id("com.pictime.kiabi.activity:id/bottom_navigation_home")).click();
		List<WebElement> collections = driver.findElements(By.id("com.pictime.kiabi.activity:id/cardView"));
		collections.get(0).click();
	}

}
