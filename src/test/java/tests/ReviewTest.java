package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ReviewSection;

public class ReviewTest extends TestBase {
	
	ReviewSection reviewSection;
	CartPage cartPage;
	
	@Test
	public void testReviewSuccess() {
		reviewSection = new ReviewSection(driver);
		cartPage = new CartPage(driver);
		driver.get("https://automationexercise.com/");
		cartPage.viewProductInfo();
		reviewSection.writeProductReview("Test Name", "test123@gmail.com", "Such a great product!");
		Assert.assertTrue(reviewSection.isSuccessMsgDisplayed());
		Assert.assertTrue(reviewSection.getReviewSuccessMsgText().contains("Thank you for your review."));
	}

}
