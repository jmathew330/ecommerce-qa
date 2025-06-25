package tests;

import org.testng.annotations.Test;

import pages.SubscriptionSection;

public class SubscriptionTest extends TestBase {

	SubscriptionSection subscriptionSection;

	@Test
	public void TC_SUBSCR_001_testSubscriptionSuccess() {
		driver.get("https://automationexercise.com/");
		subscriptionSection = new SubscriptionSection(driver);
		subscriptionSection.subscribeToNewsletter("test123@gmail.com");
		subscriptionSection.isSuccessMsgDisplayed();
	}

}
