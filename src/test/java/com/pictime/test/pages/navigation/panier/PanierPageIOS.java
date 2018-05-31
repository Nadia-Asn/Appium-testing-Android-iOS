package com.pictime.test.pages.navigation.panier;

import static org.junit.Assert.assertNotEquals;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pictime.test.pages.utils.Contexte;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.concurrent.TimeUnit;

/**
 * Created by ahassounin
 */
public class PanierPageIOS extends PanierPage{

	private static String productName;

	@Override
	public void consulterMonPanier() {
		IOSDriver<WebElement> driver = (IOSDriver<WebElement>) ((WebDriverFacade)getDriver()).getProxiedDriver();
		driver.findElement(By.xpath("//*[@id=\"parentNodeAddToCart\"]/button")).click();
	}

	@Override
	public void addToCart() {
		IOSDriver<WebElement> driver = (IOSDriver<WebElement>) ((WebDriverFacade)getDriver()).getProxiedDriver();
		withTimeoutOf(30, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"parentNodeAddToCart\"]/button")));

		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"parentNodeAddToCart\"]/button")));
		//this.productName = driver.findElement(By.xpath("//*[@id=\"defaultTitle\"]")).getText();

		WebElement w = driver.findElement(By.xpath("//*[@id=\"fiche_current_img\"]"));
		String[] splitStr = w.getAttribute("title").split("    +");
		this.productName = splitStr[0];
		driver.findElement(By.xpath("//*[@id=\"parentNodeAddToCart\"]/button")).click();
		withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='size available ']")));

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='size available ']")));

		driver.findElement(By.xpath("//span[@class='size available ']")).click();
		waitABit(5000);
	}

	@Override
	public void checkProductInCart() {
		IOSDriver<WebElement> driver = (IOSDriver<WebElement>) ((WebDriverFacade)getDriver()).getProxiedDriver();
		waitABit(4000);
		WebElement el = driver.findElement(By.xpath("*//img[contains(@title, \"" + this.productName + "\" )]"));
		System.out.println(el.getAttribute("title"));
		assertNotEquals(el, null);
	}

}
