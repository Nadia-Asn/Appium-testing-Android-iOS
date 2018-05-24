package com.pictime.test.pages.listes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pictime.test.pages.utils.Contexte;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

public class ListeCoursesPageIOS extends ListeCoursesPage {

	@Override
	public void produitDansListeCourses(String nomProduit) {
		withTimeoutOf(30, TimeUnit.SECONDS).elementIsPresent(By.xpath("//div[@class='text']/a[contains(text(),'"+nomProduit+"')]"));
	}

	@Override
	public void selectListeCourses(String liste) {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        Contexte.switchToWebview(driver);
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-main']")));
		driver.findElement(By.xpath("//span[contains(text(),'"+liste+"')]//../a")).click();
	}

}
