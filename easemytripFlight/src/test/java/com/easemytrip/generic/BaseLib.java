
package com.easemytrip.generic;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseLib  {
	
	public WebDriver driver;
	
	@BeforeTest
	//If you want to perform cross browser testing need to take parameter annotation and to change browserName as browser
	//@Parameters("browser")
	//public void setup(String browser) throws Exception{
	public void setUp() {
		String browserName = GenericLib.getValue("browser");
		
		try
		{
		if (browserName.equalsIgnoreCase("firefox")) {
			
			
			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			driver = (new FirefoxDriver(ffprofile));
			
			Reporter.log("Firefox launched      Going to execute Tests", true);
			
			
			//Reporter.log("Navigating to www.easemytrip.com", true);
			
		} else if (browserName.equalsIgnoreCase("chrome")){

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
			Reporter.log("Chrome Launched", true);
		} 
		driver.manage().window().maximize();
		WaitStatementLib.iWaitForSecs(driver, 10);
		driver.get(GenericLib.getValue("testurl"));
		Reporter.log(" Please Wait!!!!!!---> Browser is navigating to www.easemytrip.com!!!!!<----", true);
		}catch(Exception e){
			System.out.println(e.getMessage());
	
		}
		
	}
	
@AfterMethod

	public void getScreen(ITestResult result) throws IOException {

		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				String fileName = result.getMethod().getMethodName();
				ScreenshotLib slib = new ScreenshotLib();
				slib.takeScreenshot(driver, fileName);

				Reporter.log("Screenshot has been taken", true);
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
}
		

	@AfterTest
	public void tearDown() {
	
		//System.out.println("Going to search other Sector....");
		//driver.close();
		//Reporter.log("Browser closed", true);
	}
	
	

}
