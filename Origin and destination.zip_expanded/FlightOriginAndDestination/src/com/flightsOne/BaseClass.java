package com.flightsOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
//For Indigo
		FirefoxProfile geoDisabled = new FirefoxProfile();
		geoDisabled.setPreference("geo.enabled", false);
		geoDisabled.setPreference("geo.provider.use_corelocation", false);
		geoDisabled.setPreference("geo.prompt.testing", false);
		geoDisabled.setPreference("geo.prompt.testing.allow", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
		driver = new FirefoxDriver(geoDisabled);
		driver.get("https://www.goindigo.in/");
		driver.manage().window().maximize();
		System.out.println("Sucessfully opened the website https://www.goindigo.in/");
		
		
		/*//For SpiceJet
		driver = new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		System.out.println("Sucessfully opened the website https://www.spicejet.com/");
		driver.manage().window().maximize();*/

	}
	
	@AfterTest
	public void closingConnnection() {
		driver.close();
	}


}
