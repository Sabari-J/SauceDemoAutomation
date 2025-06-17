package stepdefinitions;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class ProductImageValidationSteps {

	HomePage homepage = new HomePage();
	SoftAssert softAssert = new SoftAssert();

	@Then("User should see all product images loaded successfully")
	public void verify_all_images_loaded() {
		homepage.verifyImagesLoadSuccessfully();
	}


	@After
	public void assertAllAfterScenario() {
		softAssert.assertAll();
	}

}
