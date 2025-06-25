package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;

public class CartTest extends TestBase {

	CartPage cartPage;

	@Test
	public void TC_CART_001_testAddProductsToCartAsGuest() throws InterruptedException {
		cartPage = new CartPage(driver);
		cartPage.addProductToCartAsGuest();
		Assert.assertTrue(cartPage.isProductAddedToCart("Blue Top"), "Product not found in cart");
	}
	
	@Test
	public void TC_CART_002_testRemoveProductsFromCartAsGuest() {
		cartPage = new CartPage(driver);
		cartPage.removeProductFromCartAsGuest();
		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty after removing product");
	}
	@Test
	public void TC_CART_003_testUpdateProductQuantity() {
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
	public void TC_CART_004_testCheckoutMessageGuestUser() {
		cartPage = new CartPage(driver);
		cartPage.addProductToCartAsGuest();
		Assert.assertTrue(cartPage.isGuestCheckoutMessageDisplayed(), "Register / Login account to proceed on checkout.");
	}

}
