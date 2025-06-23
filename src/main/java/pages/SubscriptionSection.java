package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionSection {
	
	WebDriver driver;
	
	public SubscriptionSection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
