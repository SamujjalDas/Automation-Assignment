package com.gmail.qa.testcases;

import org.testng.annotations.*;

import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 0)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
