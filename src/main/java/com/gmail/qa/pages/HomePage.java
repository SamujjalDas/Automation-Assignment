package com.gmail.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//a[contains(text(),'Inbox')]//parent::span//following-sibling::div")
	private WebElement inboxCount;

	@FindBy(xpath = "//div[@class='yW']//span[@class='bA4']")
	private WebElement emailSenderName;

	@FindBy(xpath = "//div[contains(text(),'Compose')]")
	private WebElement composeButton;

	@FindBy(xpath = "//input[@class='wA']//following-sibling::textarea")
	private WebElement toEmailAddress;

	@FindBy(xpath = "//input[@name='subjectbox']")
	private WebElement emailSubject;

	@FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
	private WebElement emailBody;

	@FindBy(xpath = "//div[contains(text(),'Send')]")
	private WebElement sendButton;

	@FindBy(xpath = "//span[contains(text(),'Message sent.')]")
	private WebElement messageSent;

	@FindBy(xpath = "//img[@class='gb_Ca gbii']")
	private WebElement accountImage;

	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	private WebElement signOutLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String readNumberOfEmail() {
		return inboxCount.getText();
	}

	public String readNameOfEmailSender() {
		return emailSenderName.getText();
	}

	public void sendEmail(String to, String subject, String body) {
		composeButton.click();
		toEmailAddress.sendKeys(to);
		emailSubject.sendKeys(subject);
		emailBody.sendKeys(body);
		sendButton.click();

	}

	public boolean verifyIsMessageSent() {
		return messageSent.isDisplayed();
	}

	public void signOut() {
		accountImage.click();
		signOutLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
