package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscriptionSection extends BasePage {
	
	WebDriver driver;
	
	public SubscriptionSection(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='susbscribe_email']") WebElement emailInput;
	@FindBy(xpath="//button[@id='subscribe']") WebElement subscribeBtn;
	@FindBy(id="success-subscribe") WebElement successMsg;
	
	public void subscribeToNewsletter(String email) {
		emailInput.sendKeys(email);
		subscribeBtn.click();
	}
	
	public boolean isSuccessMsgDisplayed() {
		return successMsg.isDisplayed();
	}
	
	public String getSuccessMsg() {
		String successMsgTxt = successMsg.getText();
		return successMsgTxt;
	}

}