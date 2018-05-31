package com.pictime.test.pages.commande.payment;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ahassounin
 */
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
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pl-card-logos']//span[@class='pl-card-logo pl-visa']")));
        WebElement benefitsValidate = getDriver().findElement(By.xpath("//div[@class='pl-card-logos']//span[@class='pl-card-logo pl-visa']"));
        benefitsValidate.click();
    }

    @Override
    public void fillBankCardInformation(String numero, String date, String code) {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//*[@id=\"pl-pm-cards_7-cardNumber\"]")));

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input")));

        WebElement firstName = getDriver().findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(numero);

        WebElement lastName = getDriver().findElement(By.xpath("//*[@id=\"pl-pm-cards_7-expirationDate\"]"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys(date);

        WebElement emailMap = getDriver().findElement(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input"));
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
