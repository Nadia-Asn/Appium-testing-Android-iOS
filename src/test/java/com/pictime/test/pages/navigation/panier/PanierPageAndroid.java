package com.pictime.test.pages.navigation.panier;

import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pictime.test.pages.utils.Contexte;

import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

/**
 * Created by ahassounin
 */
public class PanierPageAndroid extends PanierPage{

	private static String productName;

	@Override
	public void addToCart() {
		AndroidDriver<WebElement> driver = (AndroidDriver<WebElement>) ((WebDriverFacade)getDriver()).getProxiedDriver();
		Contexte.switchToWebview(driver);
		this.productName = driver.findElement(By.xpath("//*[@id=\"defaultTitle\"]")).getText();
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"parentNodeAddToCart\"]/button")));
		driver.findElement(By.xpath("//*[@id=\"parentNodeAddToCart\"]/button")).click();

		// ****************** Modifier le XPath par -> //span[@class='size available ']"
		driver.findElement(By.xpath("//*[@id=\"size-select-modal\"]/div/div[2]/div/span[1]")).click();
	}

	@Override
	public void checkProductInCart() {
		AndroidDriver<WebElement> driver = (AndroidDriver<WebElement>) ((WebDriverFacade)getDriver()).getProxiedDriver();
		waitABit(4000);
		WebElement el = driver.findElement(By.xpath("*//img[contains(@title,'"+this.productName+"')]"));
		assertNotEquals(el, null);
	}

	@Override
	public void consulterMonPanier() {
		AndroidDriver<WebElement> driver = (AndroidDriver<WebElement>) ((WebDriverFacade)getDriver()).getProxiedDriver();
		waitABit(5000);
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"parentNodeAddToCart\"]/button")));
		driver.findElement(By.xpath("//*[@id=\"parentNodeAddToCart\"]/button")).click();
	}
}
