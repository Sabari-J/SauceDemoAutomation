package stepdefinitions;

import java.util.List;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartSteps {
	
	SoftAssert softAssert = new SoftAssert();
    CartPage cartPage = new CartPage();

	@When("the user add the product by clicking on add to cart button:")
	public void add_the_product_by_clicking_on_add_to_cart_button(List<String> productNames) {
		for (String productName : productNames) {
            cartPage.addProductToCart(productName);
            System.out.println("Sucessfully Added");
        }

	}

	@When("the product count {string} should appear in the shopping cart container")
	public void the_product_count_should_appear_in_the_shopping_cart_container(String expectedCount) {
		String actualCount = cartPage.getCartItemCount();
		softAssert.assertEquals(actualCount, expectedCount, "Cart count mismatch!");
		System.out.println("Sucessfully validated");
	}
	
	@After
	public void assertAllAfterScenario() {
		softAssert.assertAll();
	}

}
