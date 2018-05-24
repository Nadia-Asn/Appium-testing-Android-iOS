package com.pictime.test.pages.listes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pictime.test.pages.listes.ListeCoursesPage;
import com.pictime.test.pages.utils.Contexte;

import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

public class ListeCoursesPageAndroid extends ListeCoursesPage {
	@Override
	public void produitDansListeCourses(String nomProduit) {
		withTimeoutOf(30, TimeUnit.SECONDS).elementIsPresent(By.xpath("//div[@class='text']/a[contains(text(),'"+nomProduit+"')]"));
	}

	@Override
	public void selectListeCourses(String liste) {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        Contexte.switchToWebview(driver, "wishlist");
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-main']")));
		driver.findElement(By.xpath("//span[contains(text(),'"+liste+"')]//../a")).click();
	}
}
