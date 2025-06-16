package stepdefinitions;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class ProductSortingSteps {
	
	HomePage homepage = new HomePage();
	SoftAssert softAssert = new SoftAssert();

	@When("User selects {string} from the sorting dropdown")
	public void user_selects_from_the_sorting_dropdown(String sortingOption) {
		homepage.selectSortingOption(sortingOption);
	}

	@Then("User should see products sorted in ascending price order")
	public void user_should_see_products_sorted_in_ascending_price_order() {
		homepage.verifyPricesAreSortedAscending();
	}
	
	@After
	public void assertAllAfterScenario() {
		softAssert.assertAll();
	}
}
