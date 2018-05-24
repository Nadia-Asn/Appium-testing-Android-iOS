package com.pictime.test.pages.commande.delivery;

import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class DeliveryAndroid extends Delivery {
    @Override
    public void deliveryTypeHome() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"radio_domicile\"]")));
        driver.findElement(By.xpath("//*[@id=\"radio_domicile\"]")).click();
        waitABit(5000);
    }

    @Override
    public void deliveryTypeKiabiStore() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        waitABit(2000);
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"radio_magasin\"]")));
        WebElement kiabiStore = driver.findElement(By.xpath("//*[@id=\"radio_magasin\"]"));
        kiabiStore.click();
    }

    @Override
    public void fillDeliveryAddress(String street, String pc, String city) {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addressLine1\"]")));

        WebElement streetName = driver.findElement(By.xpath("//*[@id=\"addressLine1\"]"));
        streetName.click();
        streetName.clear();
        streetName.sendKeys(street);

        WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"cp\"]"));
        postalCode.click();
        postalCode.clear();
        postalCode.sendKeys(pc);

        WebElement cityName = driver.findElement(By.xpath("//*[@id=\"ville\"]"));
        cityName.click();
        cityName.clear();
        cityName.sendKeys(city);

    }

    @Override
    public void validateDeliveryAddress() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shippingValidate\"]")));
        WebElement streetName = driver.findElement(By.xpath("//*[@id=\"shippingValidate\"]"));
        streetName.click();
    }

    @Override
    public void localiseKiabiStore() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchShop\"]/div[4]/div/a")));
        WebElement geolocalisationBtn = driver.findElement(By.xpath("//*[@id=\"searchShop\"]/div[4]/div/a"));
        geolocalisationBtn.click();
    }

    @Override
    public void chooseKiabiStore() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(50,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"popup_magasin_retrait\"]/div/div/div[2]/div/div[4]/div")));
        WebElement geolocalisationBtn = driver.findElement(By.xpath("//*[@id=\"popup_magasin_retrait\"]/div/div/div[2]/div/div[4]/div"));
        geolocalisationBtn.click();
    }

    @Override
    public void validateKiabiStore() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shippingValidate\"]")));
        WebElement geolocalisationBtn = driver.findElement(By.xpath("//*[@id=\"shippingValidate\"]"));
        geolocalisationBtn.click();
    }

    @Override
    public void deliveryTypePickupPoint() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"radio_retrait\"]")));
        WebElement geolocalisationBtn = driver.findElement(By.xpath("//*[@id=\"radio_retrait\"]"));
        geolocalisationBtn.click();
    }

    @Override
    public void localisePickupPoint() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchRetrait\"]/div[4]/div/a")));
        WebElement geolocalisationBtn = driver.findElement(By.xpath("//*[@id=\"searchRetrait\"]/div[4]/div/a"));
        geolocalisationBtn.click();
    }

    @Override
    public void selectPickupPoint() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(50,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"popup_magasin_retrait\"]/div/div/div[2]/div/div[4]/div")));
        WebElement geolocalisationBtn = driver.findElement(By.xpath("//*[@id=\"popup_magasin_retrait\"]/div/div/div[2]/div/div[4]/div"));
        geolocalisationBtn.click();
    }


}
