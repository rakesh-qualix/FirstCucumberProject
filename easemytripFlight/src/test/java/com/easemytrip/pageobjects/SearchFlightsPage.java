package com.easemytrip.pageobjects;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.easemytrip.generic.WaitStatementLib;

public class SearchFlightsPage {
	WebDriver driver;
	int numberOfWays;

	public int getNumberOfWays() {
		return numberOfWays;
	}

	public void setNumberOfWays(int numberOfWays) {
		this.numberOfWays = numberOfWays;
	}

	@FindBy(xpath = ("//div[@class='one-rou']/ul/li"))
	private List<WebElement> ways;
	@FindBy(xpath = ("//input[@id='FromSector_show']"))
	private WebElement fromCityName;
	@FindBy(xpath = ("//input[@id='Editbox13_show']"))
	private WebElement toCityName;
	@FindBy(xpath = ("//input[@id='ddate']"))
	private WebElement departureDate;
	@FindBy(xpath=("//div[contains(@class,'month')]//div"))
	private List<WebElement> listOfMonth;
	@FindBy(xpath = ("//input[@id='rdate']"))
	private WebElement returnDate;
	@FindBy(xpath = ("//a[@class='dropbtn_n']"))
	private List<WebElement> travellerAndClass;
	@FindBy(xpath = ("//div[@class='search_bg']/div[1]/div[6]/input"))
	private WebElement searchBtn;
	@FindBy(xpath = ("//a[text()='Modify Search & Try Again']"))
	public  WebElement modifyAndSearch;

	public SearchFlightsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// List of Airports
	List<String> listOfAirports = Arrays.asList("RPR", "MYQ", "TIR", "VTZ", "DEL", "BOM", "BLR", "MAA", "CCU", "HYD",
			"COK", "IXC", "AMD", "PNQ", "SXR", "GOI", "GAU", "TRV", "LKO", "ATQ", "IXE", "IDR", "CCJ", "CJB", "JAI",
			"NAG", "VNS", "PAT", "BDQ", "DED", "IXM", "IXB", "IXJ", "TRZ", "IXA", "BBI", "IMF", "DIB", "IXR", "IXZ",
			"JDH", "UDR", "IXL", "BHO", "STV", "GAY", "IXU", "RAJ", "IXS", "HJR", "AJL", "HBX", "RJA", "BHJ", "BZL",
			"JRH", "JLR", "AGX", "IXD", "DHM", "AGR", "PGH", "IXG", "BHU", "PBD", "GOP", "KUU", "GWL", "BPM", "DMU",
			"JGA", "SHL", "KNU", "LUH", "ATL", "PEK", "DXB", "HND", "LAX", "ORD", "LHR", "HKG", "PVG", "CDG", "AMS",
			"DFW", "CAN", "FRA", "IST", "CGK", "SIN", "ICN", "DEN", "BKK", "JFK", "KUL", "SFO", "MAD", "CTU", "LAS",
			"BCN", "YYZ");

