package tests;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SignupPage;

public class SignupTest extends TestBase {
	
	SignupPage signupPage;
	
	
	@Test(priority=1)
	public void testSignupWithNewEmail() {
		String name = "Test User";
		String email = "test_" + UUID.randomUUID().toString().substring(0,5) + "@mail.com";
		signupPage = new SignupPage(driver);
		signupPage.clickSignupLink();
		signupPage.enterSignupInfo(name, email);
		Assert.assertTrue(signupPage.isSignupMessageDisplayed(), "Signup failed or signup message not displayed");
		
	}
	
	@Test(priority=2, dataProvider="invalidData")
	public void testSignupWithExistingEmail(String name, String email) {
		signupPage = new SignupPage(driver);
		signupPage.clickSignupLink();
		signupPage.enterSignupInfo(name, email);
		String emailExistsMsg = signupPage.getEmailExistsMsg();
		Assert.assertTrue(emailExistsMsg.contains("Email Address already exist!"), "Expected error message for existing email was not displayed.");
	
	}
	
	@DataProvider(name="invalidData")
	Object[][]invaidData (){
		return new Object[][] {
			{"Test User", "test123@gmail.com"},
			
		};
	}


}
