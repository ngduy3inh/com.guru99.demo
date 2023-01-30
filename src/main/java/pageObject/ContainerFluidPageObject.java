package pageObject;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUls.ContainerFluidUI;

public class ContainerFluidPageObject extends BasePage {
	WebDriver driver;
	
	public ContainerFluidPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToSeleniumDropdown() {
		clickToElement(driver, ContainerFluidUI.SELENIUM_DROPDOWN);
	}
	
	public void clickToHrefOfSeleniumDropdown(String locator) {
		clickToElement(driver, ContainerFluidUI.HREF_OF_SELENIUM_DROPDOWN, locator);
	}
	

}
