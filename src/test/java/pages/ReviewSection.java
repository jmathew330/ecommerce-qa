package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewSection extends BasePage {
	
	WebDriver driver;
	
	public ReviewSection(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='name']") WebElement nameReviewInput;
	@FindBy(xpath="//input[@id='email']") WebElement emailReviewInput;
	@FindBy(xpath="//textarea[@id='review']") WebElement reviewMsgTextArea;
	@FindBy(xpath="//button[@id='button-review']") WebElement reviewSubmitBtn;
	@FindBy(xpath="//div[@class='alert-success alert']") WebElement reviewSuccessMsg;
	
	public void writeProductReview(String name, String email, String reviewMsg) {
		nameReviewInput.sendKeys(name);
		emailReviewInput.sendKeys(email);
		reviewMsgTextArea.sendKeys(reviewMsg);
		reviewSubmitBtn.click();
	}
	
	public boolean isSuccessMsgDisplayed() {
		return reviewSuccessMsg.isDisplayed();
	}
	
	public String getReviewSuccessMsgText() {
		String reviewSuccessMsgText = reviewSuccessMsg.getText();
		return reviewSuccessMsgText;
	}

}