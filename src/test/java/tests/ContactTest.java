package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContactPage;

public class ContactTest {
	
	WebDriver driver;
	ContactPage contactPage;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	
	@Test(priority=1)
	public void testHeadingVisibility() {
		driver.get("https://automationexercise.com/contact_us");
		contactPage = new ContactPage(driver);
		Assert.assertTrue(contactPage.isHeadingDisplayed());
	}
	
	@Test(priority=2)
	public void testFormSuccess() {
		driver.get("https://automationexercise.com/contact_us");
		contactPage = new ContactPage(driver);
		contactPage.fillOutForm("Test User", "Test123@gmail.com", "Test Subject", "Test Message");
		Assert.assertTrue(contactPage.isSuccessMsgDisplayed());
		Assert.assertTrue(contactPage.getSuccessMsgText().contains("Success! Your details have been submitted successfully."));
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
