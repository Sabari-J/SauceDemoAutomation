package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.BaseClass;

public class HomePage extends BaseClass {

	SoftAssert softAssert = new SoftAssert();

	private By logText = By.xpath("//div[@class='app_logo']");
	private By sortDropdown = By.className("product_sort_container");
	private By productPrices = By.className("inventory_item_price");
	private By productImages = By.cssSelector(".inventory_item_img img");

	public String getLogoText() {
		return driver.findElement(logText).getText();
	}

	public void selectSortingOption(String optionText) {
		WebElement dropdown = driver.findElement(sortDropdown);
		new Select(dropdown).selectByVisibleText(optionText);
	}

	public void verifyPricesAreSortedAscending() {
		List<WebElement> priceElements = driver.findElements(productPrices);
		List<Double> actualPrices = new ArrayList<>();

		for (WebElement price : priceElements) {
			actualPrices.add(Double.parseDouble(price.getText().replace("$", "").trim()));
		}

		List<Double> expectedSortedPrices = new ArrayList<>(actualPrices);
		Collections.sort(expectedSortedPrices);

		softAssert.assertEquals(actualPrices, expectedSortedPrices, "Prices are not sorted from low to high!");
		softAssert.assertAll();
	}

	public void verifyImagesLoadSuccessfully() {
		List<WebElement> images = driver.findElements(productImages);
		System.out.println("Total No of Images: "+ images.size());
		
		String baseUrl = driver.getCurrentUrl().split("/inventory")[0];

		for (WebElement img : images) {
			String imgUrl = img.getDomAttribute("src");
			
			if (!imgUrl.startsWith("http")) {
	            imgUrl = baseUrl + imgUrl;
	        }

			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(imgUrl).openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				int statusCode = connection.getResponseCode();

				Assert.assertEquals(statusCode, 200, "Broken image found at URL: " + imgUrl);

			} catch (IOException e) {
				Assert.fail("Exception while checking the image: " + imgUrl + "\n" + e.getMessage());
			}
		}
	}

}
