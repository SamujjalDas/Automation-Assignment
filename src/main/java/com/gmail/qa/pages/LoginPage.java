package com.gmail.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@type='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	private WebElement nextButton;

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signInButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String em, String pwd) {
		signInButton.click();
		email.sendKeys(em);
		nextButton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		password.sendKeys(pwd);
		nextButton.click();
		return new HomePage();
	}

}
