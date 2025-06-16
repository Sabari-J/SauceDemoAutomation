package hooks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseClass;
import utilities.ExtentReporter;
import utilities.PropertyUtils;

public class Hooks extends BaseClass {

	private PropertyUtils prop = new PropertyUtils();
	private static ExtentReports extent = ExtentReporter.getReport();
	private static ExtentTest test;

	@Before
	public void setup(Scenario scenario) {
		String browser = prop.getProperty("browser");
		initializeDriver(browser);

		test = extent.createTest(scenario.getName());

	}

	@AfterStep
	public void afterStep(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed Step Screenshot");

			String timestamp = new SimpleDateFormat("yyyyMMdd_hhmmssa").format(new Date());
			String screenshotPath = utilities.ScreenshotUtils.takeScreenshot(scenario.getName());
			logFailureWithScreenshot(screenshotPath,
					"Step Failed in scenario: " + scenario.getName() + "_" + timestamp);

		} else {
			
			test.pass("Step Passed" );
		}
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {

			String timestamp = new SimpleDateFormat("yyyyMMdd_hhmmssa").format(new Date());
			String screenshotPath = utilities.ScreenshotUtils.takeScreenshot(scenario.getName());

			logFailureWithScreenshot(screenshotPath, "Test Failed: " + scenario.getName() + "_" + timestamp);

		} else {
			test.pass("Test Passed successfully");
		}

		Thread.sleep(3000);
		// quitDriver();
		ExtentReporter.flushReport();

	}

	private void logFailureWithScreenshot(String screenshotPath, String message) {
		test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
}
