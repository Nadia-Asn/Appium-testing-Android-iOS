package com.pictime.test.pages.listesProduits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pictime.test.pages.utils.Contexte;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

public class ListeProduitPageIOS extends ListeProduitPage{

	@Override
	public void verifierProduitDansLaListe(String produit) {
		
	}

	@Override
	public void choisirProduitDansLaListe(String produit) {
		IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		Contexte.switchToWebview(driver, "kiabi");
		//Contexte.switchToWebview(driver);
		String xpath = "*//img[contains(@title,'"+produit+"')]";
        withTimeoutOf(50, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElementByXPath(xpath).click();
		waitABit(5000);
		Contexte.switchToNative(driver);
	}

}
