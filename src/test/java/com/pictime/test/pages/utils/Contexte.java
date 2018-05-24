package com.pictime.test.pages.utils;

import java.util.Set;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author elalailii
 *
 */
public class Contexte {
	/**
	 * iOS uniquement, passe le contexte sur la webview dont l'url contient la chaine de caractère {@code webview}
	 * 
	 * @param driver
	 * @param webview chaine de caractère devant être présente dans l'url
	 */
	public static void switchToWebview(IOSDriver driver, String webview) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    Set<String> availableContexts = driver.getContextHandles();
	    for (String contexte : availableContexts) {
	    	if(contexte.contains("WEBVIEW")){
	    		driver.context(contexte);
				if(driver.getCurrentUrl().contains(webview)) {
					break;
				}
			}
	    }
	}
	
	/**
	 * Android uniquement, passe le contexte sur la webview dont l'url contient la chaine de caractère {@code webview}
	 *  
	 * @param driver
	 * @param webview chaine de caractère devant être présente dans l'url
	 */
	public static void switchToWebview(AndroidDriver driver, String webview) {
		Set<String> availableContexts = driver.getContextHandles();
        switchToWebview(driver);
        Set<String> availableWindows = driver.getWindowHandles();
        for (String window : availableWindows) {
			if(!driver.getCurrentUrl().contains(webview)){
				driver.switchTo().window(window);
			}
		}
	}
	
	/**
	 * Passe le contexte sur la dernière webview ouverte
	 * 
	 * @param driver
	 */
	public static void switchToWebview(AppiumDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> availableContexts = driver.getContextHandles();
		driver.context((String)availableContexts.toArray()[availableContexts.size()-1]);
	}
	
	/**
	 * Passe le contexte sur le contexte Natif
	 * 
	 * @param driver
	 */
	public static void switchToNative(AppiumDriver driver) {
		Set<String> availableContexts = driver.getContextHandles();
		for (String contexte : availableContexts) {
			if(contexte.contains("NATIVE")) {
				driver.context(contexte);
			}
		}
	}

}

