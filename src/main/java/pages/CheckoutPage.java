package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends CartPage {

	private By checkoutButton = By.id("checkout");

	public boolean isProductInCart(String productName) {
		return driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).size() > 0;
	}

	public void clickCheckoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
	}

}
