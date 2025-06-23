package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SubscriptionSection;

public class SubscriptionTest {
	
	WebDriver driver;
	SubscriptionSection subscriptionSection;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test
	public void testSubscriptionSuccess() {
		driver.get("https://automationexercise.com/");
		subscriptionSection = new SubscriptionSection(driver);
		subscriptionSection.subscribeToNewsletter("test123@gmail.com");
		subscriptionSection.isSuccessMsgDisplayed();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
