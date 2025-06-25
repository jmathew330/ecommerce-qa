package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	
	public ContactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']") WebElement heading;
	@FindBy(xpath="//input[@placeholder='Name']") WebElement nameField;
	@FindBy(xpath="//input[@placeholder='Email']") WebElement emailField;
	@FindBy(xpath="//input[@placeholder='Subject']") WebElement subjectField;
	@FindBy(xpath="//textarea[@id='message']") WebElement messageField;
	@FindBy(xpath="//input[@name='upload_file']") WebElement uploadBtn;
	@FindBy(xpath="//input[@name='submit']") WebElement submitBtn;
	@FindBy(xpath="//div[@class='status alert alert-success']") WebElement successMsg;
	
	
	
	public boolean isHeadingDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		wait.until(ExpectedConditions.visibilityOf(heading));
		return heading.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void fillOutForm(String name, String email, String subject, String message) {
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		subjectField.sendKeys(subject);
		messageField.sendKeys(message);
		submitBtn.click();
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean isSuccessMsgDisplayed() {
		return successMsg.isDisplayed();
	}
	
	public String getSuccessMsgText() {
		String successMsgText = successMsg.getText();
		return successMsgText;
	}
	

}