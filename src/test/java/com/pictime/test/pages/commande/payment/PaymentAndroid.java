package com.pictime.test.pages.commande.payment;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ahassounin
 */
public class PaymentAndroid extends Payment {
    @Override
    public void commandOnLinePayment() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
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
        System.out.println("url paiment => " + getDriver().getCurrentUrl());
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//*[@id=\"pl-pm-cards_8-cardNumber\"]")));

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input")));

        WebElement firstName = getDriver().findElement(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(numero);

        getDriver().switchTo().defaultContent();
        WebElement lastName = getDriver().findElement(By.xpath("//*[@id=\"pl-pm-cards_8-expirationDate\"]"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys(date);

        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//*[@id=\"pl-pm-cards_8-cvv\"]")));
        WebElement emailMap = getDriver().findElement(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input"));
        emailMap.click();
        emailMap.clear();
        emailMap.sendKeys(code);
        getDriver().switchTo().defaultContent();
        System.out.println("---------------->" + getDriver().getCurrentUrl());
    }

    @Override
    public void validatePayment() {
        WebElement validate = getDriver().findElement(By.xpath("//*[@id=\"pl-pm-cards_8-payBtn\"]"));
        validate.click();
        waitABit(5000);
    }

    @Override
    public void kiabiStorePayment() {
        WebElement validate = getDriver().findElement(By.xpath("//*[@id=\"eresa\"]"));
        validate.click();
        waitABit(5000);
    }

    @Override
    public void insertCodeCaptcha() {
        WebElement validate = getDriver().findElement(By.xpath("//*[@id=\"kaptchaEresa\"]"));
        validate.click();
        validate.sendKeys("12345");
    }

    @Override
    public void validateEReservation() {
        WebElement validate = getDriver().findElement(By.xpath("//*[@id=\"paymentEresaValidate\"]"));
        validate.click();
        waitABit(5000);
    }
}
