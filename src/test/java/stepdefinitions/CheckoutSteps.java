package stepdefinitions;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.OrderConfirmationPage;

public class CheckoutSteps {

	CartPage cartPage = new CartPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	CheckoutInformationPage infoPage = new CheckoutInformationPage();
	CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
	OrderConfirmationPage confirmationPage = new OrderConfirmationPage();
	SoftAssert softAssert = new SoftAssert();

	@When("User navigates to the cart")
	public void user_navigates_to_the_cart() {
		cartPage.clickCartIcon();
	}

	@Then("The cart should contain the product {string}")
	public void the_cart_should_contain_the_product(String expectedProductName) {
		softAssert.assertTrue(checkoutPage.isProductInCart(expectedProductName),
				"Expected product not found in thecart: " + expectedProductName);
	}

	@When("User proceeds to checkout")
	public void user_proceeds_to_checkout() {
		checkoutPage.clickCheckoutButton();

	}

	@When("User enters checkout information with first name {string}, last name {string}, and postal code {string}")
	public void user_enters_checkout_information_with_first_name_last_name_and_postal_code(String fName, String lName,
			String zipCode) {
		infoPage.enterCustomerDetails(fName, lName, zipCode);

	}

	@When("User clicks on Continue")
	public void user_clicks_on_continue() {
		infoPage.clickContinueButton();
	}

	@Then("The checkout overview should display the product {string}")
	public void the_checkout_overview_should_display_the_product(String expectedProduct) {
		softAssert.assertTrue(overviewPage.isProductDisplayed(expectedProduct),
				"Product not displayed in the checkout overview: " + expectedProduct);
		softAssert.assertAll();
	}

	@When("User clicks on Finish")
	public void user_clicks_on_finish() {
		overviewPage.clickFinishButton();
	}

	@Then("The order confirmation message should be {string}")
	public void the_order_confirmation_message_should_be(String expectedMessage) {
		softAssert.assertEquals(confirmationPage.getOrderConfirmationMessage(), expectedMessage,
				"Discrepancy in the order confirmation message");
	}

	@After
	public void assertAllAfterScenario() {
		softAssert.assertAll();
	}

}
