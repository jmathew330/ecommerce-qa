package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage loginPage;
	
	@Test(priority=1)
	public void testValidLogin() {
		loginPage = new LoginPage(driver);
		loginPage.clickLoginLink();
		loginPage.login("jmathew330@gmail.com", "Eakonil98!");
		String loginMsg = loginPage.getLoginMsg();
		Assert.assertTrue(loginMsg.contains("Logged in as"), "Expected login message not found. Actual: " + loginMsg);
	}
	
	
	@Test(priority=2)
	public void testInvalidLogin() {
		loginPage = new LoginPage(driver);
		loginPage.clickLoginLink();
		loginPage.login("invalidemail123@test.com", "wrongpassword");
		String errorMsg = loginPage.getErrorMessage();
		Assert.assertTrue(errorMsg.contains("Your email or password is incorrect!"), "Expected error message not found. Actual: " + errorMsg);
	}
	
	@Test(priority=3)
	public void testLogout() {
		loginPage = new LoginPage(driver);
		loginPage.clickLoginLink();
		loginPage.login("jmathew330@gmail.com", "Eakonil98!");
		loginPage.clickLogout();
		Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Logout failed or user not redirected to login page ");
	}


}
