package com.pictime.test.pages.navigation.homePage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zeggaim on 20/05/2016.
 */
public class HomePageIOS extends HomePage{

	@Override
	public void clickNextTuto() {
		IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		TouchAction action = new TouchAction(driver);
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		waitABit(2000);
		driver.switchTo().alert().accept();
		waitABit(2000);
		// Passer le tutoriel homePage uniquemement en recette mnt
		WebElement tuto = driver.findElement(By.id("onBoardingText.png"));
		tuto.click();
		waitABit(2000);
	}
}
