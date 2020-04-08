package com.flightsOne;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AirArabiaSrcAndDest {
	public WebDriver driver;
	// String countryNameText;
	String s = "";
	String cityText;
	String cityFrom;
	String xmlStr1;
	String xmlStr = "<Table>\n" + "  <Origin>#origin#</Origin>\n" + "<Destination>#destination#</Destination>\n"
			+ "    <EngineID>AirArabia</EngineID>\n" + "  </Table>";

	@BeforeTest
	public void launchWebsite() {
		driver = new FirefoxDriver();
		driver.get("https://www.airarabia.com");
		driver.manage().window().maximize();
		System.out.println("Sucessfully opened the website https://www.airarabia.com");
		System.out.println("===================================================== ");
	}

	@Test(priority = 1)
	public void fromCountryWise() throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='One way']")).click();
		driver.findElement(By.xpath("//div[@class='search_field form_flying_from']/input[2]")).click();
		String allCities = "//div[@id='tabs-flights']/div/div[1]/div/form/div[1]/div/div[4]/ul/li/a";
		List<WebElement> allCitiesName = driver.findElements(By.xpath(allCities));
		int sizes = allCitiesName.size();
		List<String> listOfCities = new ArrayList<String>();
		for (int j = 0; j < sizes; j++) {
			cityText = allCitiesName.get(j).getAttribute("text");
			// Thread.sleep(1000);
			listOfCities.add(cityText);
		}

		for (int k = 0; k < listOfCities.size(); k++) {
			WebElement from = driver.findElement(By.xpath("//div[@class='search_field form_flying_from']/input[2]"));
			from.click();
			String cities = listOfCities.get(k);
			s = "";
			cityFrom = s.concat(cities);
			String[] splittedText = cityFrom.split("\\)");
			String fromCi = splittedText[0].trim();
			from.sendKeys(fromCi + ")");
			Thread.sleep(1000);
			from.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			System.out.println("===================================================== ");
			System.out.println("Selected City is :" + fromCi + ")");
			To();
			Thread.sleep(1000);
		}
	}

	@Test(priority = 2)
	public void To() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='flying-to']")).click();
		Thread.sleep(1000);
		String to = "//div[@id='tabs-flights']/div/div[1]/div/form/div[2]/div/div[4]/ul/li/a";
		List<WebElement> toCity = driver.findElements(By.xpath(to));
		int sizeTo = toCity.size();
		for (int l = 0; l < sizeTo; l++) {
			WebElement tocities = toCity.get(l);
			Thread.sleep(1000);
			String text = tocities.getAttribute("data-iata");
			Thread.sleep(1000);
			s = s.concat(text + ",");

		}
		xmlStr1 = xmlStr.replace("#origin#", cityFrom);
		xmlStr1 = xmlStr1.replace("#destination#", s);
		System.out.println(xmlStr1);

	}

	@AfterTest
	public void closingBrowser() {
		driver.close();
		System.out.println("Firefox browser closed successfully!!!");
	}
}
