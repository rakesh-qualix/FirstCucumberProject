package com.flightsOne;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoAirSrcAndDest {

	public WebDriver driver;
	WebDriverWait wait;
	String s = "";
	String t = "";
	String toArr;
	String listOfFromCities;
	String fromci;
	String xmlStr1;
	String xmlStr = "<Table>\n" + "  <Origin>#origin#</Origin>\n" + "<Destination>#destination#</Destination>\n"
			+ "    <EngineID>GoAir</EngineID>\n" + "  </Table>";

	@BeforeTest
	public void launchWebsite() {
		FirefoxProfile geoDisabled = new FirefoxProfile();
		geoDisabled.setPreference("geo.enabled", false);
		geoDisabled.setPreference("geo.provider.use_corelocation", false);
		geoDisabled.setPreference("geo.prompt.testing", false);
		geoDisabled.setPreference("geo.prompt.testing.allow", false);
		geoDisabled.setPreference("dom.webnotifications.enabled", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
		driver = new FirefoxDriver(geoDisabled);
		driver.get("https://www.goair.in");
		driver.manage().window().maximize();
		System.out.println("Sucessfully opened the website https://www.goair.in");

	}

	@Test
	public void from() throws InterruptedException {
		List<WebElement> oneWay = driver.findElements(By.xpath("//a[@id='owt']"));
		Thread.sleep(2000);
		oneWay.get(0).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> from = driver.findElements(By.xpath("//input[@placeholder='From']"));
		WebElement From = from.get(2);
		From.click();
		Thread.sleep(1000);
		String fromList = ".//*[@id='ui-id-5']/li";
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> fromCityList = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(fromList)));
		int sizeOfFromCities = fromCityList.size();
		System.out.println(sizeOfFromCities);
		List<String> listOfAirportSourceCode = new ArrayList<String>();
		for (int i = 0; i < sizeOfFromCities; i++) {
			String fromCity = fromCityList.get(i).getText();
			listOfAirportSourceCode.add(fromCity);

		}

		for (int j = 0; j < listOfAirportSourceCode.size(); j++) {
			if (j > 1) {
				From.clear();

				Thread.sleep(1000);
				From.click();
			}

			String DepCity = listOfAirportSourceCode.get(j);
			s = "";
			listOfFromCities = s.concat(DepCity);
			String[] depts = listOfFromCities.split("\\(");
			int size = depts[1].length();
			fromci = depts[1].trim().substring(0, size - 1);
			Thread.sleep(3000);
			From.sendKeys(fromci);
			Thread.sleep(1000);
			From.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			From.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			try {
				toCity();
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void toCity() throws InterruptedException {
		Thread.sleep(1000);
		String to = ".//*[@id='ui-id-2']/li";
		Thread.sleep(2000);
		List<WebElement> toCityList = driver.findElements(By.xpath(to));
		int sizeOfTo = toCityList.size();
		for (int j = 0; j < sizeOfTo; j++) {
			WebElement toCityTxt = toCityList.get(j);
			String text = toCityTxt.getAttribute("textContent");
			t = "";
			toArr = t.concat(text);
			String[] arrToCity = toArr.split("\\(");
			int len = arrToCity[1].length();
			String toCities = arrToCity[1].trim().substring(0, len - 1);
			s = s.concat(toCities + ",");
		}
		xmlStr1 = xmlStr.replace("#origin#", fromci);
		xmlStr1 = xmlStr1.replace("#destination#", s);
		System.out.println(xmlStr1);

	}

	@AfterTest
	public void closingBrowser() {
		driver.close();
		System.out.println("Browser closed successfuly!!!");
	}
}
