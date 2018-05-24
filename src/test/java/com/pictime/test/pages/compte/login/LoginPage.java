package com.pictime.test.pages.compte.login;

import net.serenitybdd.core.pages.PageObject;


/**
 * Created by ahassounin
 */
public abstract class LoginPage extends PageObject{

	/**
	 * Saisie du login et mdp et valide le formulaire
	 * 
	 * @param userName
	 * @param password
	 */
    public abstract void login(String userName, String password);

	public abstract void validateLogin();

	public abstract void checkConnectionSuccess();

}
