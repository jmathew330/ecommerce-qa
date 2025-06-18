package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;

public class LoginTest {
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
	};
	
	@Test(priority=1)
	public void validLoginTest() {
		driver.get("https://automationexercise.com/login");
		loginPage.login("jmathew330@gmail.com", "Eakonil98!");
		String loginMsg = loginPage.getLoginMsg();
		Assert.assertTrue(loginMsg.contains("Logged in as"), "Expected login message not found. Actual: " + loginMsg);
	}
	
	
	@Test(priority=2)
	public void invalidLoginTest() {
		driver.get("https://automationexercise.com/login");
		loginPage.login("invalidemail123@test.com", "wrongpassword");
		String errorMsg = loginPage.getErrorMessage();
		Assert.assertTrue(errorMsg.contains("Your email or password is incorrect!"), "Expected error message not found. Actual: " + errorMsg);
	}
	
	@Test(priority=3)
	public void logoutTest() {
		driver.get("https://automationexercise.com/login");
		loginPage.login("jmathew330@gmail.com", "Eakonil98!");
		loginPage.clickLogout();
		Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Logout failed or user not redirected to login page ");
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
