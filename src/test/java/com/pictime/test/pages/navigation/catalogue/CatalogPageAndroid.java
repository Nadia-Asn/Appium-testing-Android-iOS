package com.pictime.test.pages.navigation.catalogue;

import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pictime.test.pages.utils.Contexte;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by ahassounin
 */
public class CatalogPageAndroid extends CatalogPage {


    @Override
    public void visualizeProductDetails() {

        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        Contexte.switchToWebview(driver);
        System.out.println("url actuel => " + driver.getCurrentUrl());
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@name=\"urlProduct\"])[1]")));
        driver.findElement(By.xpath("(//*[@name=\"urlProduct\"])[3]")).click();
    }

	@Override
	public void addToBuyList(String liste, String nomProduit) {
//		withTimeoutOf(20, TimeUnit.SECONDS).waitForAbsenceOf("//android.widget.ProgressBar");
//        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
//        WebElement boutonListes = driver.findElement(By.xpath(
//        		"//a[contains(text(),'"+nomProduit+"')]/parent::*/parent::*/parent::*/parent::*//a[@class='link-wishlist']"));
//        boutonListes.click();
//        WebElement listeSelectionnee = driver.findElement(By.xpath(
//        		"//a[contains(text(),'"+nomProduit+"')]/parent::*/parent::*/parent::*/parent::*//ul/li/a/span[contains(text(),'"+liste+"')]"));
//        listeSelectionnee.click();
	}


}
