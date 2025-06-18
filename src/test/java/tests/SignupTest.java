package tests;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SignupPage;

public class SignupTest {
	
	WebDriver driver;
	SignupPage signupPage;
	
	@BeforeMethod
	public void setup() {
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		signupPage = new SignupPage(driver);
	}
	@Test(priority=1)
	public void signupWithNewEmailTest() {
		
		driver.get("https://automationexercise.com/login");
		
		String name = "Test User";
		
		String email = "test_" + UUID.randomUUID().toString().substring(0,5) + "@mail.com";
		
		signupPage.enterSignupInfo(name, email);
		
		Assert.assertTrue(signupPage.isSignupMessageDisplayed(), "Signup failed or signup message not displayed");
		
	}
	
	@Test(priority=2, dataProvider="invalidData")
	public void signupWithExistingEmailTest(String name, String email) {
		driver.get("https://automationexercise.com/login");
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
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
