package stepdefinitions;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseClass;
import utilities.PropertyUtils;

public class LoginSteps extends BaseClass {

	PropertyUtils prop = new PropertyUtils();
	SoftAssert softAssert = new SoftAssert();

	LoginPage loginPage = new LoginPage();
	HomePage homepage = new HomePage();

	@Given("User launches the login page")
	public void user_launches_the_login_page() {

		driver.get(prop.getProperty("url"));
	}

	@Then("User should land on the login page as expected")
	public void user_should_land_on_the_login_page_as_expected() {

		String currentUrl = driver.getCurrentUrl();
		softAssert.assertTrue(currentUrl.contains("saucedemo.com"), "Expected URL to contain 'saucedemo.com', but was: " + currentUrl);
	}

	@When("user should able to enter the valid username and password on the login page")
	public void user_should_able_to_enter_the_username_and_valid_password_on_the_login_page() {
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		loginPage.clickLogin();
	}

	@Then("user should see the homepage of SauceDemo")
	public void user_should_see_the_homepage_of_sauce_demo() {
		softAssert.assertTrue(homepage.getLogoText().equalsIgnoreCase("Swag Labs"));
	}
	
	@When("user enters the invalid username {string} and password {string} on the login page")
	public void user_enters_the_invalid_username_and_password_on_the_login_page(String userName, String password) {
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
	}

	@Then("user should see the error message of SauceDemo")
	public void user_should_see_the_error_message_of_sauce_demo() {
		softAssert.assertTrue(loginPage.getLoginErrorMessage().contains("do not match"));
	}

	@After
	public void assertAllAfterScenario() {
		softAssert.assertAll();
	}

}
