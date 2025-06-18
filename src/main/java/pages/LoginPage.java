package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement emailInput;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement passwordInput;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement loginBtn;
	@FindBy(xpath="//p[contains(text(),'incorrect')]") WebElement errorMsg;
	@FindBy(xpath="//a[contains(text(),'Logged in as')]") WebElement loginMsgEl;
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logoutBtn;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
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

