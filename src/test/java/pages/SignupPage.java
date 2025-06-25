package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {
	
	WebDriver driver;
	
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") WebElement signupLink;
	@FindBy(xpath="//input[@placeholder='Name']") WebElement nameInput;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement emailInput;
	@FindBy(xpath="//button[normalize-space()='Signup']") WebElement signupBtn;
	@FindBy(xpath="//b[contains(text(),'Enter Account Information')]") WebElement accountMsg;
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']") WebElement emailExistsMsg;
	
	public void clickSignupLink() {
		signupLink.click();
	}
	
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