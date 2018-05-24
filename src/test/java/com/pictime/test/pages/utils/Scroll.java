package com.pictime.test.pages.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 
 * @author elalailii
 *
 */

public class Scroll {
	private static final int MAXSCROLL = 10;
	
	/**
	 * Scroll (maximum {@value #MAXSCROLL} scrolls) sur un element donné jusqu'à ce que le xpath qu'on cherche soit visible
	 * 
	 * @param driver
	 * @param xpathAChercher : xpath de l'element que l'on souhaite visualiser
	 * @param elementAScroller : element sur lequel l'action de scroll doit se faire
	 */
	public static void scrollDownUntilElementIsVisible(AppiumDriver driver, String xpathAChercher, MobileElement elementAScroller){
		int nbSroll = 0;
		boolean trouve = false;
		
		Point topLeftCorner = elementAScroller.getLocation();
		Dimension size = elementAScroller.getSize();
		
		int startY = topLeftCorner.getY() + (size.height-size.height/4);
		int endY = topLeftCorner.getY() + size.height/4;
		int startX = topLeftCorner.getX() + size.width/2;
		
		while (!trouve && nbSroll<MAXSCROLL) {
			try{
				driver.findElement(By.xpath(xpathAChercher));
				trouve = true;
			}
			catch(Exception e){
				//driver.swipe(startX, startY, startX, endY, 1000);
			}
			nbSroll++;
		}
		
	}
}
