package pageObject;

import org.openqa.selenium.WebDriver;

import pageUls.LoginPageUl;

public class LoginPageObject extends ContainerFluidPageObject {
	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	public void sendKeyToTextBoxSeleniumDropdown(String params, String value) {
		sendKeyToElement(driver, LoginPageUl.EMAIL_TEXTBOX, value, params);
	}

	public void clickToLogin() {
		clickToElement(driver, LoginPageUl.SIGN_IN_BUTTON);
	}

	public String getTextOfMessageLoginSuccess() {
		return getTextOfElement(driver, LoginPageUl.MESSAGE_TEXT);

	}
}
