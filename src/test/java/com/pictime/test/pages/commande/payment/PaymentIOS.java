package com.pictime.test.pages.commande.payment;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class PaymentIOS extends Payment {
    @Override
    public void commandOnLinePayment() {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payline\"]")));
        WebElement benefitsValidate = driver.findElement(By.xpath("//*[@id=\"payline\"]"));
        benefitsValidate.click();
    }

    @Override
    public void commandBankCardPayment() {
        String xpathTemporaire = "//*[@id=\"pl-pmLayout-column-pmContainer-1234567-28\"]/div[1]";
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pl-card-logos']//span[@class='pl-card-logo pl-visa']")));
        WebElement benefitsValidate = driver.findElement(By.xpath("//div[@class='pl-card-logos']//span[@class='pl-card-logo pl-visa']"));
        benefitsValidate.click();
    }

    @Override
    public void fillBankCardInformation(String numero, String date, String code) {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"pl-pm-cards_7-cardNumber\"]")));

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input")));

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(numero);

        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"pl-pm-cards_7-expirationDate\"]"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys(date);

        WebElement emailMap = driver.findElement(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input"));
        emailMap.click();
        emailMap.clear();
        emailMap.sendKeys(code);



    }

    @Override
    public void validatePayment() {

    }

    @Override
    public void kiabiStorePayment() {

    }

    @Override
    public void insertCodeCaptcha() {

    }

    @Override
    public void validateEReservation() {

    }
}
