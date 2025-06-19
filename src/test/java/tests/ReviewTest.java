package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ReviewSection;

public class ReviewTest {
	
	WebDriver driver;
	ReviewSection reviewSection;
	CartPage cartPage;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	
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
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
