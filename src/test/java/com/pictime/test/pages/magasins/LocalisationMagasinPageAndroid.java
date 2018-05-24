package com.pictime.test.pages.magasins;

import com.pictime.test.pages.utils.Contexte;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LocalisationMagasinPageAndroid extends LocalisationMagasinPage{

    @Override
    public void searchStoreByCityName() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        waitABit(3000);
        Contexte.switchToWebview(driver);
        WebDriverWait wait = new WebDriverWait(driver,300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page\"]/div[8]/div[1]/div[2]/div/input")));
        driver.findElement(By.xpath("//*[@id=\"page\"]/div[8]/div[1]/div[2]/div/input")).click();
        driver.getKeyboard().sendKeys("Lille France");
        driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    @Override
    public void getMagasinsByCity() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade)getDriver()).getProxiedDriver();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"displayList\"]")));
        driver.findElements(By.xpath("//*[@id=\"displayList\"]"));
        List<WebElement> listeMagasins = driver.findElements(By.xpath("//*[@id=\"swordSearchResults\"]/div"));
    }
}
