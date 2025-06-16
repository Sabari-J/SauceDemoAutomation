package pages;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class LoginPage extends BaseClass {

	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By loginErrorMessage = By.xpath("//h3[@data-test='error']");

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public String getLoginErrorMessage() {
		return driver.findElement(loginErrorMessage).getText();
	}
	
}
