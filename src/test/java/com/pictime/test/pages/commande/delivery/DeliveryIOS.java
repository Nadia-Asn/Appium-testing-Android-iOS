package com.pictime.test.pages.commande.delivery;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ahassounin
 */
public class DeliveryIOS extends Delivery {
    @Override
    public void deliveryTypeHome() {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"radio_domicile\"]")));
        driver.findElement(By.xpath("//*[@id=\"radio_domicile\"]")).click();
        waitABit(5000);
    }

    @Override
    public void fillDeliveryAddress(String street, String pc, String city) {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addressLine1\"]")));

        WebElement streetName = getDriver().findElement(By.xpath("//*[@id=\"addressLine1\"]"));
        streetName.click();
        streetName.clear();
        streetName.sendKeys(street);


        WebElement postalCode = getDriver().findElement(By.xpath("//*[@id=\"cp\"]"));
        postalCode.click();
        postalCode.clear();
        postalCode.sendKeys(pc);

        WebElement cityName = getDriver().findElement(By.xpath("//*[@id=\"ville\"]"));
        cityName.click();
        cityName.clear();
        cityName.sendKeys(city);

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cpSuggest\"]")));
        jse.executeScript("document.getElementById('cpSuggest').setAttribute('style', 'display: none;')");
    }

    @Override
    public void validateDeliveryAddress() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shippingValidate\"]")));
        WebElement streetName = getDriver().findElement(By.xpath("//*[@id=\"shippingValidate\"]"));
        streetName.click();
    }

    @Override
    public void deliveryTypeKiabiStore() {
        waitABit(2000);
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"radio_magasin\"]")));
        WebElement kiabiStore = getDriver().findElement(By.xpath("//*[@id=\"radio_magasin\"]"));
        kiabiStore.click();
    }

    @Override
    public void localiseKiabiStore() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchShop\"]/div[4]/div/a")));
        WebElement geolocalisationBtn = getDriver().findElement(By.xpath("//*[@id=\"searchShop\"]/div[4]/div/a"));
        geolocalisationBtn.click();
        waitABit(2000);
        getDriver().switchTo().alert().accept();
        waitABit(2000);
        getDriver().switchTo().alert().accept();
    }

    @Override
    public void chooseKiabiStore() {
        withTimeoutOf(50, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"popup_magasin_retrait\"]/div/div/div[2]/div/div[4]/div")));
        WebElement geolocalisationBtn = getDriver().findElement(By.xpath("//*[@id=\"popup_magasin_retrait\"]/div/div/div[2]/div/div[4]/div"));
        geolocalisationBtn.click();
    }

    @Override
    public void validateKiabiStore() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shippingValidate\"]")));
        WebElement geolocalisationBtn = getDriver().findElement(By.xpath("//*[@id=\"shippingValidate\"]"));
        geolocalisationBtn.click();
    }

    @Override
    public void deliveryTypePickupPoint() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"radio_retrait\"]")));
        WebElement geolocalisationBtn = getDriver().findElement(By.xpath("//*[@id=\"radio_retrait\"]"));
        geolocalisationBtn.click();
    }

    @Override
    public void localisePickupPoint() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchRetrait\"]/div[4]/div/a")));
        WebElement geolocalisationBtn = getDriver().findElement(By.xpath("//*[@id=\"searchRetrait\"]/div[4]/div/a"));
        geolocalisationBtn.click();
        waitABit(2000);
        // Accepter la popup qui va s'afficher
        // ( car l'option acceptation des popup sur iOS ne fonctionne pas dans les capabilities d'appium)
        getDriver().switchTo().alert().accept();
        waitABit(2000);
        getDriver().switchTo().alert().accept();
    }

    @Override
    public void selectPickupPoint() {
        withTimeoutOf(50, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"popup_magasin_retrait\"]/div/div/div[2]/div/div[4]/div")));
        WebElement geolocalisationBtn = getDriver().findElement(By.xpath("//*[@id=\"popup_magasin_retrait\"]/div/div/div[2]/div/div[4]/div"));
        geolocalisationBtn.click();
    }
}