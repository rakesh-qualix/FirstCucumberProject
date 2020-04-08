package com.emtHotePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseLib {
	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void closingCionnection() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
}
