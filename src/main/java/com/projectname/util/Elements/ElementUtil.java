package com.projectname.util.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.projectname.basepage.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	WebElement element;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 45);
	}

	public WebElement getElement(By locator) {
		waitForElementPresent(locator);
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception got occurred while creating the webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void visibilityOfElementWait(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			throw new NoSuchElementException(locator.toString());
		}
	}

	public void inVisibilityOfElementWait(By locator) {

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			throw new NoSuchElementException(locator.toString());
		}
	}

	public void jseScrollIntoView(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void jseClick(WebElement element) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	public void click(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}

	public void sendKeys(By locator, String... value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while sending the text to the webelement : " + locator);
			System.out.println(e.getMessage());

		}
	}

	public String getText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the test from webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return text;
	}

	public void ActionsClick(By locator) {
		try {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}

	public void actionsSendKeys(By locator, String... value) {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while passing the values to the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}

	public boolean IsDisplayed(By locator) {

		boolean flag = false;
		try {
			flag = getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out
					.println("some exception got occurred while checking isDisplayed for the webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public String getTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the title of the page");
			System.out.println(e.getMessage());
		}
		return title;
	}

	public void actionsMoveToElement(By locator) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while moving on the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}

	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void SLEEP_500MS() throws InterruptedException {
		Thread.sleep(500);
	}

	public void SLEEP_1S() throws InterruptedException {
		Thread.sleep(1000);
	}

	public void SLEEP_2S() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void SLEEP_3S() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void SLEEP_4S() throws InterruptedException {
		Thread.sleep(4000);
	}

	public void SLEEP_5S() throws InterruptedException {
		Thread.sleep(5000);
	}

	public void SLEEP_6S() throws InterruptedException {
		Thread.sleep(6000);
	}

	public void SLEEP_7S() throws InterruptedException {
		Thread.sleep(7000);
	}

	public void SLEEP_8S() throws InterruptedException {
		Thread.sleep(8000);
	}

	public void SLEEP_25S() throws InterruptedException {
		Thread.sleep(25000);
	}
}