	public void cityFrom() throws Exception {
		try {
			fromCityName.click();
			Random airport = new Random();
			@SuppressWarnings("unused")
			int randomAirportIndex = airport.nextInt(listOfAirports.size());
			//String cityFrom = listOfAirports.get(randomAirportIndex);
			String cityFrom = listOfAirports.get(4);
			fromCityName.sendKeys(cityFrom);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FromSector_show")));
			fromCityName.sendKeys(Keys.ARROW_DOWN);
			fromCityName.sendKeys(Keys.ENTER);
			WaitStatementLib.iWait(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void toCity() throws Exception {
		toCityName.click();
		Random airport = new Random();
		@SuppressWarnings("unused")
		int randomAirportIndex = airport.nextInt(listOfAirports.size());
		//String cityTo = listOfAirports.get(randomAirportIndex);
		String cityTo = listOfAirports.get(5);
		toCityName.sendKeys(cityTo);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Editbox13_show")));
		toCityName.sendKeys(Keys.ARROW_DOWN);
		toCityName.sendKeys(Keys.ENTER);
		WaitStatementLib.iWait(1);
	}

	public void depDate() throws Exception {
		departureDate.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddate")));
		List<WebElement> dDates = driver
				.findElements(By.xpath("//div[@id='dvcalendar']/div/div[2]/div/div[@class='days']/ul/li"));
		Random ra3 = new Random();
	int sizeOfTheDepDate = ra3.nextInt(dDates.size()-1);
	if(sizeOfTheDepDate<0){
		ra3.nextInt(dDates.size()-1);
		dDates.get(ra3.nextInt(dDates.size()-1)).click();
		WaitStatementLib.iWait(2);
	}
	else
			dDates.get(ra3.nextInt(dDates.size()-1)).click();
			WaitStatementLib.iWait(2);

	}

	public void returnDate() {
		returnDate.click();
		
		driver.findElement(By.xpath("//img[@id='img2Nex']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rdate")));
		List<WebElement> retDates = driver
				.findElements(By.xpath("//div[@id='dvcalendar']/div/div[1]/div/div[@class='days']/ul/li"));
		Random ra4 = new Random();
		int sizeOfTheRetDate = ra4.nextInt(retDates.size()-1);
		if(sizeOfTheRetDate<0){
			ra4.nextInt(retDates.size()-1);
			retDates.get(ra4.nextInt(retDates.size()-1)).click();
			WaitStatementLib.iWait(2);
		}
		else
			
		 retDates.get(ra4.nextInt(retDates.size()-1)).click();
			WaitStatementLib.iWait(2);
		
	}

	public int selectingWays() throws Exception {
		WaitStatementLib.iWait(2);
		numberOfWays = returnways();
		setNumberOfWays(numberOfWays);
		WebElement wayChoosen = ways.get(numberOfWays);
		wayChoosen.click();
		System.out.println("Selecetd way is " + wayChoosen.getText());
		System.out.println("========================================");
		if (numberOfWays == 0) {
			cityFrom();
			toCity();
			depDate();
			//travelersDetails();
			clickOnSearch();
			isAlertPresent();
			if (modifyAndSearch.isDisplayed()) {
				modifyAndSearch.click();
				WaitStatementLib.iWait(2);
				selectingWays();
			}
		} else if (numberOfWays == 1) {
			cityFrom();
			toCity();
			depDate();
			returnDate();
		//	travelersDetails();
			clickOnSearch();
			isAlertPresent();
			
			//Handling Alert for Modify And Search Issue
			if (modifyAndSearch.isDisplayed()) {
				modifyAndSearch.click();
				WaitStatementLib.iWait(2);
				selectingWays();
			}
		}
		return numberOfWays;
	}

	public int returnways() {
		Random rand = new Random();
		List<Integer> givenList = Arrays.asList(0, 1);
		int randomElement = 0;
		int numberOfElements = 1;

		for (int i = 0; i < numberOfElements; i++) {

			 @SuppressWarnings("unused")
			int randomIndex = rand.nextInt(givenList.size());
			  //randomElement = givenList.get(randomIndex);
			 
			//randomElement = givenList.get(rand.nextInt(givenList.size()));
			randomElement = givenList.get(0);
		}
		return randomElement;
	}

	public void travelersDetails() {
		travellerAndClass.get(0).click();
		WaitStatementLib.iWait(1);
		List<WebElement> plus = driver.findElements(
				By.xpath("//div[@id='myDropdown_n']/div/div[@class='main_dv']/div[2]/div/div[3]/input[@value='+']"));
		WebElement sizeOfPlusSignForAdult = plus.get(0);
		WebElement sizeOfPlusSignForChid = plus.get(1);
		WebElement sizeOfPlusSignForInfant = plus.get(2);
		for (int i = 1; i <= 1; i++) {
			sizeOfPlusSignForAdult.click();
			sizeOfPlusSignForChid.click();
			sizeOfPlusSignForInfant.click();

		}
		driver.findElement(By.xpath("//div[@id='myDropdown_n']/div/a[text()='Done']")).click();
		WaitStatementLib.iWait(2);
	}

	public void clickOnSearch() throws Exception {
		try {
			searchBtn.click();
			WaitStatementLib.iWait(5);
			if (isAlertPresent()) {
				selectingWays();
			}

			else if (modifyAndSearch.isDisplayed()) {
				modifyAndSearch.click();
				WaitStatementLib.iWait(2);
				selectingWays();
			}

		} catch (Exception e1) {

			System.out.println(e1);
		}
	}

	
	//Handling Adult on Search Flight Page
	public boolean isAlertPresent() {
		try {
			Alert a = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());

			if (a != null) {
				//System.out.println("Alert is present");
				driver.switchTo().alert().accept();
				selectingWays();
				return true;
			}

			else {
				throw new Throwable();

			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false;
		}

	}
}
