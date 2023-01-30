package com.guru99.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.GlobalContains;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.ContainerFluidPageObject;
import pageObject.LoginPageObject;

public class TS_Login {
	WebDriver driver;
	ContainerFluidPageObject ContainerFluid;
	LoginPageObject loginPage;
 	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/");
		
		ContainerFluid = new ContainerFluidPageObject(driver);
		loginPage = new LoginPageObject(driver);
	}

	@Test
	public void ts_01_LoginWithValid() {
		loginPage.clickToSeleniumDropdown();
		loginPage.clickToHrefOfSeleniumDropdown("Login");
		loginPage.sendKeyToTextBoxSeleniumDropdown("email",GlobalContains.Email);
		loginPage.sendKeyToTextBoxSeleniumDropdown("passwd",GlobalContains.Email);
		loginPage.clickToLogin();
		Assert.assertEquals("Successfully Logged in...", loginPage.getTextOfMessageLoginSuccess());
	}
	
	@Test
	public void ts_02_LoginUsingUrlAndValidInfo() {
		loginPage.navigateToUrl(driver, "https://demo.guru99.com/test/login.html");
		loginPage.refeshCurrentPage(driver);
		loginPage.sendKeyToTextBoxSeleniumDropdown("email",GlobalContains.Email);
		loginPage.sendKeyToTextBoxSeleniumDropdown("passwd",GlobalContains.Email);
		loginPage.clickToLogin();
		Assert.assertEquals("Successfully Logged in...", loginPage.getTextOfMessageLoginSuccess());
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
