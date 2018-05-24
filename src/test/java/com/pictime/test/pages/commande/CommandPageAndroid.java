package com.pictime.test.pages.commande;

import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class CommandPageAndroid extends CommandPage {

    @Override
    public void goToCommand() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        System.out.println("url got to command=> " + driver.getCurrentUrl());
        waitABit(2000);
        withTimeoutOf(40, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gototunnel\"]")));
        driver.findElement(By.xpath("//*[@id=\"gototunnel\"]")).click();
    }

    @Override
    public void commandWithoutLogin() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        System.out.println("url => " + driver.getContext());
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"continueWithoutLogin\"]")));
        driver.findElement(By.xpath("//*[@id=\"continueWithoutLogin\"]")).click();
    }

    @Override
    public void fillContactInformation(String fName, String lName, String email, String tel) {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        System.out.println("url info => " + driver.getCurrentUrl());
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(fName);

        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys(lName);

        WebElement emailMap = driver.findElement(By.xpath("//*[contains(@id,'emailMap')]"));
        emailMap.click();
        emailMap.clear();
        emailMap.sendKeys(email);

        WebElement mobilePhoneNumber = driver.findElement(By.xpath("//*[@id=\"mobilePhoneNumber\"]"));
        mobilePhoneNumber.click();
        mobilePhoneNumber.clear();
        mobilePhoneNumber.sendKeys(tel);
    }

    @Override
    public void validateContactInformation() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"informationsValidate\"]")));
        WebElement dontWantFidCard = driver.findElement(By.xpath("//*[@id=\"informationsValidate\"]"));
        dontWantFidCard.click();
    }

    @Override
    public void commandWithoutFidelity() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dontWantFidCard\"]")));
        WebElement informationsValidate = driver.findElement(By.xpath("//*[@id=\"dontWantFidCard\"]"));
        informationsValidate.click();
    }

    @Override
    public void validateFidelity() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"benefitsValidate\"]")));
        WebElement benefitsValidate = driver.findElement(By.xpath("//*[@id=\"benefitsValidate\"]"));
        benefitsValidate.click();
    }

    @Override
    public void checkCommandConfirmation() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        waitABit(10000);
        System.out.println("---------------->" + driver.getCurrentUrl());
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"stepSummary\"]")));
    }

    @Override
    public void checkEresaConfirmed() {
        waitABit(10000);
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"stepSummary\"]")));
    }
}
