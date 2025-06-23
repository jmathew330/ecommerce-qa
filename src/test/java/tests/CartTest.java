package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;

public class CartTest {
	
	WebDriver driver;
	CartPage cartPage;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	
	@Test
	public void testAddProductsToCartAsGuest() throws InterruptedException {
		driver.get("https://automationexercise.com/");
		cartPage = new CartPage(driver);
		cartPage.addProductToCartAsGuest();
		Assert.assertTrue(cartPage.isProductAddedToCart("Blue Top"), "Product not found in cart");
	}
	
	@Test
	public void testRemoveProductsFromCartAsGuest() {
		driver.get("https://automationexercise.com/");
		cartPage = new CartPage(driver);
		cartPage.removeProductFromCartAsGuest();
		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty after removing product");
	}
	@Test
	public void testUpdateProductQuantity() {
		driver.get("https://automationexercise.com/");
		cartPage = new CartPage(driver);
		cartPage.viewProductInfo();
		cartPage.setQuantity(4);
		double unitPrice = cartPage.getUnitPrice();
		int quantity = cartPage.getQuantity();
		double expectedTotal = unitPrice *  quantity;
		double actualTotal = cartPage.getTotalPrice();
		Assert.assertEquals(actualTotal, expectedTotal, "Total price does not match expected price");
	}
	
	@Test
	public void testCheckoutMessageGuestUser() {
		driver.get("https://automationexercise.com/");
		cartPage = new CartPage(driver);
		cartPage.addProductToCartAsGuest();
		Assert.assertTrue(cartPage.isGuestCheckoutMessageDisplayed(), "Register / Login account to proceed on checkout.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
