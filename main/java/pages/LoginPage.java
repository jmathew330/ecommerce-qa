package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") WebElement loginLink;
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement emailInput;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement passwordInput;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement loginBtn;
	@FindBy(xpath="//p[contains(text(),'incorrect')]") WebElement errorMsg;
	@FindBy(xpath="//a[contains(text(),'Logged in as')]") WebElement loginMsgEl;
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logoutBtn;

	
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
	
	public void login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLogin();
	}

	
	public String getErrorMessage() {
		return errorMsg.getText();
	}
	
	public String getLoginMsg() {
		return loginMsgEl.getText();
	}
	
	public boolean isLoginPageDisplayed() {
	    return driver.getCurrentUrl().contains("login");
	}
	
}

