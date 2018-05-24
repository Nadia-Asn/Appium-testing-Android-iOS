package com.pictime.test.pages.magasins;

import net.serenitybdd.core.pages.PageObject;

public abstract class LocalisationMagasinPage  extends PageObject{
    public abstract void searchStoreByCityName();

    public abstract void getMagasinsByCity();
}
