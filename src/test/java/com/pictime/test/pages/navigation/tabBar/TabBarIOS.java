package com.pictime.test.pages.navigation.tabBar;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import com.pictime.test.pages.utils.Contexte;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.List;

/**
 *
 * Created by ahassounin
 *
 */

public class TabBarIOS extends TabBar {

	@Override
	public void searchProduct(String nomProduit) {
		IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		//WebElement btnSearch = driver.findElement(By.id("KB_TB_SEARCH")); // prod
		WebElement btnSearch = driver.findElement(By.id("Recherche")); // recette
		btnSearch.sendKeys("robe");
		waitABit(2000);
	}

	@Override
	public void chooseProductInSuggestion() {
		IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		//WebElement elListe = driver.findElement(By.id("Robe Femme"));
		List<WebElement> suggestions = driver.findElements(By.className("XCUIElementTypeCell"));
		suggestions.get(1).click();
	}

	@Override
	public void myAccount() {
		IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		driver.findElement(By.id("Compte")).click();
		waitABit(1000);
	}

	@Override
	public void stores() {

	}
	@Override
	public void gotoCollection() {
		IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		List<WebElement> collectionHP = driver.findElements(By.className("XCUIElementTypeCell"));
		collectionHP.get(0).click();
		//firstCollection.click();
	}

}
