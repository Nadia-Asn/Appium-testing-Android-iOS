package com.pictime.test.pages.navigation.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by zeggaim on 20/05/2016.
 */
public class SidebarPageIOS extends SidebarPage {

	@Override
	public void consulterUnivers(String univers) {
		withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.presenceOfElementLocated(By.id(univers)));
		getDriver().findElement(By.id(univers)).click();
	}

	@Override
	public void consulterCategorie(String categorie) {
		withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.presenceOfElementLocated(By.id(categorie)));
		getDriver().findElement(By.id(categorie)).click();
	}

	@Override
	public void consulterSousCategorie(String sousCategorie) {
		withTimeoutOf(20, TimeUnit.SECONDS).waitFor(ExpectedConditions.presenceOfElementLocated(By.id(sousCategorie)));
		getDriver().findElement(By.id(sousCategorie)).click();
	}
	
	@Override
	public void clickAchatExpress() {
		getDriver().findElement(By.id("Achat Express")).click();
	}

	@Override
	public void clickListesCourses() {
		getDriver().findElement(By.id("Mes listes de courses")).click();
	}
}
