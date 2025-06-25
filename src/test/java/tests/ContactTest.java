package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactPage;

public class ContactTest extends TestBase {

	ContactPage contactPage;

	@Test(priority=1)
	public void TC_CONTACT_001_testHeadingVisibility() {
		driver.get("https://automationexercise.com/contact_us");
		contactPage = new ContactPage(driver);
		Assert.assertTrue(contactPage.isHeadingDisplayed());
	}
	
	@Test(priority=2)
	public void TC_CONTACT_002_testFormSuccess() {
		driver.get("https://automationexercise.com/contact_us");
		contactPage = new ContactPage(driver);
		contactPage.fillOutForm("Test User", "Test123@gmail.com", "Test Subject", "Test Message");
		Assert.assertTrue(contactPage.isSuccessMsgDisplayed());
		Assert.assertTrue(contactPage.getSuccessMsgText().contains("Success! Your details have been submitted successfully."));
	}

}
