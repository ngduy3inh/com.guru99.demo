package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}
	public void navigateToUrl(WebDriver driver, String url) {
		driver.navigate().to(url);
	}
	
	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void openUrl(WebDriver driver, String Url) {
		driver.get(Url);
	}

	// get driver.findElement(By.xPath(""));
	public By getXpath(String locator) {
		return By.xpath(locator);
	}

	public By getXpath(String locator, String... params) {
		return By.xpath(String.format(locator, (Object[]) params));

	}

	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(getXpath(locator));
	}

	public WebElement findElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getXpath(locator, params));
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return findElement(driver, locator);
	}

	public WebElement getElement(WebDriver driver, String locator, String... params) {
		return findElement(driver, locator, params);
	}

	// get driver.findElement(By.CSSPath(""));
	public By getCssXpath(String locator) {
		return By.cssSelector(locator);
	}

	public WebElement findCssElement(WebDriver driver, String locator) {
		return driver.findElement(getCssXpath(locator));
	}

	public WebElement getCssElement(WebDriver driver, String locator) {
		return findCssElement(driver, locator);
	}

	// click
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... params) {
		getElement(driver, locator, params).click();
		;
	}

	public void clickToCssElement(WebDriver driver, String locator) {
		findCssElement(driver, locator).click();
	}

	// sendkey
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value, String... params) {
		getElement(driver, locator, params).sendKeys(value);
	}

	// get
	public String getTextOfElement(WebDriver driver, String locator) {
		return findElement(driver, locator).getText();

	}
}
