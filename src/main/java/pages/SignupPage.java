package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	WebDriver driver;
	
	
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Name']") WebElement nameInput;
	
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement emailInput;
	
	@FindBy(xpath="//button[normalize-space()='Signup']") WebElement signupBtn;
	
	@FindBy(xpath="//b[contains(text(),'Enter Account Information')]") WebElement accountMsg;
	
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']") WebElement emailExistsMsg;
	
	public void enterSignupInfo(String name, String email) {
		
		nameInput.sendKeys(name);
		emailInput.sendKeys(email);
		signupBtn.click();
	}
	
	public boolean isSignupMessageDisplayed() {
		return accountMsg.isDisplayed();
	}
	
	public String getEmailExistsMsg() {
		return emailExistsMsg.getText();
	}
	
	
}
