package com.pictime.test.pages.listesProduits;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.pictime.test.pages.utils.Contexte;

import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

public class ListeProduitPageAndroid extends ListeProduitPage{

	@Override
	public void verifierProduitDansLaListe(String produit) {
	}

	@Override
	public void choisirProduitDansLaListe(String produit) {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		Contexte.switchToWebview(driver);
		String xpath = "*//img[contains(@title,'"+produit+"')]";
        withTimeoutOf(50, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElementByXPath(xpath).click();
		
		//System.out.println(driver.findElementsByXPath("//*[@id=\"listarticles\"]/div[1]/div[1]/div[1]/div/div[8]/span[1]"));	
		//final WebElement w = driver.findElement(By.xpath("*//*[@id=\"listarticles\"]/ul/li[1]/div/span/span[1]/img"));
		Contexte.switchToNative(driver);
	}
	
	
	// Scroll in webView
	public void scroll() throws IOException {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        Dimension dimensions = driver.manage().window().getSize();
          System.out.println("Size of Window= " +dimensions);
          int scrollStart = (int) (dimensions.getHeight() * 0.5);
          System.out.println("Size of scrollStart= " +scrollStart);
          int scrollEnd = (int) (dimensions.getHeight() * 0.2);
          System.out.println("Size of cscrollEnd= " + scrollEnd);             
          //driver.swipe(0,scrollStart,0,scrollEnd,1000);           
          System.out.println("Swiped");
          
          
  		// Switch contexte to webView
  		/*Set<String> contextNames = driver.getContextHandles();
          for (String contextName : contextNames) {
              System.out.println(contextName);
              if (contextName.contains("WEBVIEW")){
                  driver.context("WEBVIEW_com.pictime.kiabi.activity");
              }
          }*/
    }
}
