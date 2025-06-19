package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='cart_description']//a") WebElement cartProduct;
	@FindBy(xpath="//a[@href='/products']") WebElement ProductsLink;
	@FindBy(xpath="//a[contains(text(),'Add to cart')][1]") WebElement addToCartBtn;
	@FindBy(linkText="View Cart") WebElement ViewCartLink;
	@FindBy(xpath="//a[@class='cart_quantity_delete']") WebElement deleteProductBtn;
	@FindBy(xpath="//b[text()='Cart is empty!']") WebElement cartEmptyMsg;
	@FindBy(xpath="//input[@id='quantity']") WebElement quantityInput;
	@FindBy(xpath="//td[@class='cart_quantity']//button") WebElement quantityBtn;
	@FindBy(xpath="//button[normalize-space()='Add to cart']") WebElement addToCartBtn2;
	@FindBy(xpath="//a[contains(text(),'View Product')][1]") WebElement ViewProductLink;
	@FindBy(xpath="//td[@class='cart_price']/p") WebElement unitPrice;
	@FindBy(xpath="//p[@class='cart_total_price']") WebElement quantityPrice;
	@FindBy(xpath="//a[normalize-space()='Proceed To Checkout']") WebElement proceedToCheckoutBtn;
	@FindBy(xpath="//p[@class='text-center'][1]") WebElement guestCheckoutModalMsg;
	
	public void addProductToCartAsGuest() {
		ProductsLink.click();
		addToCartBtn.click();
		ViewCartLink.click();
	}
	
	public void removeProductFromCartAsGuest() {
		ProductsLink.click();
		addToCartBtn.click();
		ViewCartLink.click();
		deleteProductBtn.click();
		
	}

	
	public boolean isProductAddedToCart(String productName) {
		String cartProductText = cartProduct.getText();
		return cartProductText.contains(productName);
	}
	
	public boolean isCartEmpty() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		wait.until(ExpectedConditions.visibilityOf(cartEmptyMsg));
		return cartEmptyMsg.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void viewProductInfo() {
		ProductsLink.click();
		ViewProductLink.click();
	}
	
	public void setQuantity(int quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(String.valueOf(quantity));
		addToCartBtn2.click();
		ViewCartLink.click();
	}

	
	public double getUnitPrice() {
		String unitPriceText = unitPrice.getText();
		return Double.parseDouble(unitPriceText.replace("Rs.", "").trim());
	}
	
	public double getTotalPrice() {
		String totalPriceText = quantityPrice.getText();
		return Double.parseDouble(totalPriceText.replace("Rs.", "").trim());
	}
	
	public int getQuantity() {
		String qty = quantityBtn.getText();
		return Integer.parseInt(qty);
	}
	
	public boolean isGuestCheckoutMessageDisplayed() {
		proceedToCheckoutBtn.click();
		String guestCheckoutModalMsgText = guestCheckoutModalMsg.getText();
		return guestCheckoutModalMsgText.contains("Register / Login account to proceed on checkout.");
	}
	


}
