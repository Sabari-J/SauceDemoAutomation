package pages;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class CartPage extends BaseClass {

	private By cartCount = By.xpath("//span[@data-test='shopping-cart-badge']");
	private By cartContainer = By.xpath("//span[@data-test='shopping-cart-badge']");

	public String getCartItemCount() {
		return driver.findElement(cartCount).getText();
	}

	public void addProductToCart(String productName) {

		String productXpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
		driver.findElement(By.xpath(productXpath)).click();

	}
	
	public void clickCartIcon() {
        driver.findElement(cartContainer).click();
    }

}
