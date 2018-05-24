package com.pictime.test.pages.navigation.sidebar;

import org.openqa.selenium.By;
import com.pictime.test.pages.utils.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;


/**
 * Created by zeggaim on 20/05/2016.
 */
public class SidebarPageAndroid extends SidebarPage {

	@Override
	public void consulterUnivers(String univers) {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		String xpathUnivers = "//android.widget.TextView[@text='"+univers+"']";
		Scroll.scrollDownUntilElementIsVisible(driver, xpathUnivers, (MobileElement)driver.findElement(By.id("menu_catalogue_container")));
		driver.findElement(By.xpath(xpathUnivers)).click();
	}

	@Override
	public void consulterCategorie(String categorie) {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		String xpathCategorie = "//android.widget.TextView[@text='"+categorie+"']";
		Scroll.scrollDownUntilElementIsVisible(driver, xpathCategorie, (MobileElement)driver.findElement(By.id("catalog_universe_list")));
		driver.findElement(By.xpath(xpathCategorie)).click();
		
	}

	@Override
	public void consulterSousCategorie(String sousCategorie) {
		AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
		String xpathSousCategorie = "//android.widget.TextView[@text='"+sousCategorie+"']";
		Scroll.scrollDownUntilElementIsVisible(driver, xpathSousCategorie, (MobileElement)driver.findElement(By.id("catalog_rayon_list")));
		driver.findElement(By.xpath(xpathSousCategorie)).click();
	}
	
    public void clickAchatExpress(){
    	getDriver().findElement(By.id("express_buying_title")).click();
    }
    
    public void clickListesCourses(){
    	getDriver().findElement(By.id("sub_menu_list")).click();
    }
}
