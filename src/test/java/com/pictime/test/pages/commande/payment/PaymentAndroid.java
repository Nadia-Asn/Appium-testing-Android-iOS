package com.pictime.test.pages.commande.payment;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

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
        String xpathTemporaire = "//*[@id=\"pl-pmLayout-column-pmContainer-1234567-28\"]/div[1]";
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pl-card-logos']//span[@class='pl-card-logo pl-visa']")));
        WebElement benefitsValidate = driver.findElement(By.xpath("//div[@class='pl-card-logos']//span[@class='pl-card-logo pl-visa']"));
        benefitsValidate.click();
    }

    @Override
    public void fillBankCardInformation(String numero, String date, String code) {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        System.out.println("contexte paiment => " + driver.getCurrentUrl());
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"pl-pm-cards_8-cardNumber\"]")));

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input")));

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(numero);

        driver.switchTo().defaultContent();
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"pl-pm-cards_8-expirationDate\"]"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys(date);

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"pl-pm-cards_8-cvv\"]")));
        WebElement emailMap = driver.findElement(By.xpath("//*[@id=\"PaylineWidgetIframe\"]/input"));
        emailMap.click();
        emailMap.clear();
        emailMap.sendKeys(code);
        driver.switchTo().defaultContent();
        System.out.println("---------------->" + driver.getCurrentUrl());
    }

    @Override
    public void validatePayment() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        WebElement validate = driver.findElement(By.xpath("//*[@id=\"pl-pm-cards_8-payBtn\"]"));
        System.out.println("---------------->" + driver.getCurrentUrl());
        validate.click();
        waitABit(5000);
    }

    @Override
    public void kiabiStorePayment() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        WebElement validate = driver.findElement(By.xpath("//*[@id=\"eresa\"]"));
        validate.click();
        waitABit(5000);
    }

    @Override
    public void insertCodeCaptcha() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        WebElement validate = driver.findElement(By.xpath("//*[@id=\"kaptchaEresa\"]"));
        validate.click();
        validate.sendKeys("12345");
    }

    @Override
    public void validateEReservation() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        WebElement validate = driver.findElement(By.xpath("//*[@id=\"paymentEresaValidate\"]"));
        validate.click();
        waitABit(5000);
    }
}
