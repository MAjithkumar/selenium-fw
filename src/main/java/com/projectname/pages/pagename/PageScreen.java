package com.projectname.pages.pagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.projectname.util.Elements.ElementUtil;

public class PageScreen {

	WebDriver driver;
	ElementUtil eu;

	public PageScreen(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}

	By MENU = By.xpath("");

	public void NavigateToMenu() throws InterruptedException {

	}

}