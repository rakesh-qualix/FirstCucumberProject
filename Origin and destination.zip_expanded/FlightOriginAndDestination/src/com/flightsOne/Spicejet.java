package com.flightsOne;
import java.util.Arrays;
import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Spicejet {

		public WebDriver driver;
		String xmlStr1;
		String xmlStr = "<Table>\n" + "  <Origin>#origin#</Origin>\n" + "<Destination>#destination#</Destination>\n"
				+ "    <EngineID>SpiceJet</EngineID>\n" + "  </Table>";
		String deptci;
		String k = "";
		String s = "";
		String listOfDeptCities = "";
		String ar;

		@BeforeTest
		public void launchWebsite() {
			driver = new FirefoxDriver();
			/*System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\NewBackup1112018\\newFlight\\FlightOriginAndDestination\\exefiles\\chromedriver.exe");
			driver=new ChromeDriver();*/
		
			driver.get("https://www.spicejet.com/");
			driver.manage().window().maximize();
			System.out.println("Sucessfully opened the website https://www.spicejet.com/");

		}

		@Test(priority = 0)
		public void from() throws InterruptedException {
			String deptCity = "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']";
			WebElement departure = driver.findElement(By.xpath(deptCity));
			departure.click();
			List<String> listOfAirportSourceCode = Arrays.asList("AIP", "AMD", "ATQ", "IXB", "BLR", "MAA", "CJB", "DED",
					"DEL", "DIB", "GOI", "GOP", "GAU", "HBX", "HYD", "JLR", "JAI", "JSA", "IXJ", "JDH", "IXY", "KNU", "KQH",
					"COK", "CCU", "CCJ", "IXL", "IXM", "IXE", "BOM", "PYG", "PAT", "PNY", "PBD", "IXZ", "PNQ", "RJA", "SAG",
					"BOM", "TIR", "MAA", "IMF", "MCT", "TCR", "CJB", "IDR", "NAG", "UDR", "CMB", "JAI", "PAT", "BDQ", "DED",
					"IXS", "SXR", "STV", "TRV", "TIR", "TCR", "UDR", "VNS", "VGA", "VTZ","BKK","CMB","DAC","DXB","HKG","KBL","MLE","MCT");	
			int sizeOfList = listOfAirportSourceCode.size();
			for (int i = 0; i < sizeOfList - 1; i++) {
				deptci = listOfAirportSourceCode.get(i);
				if(i>=0) {
					departure.click();
					Thread.sleep(1000);
					departure.clear();
					
				}
				departure.sendKeys(deptci);

				if (deptci.equalsIgnoreCase("AIP")) {
					Actions action=new Actions(driver);
					Thread.sleep(2000);
					WebElement APICity = driver.findElement(By.xpath("//div[@id='dropdownGroup1']/div/ul[1]/li[1]"));
					/*String aipXpath = "//div[@id='dropdownGroup1']/div/ul[1]/li[1]";
					WebDriverWait wait=new WebDriverWait(driver, 20);
					WebElement APICity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(aipXpath)));*/
					action.doubleClick(APICity).perform();
//					driver.findElement(By.xpath(aipXpath)).click();
//					Thread.sleep(2000);
				}
				if (deptci.equalsIgnoreCase("JAI")) {
					Thread.sleep(2000);
					String jaiXpath = "//div[@id='dropdownGroup1']/div/ul[1]/li[18]/a";
					driver.findElement(By.xpath(jaiXpath)).click();
					Thread.sleep(2000);
				}
				if (deptci.equalsIgnoreCase("PAT")) {
					Thread.sleep(2000);
					String patXpath = "//div[@id='dropdownGroup1']/div/ul[1]/li[33]/a";
					driver.findElement(By.xpath(patXpath)).click();
					Thread.sleep(2000);
				}
				arrivalCity();
			}
//				s = "";
			

			}

		

		@Test(priority = 1)
		public void arrivalCity() throws InterruptedException {

			Thread.sleep(2000);
			String arrivalList="//div[@id='flightSearchContainer']/div[3]/div[1]/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div/div/ul/li//a";
//			Thread.sleep(5000);
//			List<WebElement> arrCityList = driver.findElements(By.xpath(arrivalList));
//			Thread.sleep(5000);

			
			WebDriverWait wait=new WebDriverWait(driver, 10);
			List<WebElement> arrCityList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(arrivalList)));
			Thread.sleep(5000);
			//List<WebElement> arrCityList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(arrivalList)));
			
			int sizeOfArrCityList = arrCityList.size();
			

			
			for (int i = 0; i < sizeOfArrCityList; i++) {
				String citiesName = arrCityList.get(i).getText();
				k="";
				 ar = k.concat(citiesName);
				String[] arr = ar.split("\\(");
				int length = arr[1].length();
				String arrci = arr[1].trim().substring(0, length-1);
				//if (!citiesName.equals(deptci)) {
					//s = s.concat(citiesName + ",");
				s = s.concat(arrci + ",");
			
			}
			 
			xmlStr1 = xmlStr.replace("#origin#", deptci);
			xmlStr1 = xmlStr1.replace("#destination#", s);
			System.out.println(xmlStr1);
			Thread.sleep(2000);
			

		}
		
		}


