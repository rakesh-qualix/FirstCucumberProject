package com.flightsOne;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpiceJetDepAndArr {

	public WebDriver driver;
	String xmlStr1;
	String xmlStr = "<Table>\n" + "  <Origin>#origin#</Origin>\n" + "<Destination>#destination#</Destination>\n"
			+ "    <EngineID>SpiceJet</EngineID>\n" + "  </Table>";
	String deptci;
	String DepCity;
	String k = "";
	String s = "";
	String listOfDeptCities = "";
	String ar;
	// String deptci1;

	@BeforeTest
	public void launchWebsite() {
		driver = new FirefoxDriver();
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\user\\Desktop\\NewBackup1112018\\newFlight\\FlightOriginAndDestination\\exefiles\\chromedriver.exe"
		 * ); driver=new ChromeDriver();
		 */

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		System.out.println("Sucessfully opened the website https://www.spicejet.com/");

	}

	@Test(priority = 0)
	public void from() throws InterruptedException {
		String deptCity = "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']";
		WebElement departure = driver.findElement(By.xpath(deptCity));
		departure.click();
		String listOfDepCity = "//table[@id='citydropdown']/tbody/tr[2]/td[2]/div[3]/div/div/ul/li";
		List<WebElement> depList = driver.findElements(By.xpath(listOfDepCity));
		int sizeOfDepCity = depList.size();

		List<String> listOfAirportSourceCode = new ArrayList<String>();
		for (int i = 0; i < sizeOfDepCity; i++) {
			String depCity = depList.get(i).getText();
			listOfAirportSourceCode.add(depCity);
		}

		for (int j = 0; j < listOfAirportSourceCode.size(); j++) {
			if (j > 0) {
				//Thread.sleep(1000);
				departure.click();
				Thread.sleep(500);
				departure.clear();
			}

			String DepCity = listOfAirportSourceCode.get(j);
			s = "";
			listOfDeptCities = s.concat(DepCity);
			String[] depts = listOfDeptCities.split("\\(");
			int size = depts[1].length();
			deptci = depts[1].trim().substring(0, size - 1);
			// departure.sendKeys(deptci);
			// if(!departure.getText() .equals(DepCity)) {
				// departure.clear();
				// Thread.sleep(1000);
			if(deptci.equalsIgnoreCase("IXB")) {
				departure.sendKeys(deptci);
				Thread.sleep(1000);
			}
			if(deptci.equalsIgnoreCase("RJA")) {
				departure.sendKeys("RJ");
				Thread.sleep(1000);
			}
			else {
				 departure.sendKeys(DepCity);
				 Thread.sleep(5000);
				 arrivalCity();
				 Thread.sleep(3000);
			 }
		}
	
			//Thread.sleep(5000);
			/*
			 * if("AIP".equalsIgnoreCase(deptci)||"JAI".equalsIgnoreCase(deptci)||"PAT".
			 * equalsIgnoreCase(deptci)) {
			 * 
			 * }
			 */

			/*if (deptci.equalsIgnoreCase("AIP")) {
				//Actions action = new Actions(driver);
				WebElement element = driver.findElement(By.xpath("//div[@id='dropdownGroup1']/div/ul[1]/li[1]"));
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement APICity = wait.until(ExpectedConditions.visibilityOf(element));
				APICity.click();
				Thread.sleep(500);
				APICity.click();
				//action.moveToElement(APICity).doubleClick(APICity).build().perform();

			}
			if (deptci.equalsIgnoreCase("JAI")) {
				//Actions action = new Actions(driver);
				WebElement element = driver.findElement(By.xpath("//div[@id='dropdownGroup1']/div/ul[1]/li[18]/a"));
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement JAICity = wait.until(ExpectedConditions.visibilityOf(element));
				JAICity.click();
				Thread.sleep(1000);
				//action.doubleClick(JAICity).perform();
			}
			if (deptci.equalsIgnoreCase("PAT")) {
			//Actions action = new Actions(driver);
				WebElement element = driver.findElement(By.xpath("//div[@id='dropdownGroup1']/div/ul[1]/li[33]/a"));
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement PATCity = wait.until(ExpectedConditions.visibilityOf(element));
				PATCity.click();
				Thread.sleep(1000);
				//action.doubleClick(PATCity).perform();
			}
*/
			//arrivalCity();

		}

//	}

	@Test(priority = 1)
	public void arrivalCity() throws InterruptedException {
		String arrivalList1 = "//div[contains(@class,'right1')]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div/div/ul/li";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> arrivalList= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(arrivalList1)));
		int sizeOfArrCityList = arrivalList.size();
		for (int i = 0; i < sizeOfArrCityList; i++) {
			String citiesName = arrivalList.get(i).getAttribute("textContent");
			k = "";
			ar = k.concat(citiesName);
			String[] arr = ar.split("\\(");
			int length = arr[1].length();
			String arrci = arr[1].trim().substring(0, length - 1);
			s = s.concat(arrci + ",");
		}
		xmlStr1 = xmlStr.replace("#origin#", deptci);
		//xmlStr1 = xmlStr.replace("#origin#", DepCity);
		xmlStr1 = xmlStr1.replace("#destination#", s);
		System.out.println(xmlStr1);


	}
}

// }
