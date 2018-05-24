package com.pictime.test.pages.compte.accoutCreation;

import com.pictime.test.pages.utils.Contexte;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

public class AccountCreationPageIOS extends AccountCreationPage {
    @Override
    public void createAccount() {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"ME CONNECTER\"]")).click();
        waitABit(1000);
        driver.findElement(By.id("Je crée un compte")).click();
    }

    @Override
    public void fillAccountInformation(String prenom, String nom, String email, String password, String code) {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
//
        Contexte.switchToWebview(driver,"create");

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"title\"]")));

        WebElement civilite = driver.findElement(By.xpath("//*[@id=\"title\"]"));
        civilite.click();
        WebElement choice = driver.findElement(By.xpath("//*[@id=\"title\"]/option[2]"));
        choice.click();

        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(prenom);

        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastName.clear();
        lastName.sendKeys(nom);

        WebElement emailAdr = driver.findElement(By.xpath("//*[contains(@id,'emailMap')]"));
        emailAdr.clear();
        emailAdr.sendKeys(generateMailAdr());

        WebElement passwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwd.clear();
        passwd.sendKeys(password);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", passwd);

        driver.findElement(By.xpath("//*[@id=\"birthDay\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthDay\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthMonth\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthMonth\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthYear\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"birthYear\"]/option[26]")).click();



        WebElement captcha = driver.findElement(By.xpath("//*[@id=\"captchaAccountCreation\"]"));
        captcha.click();
        captcha.sendKeys(code);

//        WebElement ww = driver.findElement(By.xpath("//*[@id=\"birthDay\"]"));
//        jse.executeScript("arguments[0].scrollIntoView()", ww);

//        driver.findElement(By.xpath("//*[@id=\"formCreateAccount\"]/div[13]/a")).click();
//
//        WebElement validateBtn = driver.findElement(By.xpath("//*[@id=\"formCreateAccount\"]/div[13]/a"));
//
//        try {
//            safeJavaScriptClick(validateBtn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void validateAccountCreation() {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        Contexte.switchToWebview(driver,"create");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement w = driver.findElement(By.xpath("//*[@id=\"birthDay\"]"));
        jse.executeScript("arguments[0].scrollIntoView()", w);

//        driver.findElement(By.xpath("//*[@id=\"formCreateAccount\"]/div[13]/a")).click();
//        WebElement zz = driver.findElement(By.xpath("//*[@id=\"formCreateAccount\"]/div[13]/a"));
//        zz.click();
        WebElement validateBtn = driver.findElement(By.xpath("//*[@id=\"formCreateAccount\"]/div[14]/a"));
        validateBtn.click();
//        try {
//            safeJavaScriptClick(validateBtn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//
//        jse.executeScript("arguments[0].scrollIntoView()", w);

        //WebElement validateBtn = driver.findElement(By.xpath("//*[@id=\"formCreateAccount\"]/div[13]/a"));
        //validateBtn.click();
        waitABit(5000);

    }

    @Override
    public void assertCreationAccountOK() {
        waitABit(5000);
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement w = driver.findElement(By.xpath("//*[@id=\"birthDay\"]"));
        jse.executeScript("arguments[0].scrollIntoView()", w);
        waitABit(5000);
        Contexte.switchToNative(driver);
        WebElement we = driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Votre compte est créé')]"));
        assertNotEquals(we, null );
    }

    @Override
    public String generateMailAdr() {
        return "selenium" + String.valueOf(System.currentTimeMillis() / 1000) + "@yopmail.com";
    }



    public void safeJavaScriptClick(WebElement element) throws Exception {
        IOSDriver driver = (IOSDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");

                driver.executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "+ e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM "+ e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element "+ e.getStackTrace());
        }
    }
}
