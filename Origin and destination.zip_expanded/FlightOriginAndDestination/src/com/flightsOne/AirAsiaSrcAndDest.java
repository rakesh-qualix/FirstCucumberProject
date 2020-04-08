package com.flightsOne;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AirAsiaSrcAndDest {
	public WebDriver driver;
	String s = "";
	String listOfOriginCities;
	String orgnCi;
	String t;
	String toArr;
	String xmlStr1;
	String xmlStr = "<Table>\n" + "  <Origin>#origin#</Origin>\n" + "<Destination>#destination#</Destination>\n"
			+ "    <EngineID>AirAsia</EngineID>\n" + "  </Table>";

	@BeforeTest
	public void launchWebsite() throws InterruptedException {
		driver = new FirefoxDriver();

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\user\\Desktop\\NewBackup1112018\\newFlight\\FlightOriginAndDestination\\exefiles\\chromedriver.exe"
		 * ); driver=new ChromeDriver();
		 */

		driver.get("https://www.airasia.com/");
		driver.manage().window().maximize();
		System.out.println("Sucessfully opened the website https://www.airasia.com/");
		Thread.sleep(3000);
	}

	@Test
	public void origin() throws InterruptedException {

		WebElement Orgn = driver.findElement(By.xpath("//div[@id='cb_origins_container']/label/span/span[1]/span"));
		Orgn.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='select2-cb_origins-icon']")).click();
		Thread.sleep(2000);
		String origin = "//ul[@id='select2-cb_origins-results']/li/div/span[1]";
		List<WebElement> originList = driver.findElements(By.xpath(origin));
		int size = originList.size();
		Thread.sleep(1000);
		// System.out.println(size);
		List<String> listOfIATACode = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			String orgnCity = originList.get(i).getText();
			listOfIATACode.add(orgnCity);
		}
		for (int j = 0; j < listOfIATACode.size(); j++) {
			if (j > 0) {
				Thread.sleep(1000);
				Orgn.click();
			}

			String DepCity = listOfIATACode.get(j);
			s = "";
			listOfOriginCities = s.concat(DepCity);
			String[] SplittedOrigin = listOfOriginCities.split("\\(");
			int si = SplittedOrigin.length;
			if (si > 2) {
				int sizeOfOrgn = SplittedOrigin[2].length();
				orgnCi = SplittedOrigin[2].trim().substring(0, sizeOfOrgn - 1);
				Orgn.sendKeys(orgnCi);
				Thread.sleep(1000);
				Orgn.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
			}

			else {
				int sizeOfOrgn = SplittedOrigin[1].length();
				orgnCi = SplittedOrigin[1].trim().substring(0, sizeOfOrgn - 1);
				Orgn.sendKeys(orgnCi);
				Thread.sleep(1000);
				Orgn.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
			}
			destination();
		}

	}

	@Test
	public void destination() throws InterruptedException {
		WebElement dest = driver.findElement(By.xpath("//span[@id='select2-cb_destinations-icon']"));
		dest.click();
		Thread.sleep(1000);
		String destnList = "//span[@class='select2-results']/ul/li/div/span[1]";
		List<WebElement> destn = driver.findElements(By.xpath(destnList));
		int sizeOfDestn = destn.size();
		for (int j = 0; j < sizeOfDestn; j++) {
			WebElement destCityTxt = destn.get(j);
			String text = destCityTxt.getText();
			t = "";
			toArr = t.concat(text);
			String[] arrToCity = toArr.split("\\(");
			int sizeOfArr = arrToCity.length;
			if (sizeOfArr > 2) {
				int len = arrToCity[2].length();
				String toCities = arrToCity[2].trim().substring(0, len - 1);
				s = s.concat(toCities + ",");
			} else {
				int len = arrToCity[1].length();
				String toCities = arrToCity[1].trim().substring(0, len - 1);
				s = s.concat(toCities + ",");
			}
		}
		xmlStr1 = xmlStr.replace("#origin#", orgnCi);
		xmlStr1 = xmlStr1.replace("#destination#", s);
		System.out.println(xmlStr1);

	}
	/*
	 * @Test public void closingBrowser() { driver.close();
	 * System.out.println("Browser closed successfully!!!");
	 * 
	 * }
	 */
}
