package com.pictime.test.pages.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class WebViewManage {
	public static float[] getElementCenter(AndroidDriver<WebElement> driver, WebElement element){
		  Contexte.switchToWebview(driver, "robe");
		  JavascriptExecutor js = (JavascriptExecutor)driver;

		// get webview dimensions
		  Long webviewWidth = (Long) js.executeScript("return screen.width");
		  Long webviewHeight = (Long)  js.executeScript("return screen.height");

		// get element location in webview
		  int elementLocationX = element.getLocation().getX();
		  int elementLocationY = element.getLocation().getY();

		// get the center location of the element
		  int elementWidthCenter = element.getSize().getWidth() / 2;
		  int elementHeightCenter = element.getSize().getHeight() / 2;
		  int elementWidthCenterLocation = elementWidthCenter + elementLocationX;
		  int elementHeightCenterLocation = elementHeightCenter + elementLocationY;
		// switch to native context
		  driver.context("NATIVE_APP");
		  float deviceScreenWidth, deviceScreenHeight;

		// offset
		  int offset = 115;

		// get the actual screen dimensions
		  deviceScreenWidth = driver.manage().window().getSize().getWidth();
		  deviceScreenHeight = driver.manage().window().getSize().getHeight();

		// calculate the ratio between actual screen dimensions and webview dimensions
		  float ratioWidth = deviceScreenWidth / webviewWidth.intValue();
		  float ratioHeight = deviceScreenHeight / webviewHeight.intValue();

		// calculate the actual element location on the screen
		  float elementCenterActualX = elementWidthCenterLocation * ratioWidth;
		  float elementCenterActualY = (elementHeightCenterLocation * ratioHeight) + offset;
		  float[] elementLocation = {elementCenterActualX, elementCenterActualY};
		// switch back to webview context
		  Contexte.switchToWebview(driver, "robe");
		  return elementLocation;
		}
	
	public static void tapOnElement(AndroidDriver<WebElement> driver, WebElement element){
		  float[] elementLocation = getElementCenter(driver, element);
		  int elementCoordinateX, elementCoordinateY; 
		  elementCoordinateX = (int) Math.round(elementLocation[0]);
		  elementCoordinateY = (int) Math.round(elementLocation[1]);
		  driver.context("NATIVE_APP");
		  TouchAction action = new TouchAction(driver);
		  action.tap(elementCoordinateX, elementCoordinateX).perform();
		  Contexte.switchToWebview(driver, "robe");
	}
}
