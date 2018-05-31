package com.pictime.test.pages.commande;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ahassounin
 */
public class CommandPageIOS extends CommandPage {
    @Override
    public void goToCommand() {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gototunnel\"]")));
        driver.findElement(By.xpath("//*[@id=\"gototunnel\"]")).click();
    }

    @Override
    public void commandWithoutLogin() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"continueWithoutLogin\"]")));
        getDriver().findElement(By.xpath("//*[@id=\"continueWithoutLogin\"]")).click();
    }

    @Override
    public void fillContactInformation(String fName, String lName, String email, String tel) {

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));

        WebElement firstName = getDriver().findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(fName);

        WebElement lastName = getDriver().findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys(lName);

        WebElement emailMap = getDriver().findElement(By.xpath("//*[contains(@id,'emailMap')]"));
        emailMap.click();
        emailMap.clear();
        emailMap.sendKeys(email);

        WebElement mobilePhoneNumber = getDriver().findElement(By.xpath("//*[@id=\"mobilePhoneNumber\"]"));
        mobilePhoneNumber.click();
        mobilePhoneNumber.clear();
        mobilePhoneNumber.sendKeys(tel);
    }

    @Override
    public void validateContactInformation() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"informationsValidate\"]")));
        WebElement dontWantFidCard = getDriver().findElement(By.xpath("//*[@id=\"informationsValidate\"]"));
        dontWantFidCard.click();
    }

    @Override
    public void commandWithoutFidelity() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dontWantFidCard\"]")));
        WebElement informationsValidate = getDriver().findElement(By.xpath("//*[@id=\"dontWantFidCard\"]"));
        informationsValidate.click();
    }

    @Override
    public void validateFidelity() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"benefitsValidate\"]")));
        WebElement benefitsValidate = getDriver().findElement(By.xpath("//*[@id=\"benefitsValidate\"]"));
        benefitsValidate.click();
    }

    @Override
    public void checkCommandConfirmation() {

    }

    @Override
    public void checkEresaConfirmed() {

    }
}
