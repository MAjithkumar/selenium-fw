package com.projectname.basepage;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.projectname.util.Elements.ElementUtil;

public class LoginPage extends BasePage {
	static String currentUName, currentPassword;
	static boolean relogin = false;
	public static int rowIndex = 2, amendIndex = -1;
	public static int rowIndex1 = 2;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}

//	Locators 
	By LOGIN_USERNAME = By.xpath("");
	By LOGIN_PASSWORD = By.xpath("");
	By LOGIN_SUBMIT = By.xpath("");

	public void Login(String userName, String userPassword) throws IOException, InterruptedException {
		eu.visibilityOfElementWait(LOGIN_USERNAME);
		eu.sendKeys(LOGIN_USERNAME, userName);
		eu.sendKeys(LOGIN_PASSWORD, userPassword);
		eu.SLEEP_2S();
		eu.click(LOGIN_SUBMIT);
	}

}
