	package com.pictime.test.pages.navigation.catalogue;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import org.openqa.selenium.By;

import com.pictime.test.pages.utils.Contexte;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

    /**
     * Created by ahassounin
     */
public class CatalogPageIOS extends CatalogPage{

	@Override
	public void addToBuyList(String liste, String nomProduit) {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        Contexte.switchToWebview(driver);

        String xpath = "(//*[@name=\"urlProduct\"])[1]";

        withTimeoutOf(50, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElementByXPath(xpath).click();
        waitABit(2000);
        Contexte.switchToNative(driver);

	}

    @Override
    public void visualizeProductDetails() {

        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();

        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            System.out.println("All contexts :" + contexts);
            if (!context.equals("NATIVE_APP")) {
                System.out.println("WEBVIEW context=> " + contexts);
            }
        }


        Contexte.switchToWebview(driver);
        System.out.println("url actuel => " + driver.getCurrentUrl());
        for (String context : contexts) {
            System.out.println("All contexts :" + contexts);
            if (!context.equals("NATIVE_APP")) {
                System.out.println("WEBVIEW context=> " + contexts);
            }
        }
        waitABit(2000);
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@name=\"urlProduct\"])[1]")));
        List<WebElement> products = driver.findElements(By.xpath("//*[@name=\"urlProduct\"]/div[1]/a[1]/div/div[1]/img"));
        products.get(3).click();
        System.out.println("tototoo");
    }
}
