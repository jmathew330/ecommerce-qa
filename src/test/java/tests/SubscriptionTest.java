package tests;

import org.testng.annotations.Test;

import pages.SubscriptionSection;

public class SubscriptionTest extends TestBase {

	SubscriptionSection subscriptionSection;

	@Test
	public void testSubscriptionSuccess() {
		driver.get("https://automationexercise.com/");
		subscriptionSection = new SubscriptionSection(driver);
		subscriptionSection.subscribeToNewsletter("test123@gmail.com");
		subscriptionSection.isSuccessMsgDisplayed();
	}

}
