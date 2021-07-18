package com.gmail.qa.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.*;

import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.LoginPage;
import com.gmail.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	@BeforeMethod
	public void Setup() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 0, enabled = true)
	public void readNumberOfEmailTest() {
		System.out.println("Number of emails in Inbox : " + homePage.readNumberOfEmail());
	}

	@Test(priority = 1, enabled = true)
	public void readNameOfEmailSenderTest() {
		System.out.println(
				"Name of the person whose mail is at the top of the Inbox : " + homePage.readNameOfEmailSender());
	}

	@Test(priority = 2, enabled = true)
	public void sendEmailTest() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String emailBody = "Current Timestamp : " + timeStamp;
		homePage.sendEmail(prop.getProperty("to"), prop.getProperty("subject"), emailBody);
		Assert.assertTrue(homePage.verifyIsMessageSent(), "Message is not sent");
	}

	@AfterMethod
	public void tearDown() {
		homePage.signOut();
		driver.quit();
	}

}
