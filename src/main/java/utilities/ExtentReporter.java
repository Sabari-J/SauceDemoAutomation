package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	private static ExtentReports extent;
	private static PropertyUtils prop = new PropertyUtils();
	
	public static ExtentReports getReport() {
		
		if(extent == null) {
			
			String timestamp = new SimpleDateFormat("yyyyMMdd_hhmmssa").format(new Date());
	        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport_" + timestamp + ".html";
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			sparkReporter.config().setReportName("Test Execution Report_Results - SauceDemo_Automation");
			
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			String environment = prop.getProperty("environment");
			String browser = prop.getProperty("browser");
			
			extent.setSystemInfo("Environment", environment);
			extent.setSystemInfo("Browser", browser);
			
		}
		return extent;
	}
	
	public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
	}
}
