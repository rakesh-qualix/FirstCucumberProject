package com.easemytrip.pageobjects;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.easemytrip.generic.WaitStatementLib;

public class BookFlightPage {
	WebDriver driver;

	@FindBy(xpath = ("//div[@class='list divHideShow ng-scope']//div[@class='flgi-rm3']/button"))
	private List<WebElement> interButtons;
	// WebElement for fare details
	@FindBy(xpath = ("//div[@class='d-up']"))
	private List<WebElement> domFlightDetails;
	@FindBy(xpath = ("//div[contains(@id,'divFlightDetail')]/ul/li"))
	private List<WebElement> fetchingFlightFareDetails;
	@FindBy(xpath = ("//div[contains(@id,'divFlightDetailSec')]/div[2]/div/div/div[2]"))
	private WebElement detailsByEachTab;
	@FindBy(xpath = ("//button[contains(text(),'Book Now')]"))
	private List<WebElement> domButtons;
	
	
	//Webelement for Domestic RoundTrip Flight Details
		@FindBy(xpath=("//div[text()='Flight Detail']"))
		private List<WebElement> domRoundTripFlightDetailsLink;
		@FindBy(xpath=("//div[@id='divFlightDetailSec54']/ul/li"))
		private List<WebElement> roundTripFareDetailsTabs;
		@FindBy(xpath=("//div[@id='fd54']/div/div[@class='row']"))
		private List<WebElement> roundTripFareDetailsTabsData;
		
		
		
		
		
	@FindBy(xpath = ("//div[@class='row']/div[1]/div[3]/div[1]/div"))
	private List<WebElement> oneGoFlight;
	@FindBy(xpath = ("//div[@class='row']/div[2]/div[3]/div[1]/div"))
	private List<WebElement> returnFlight;
	@FindBy(xpath = ("//div[@id='BtnBookNow']"))
	private WebElement roundTripBookNowBtn;
	@FindBy(xpath = ("//div[@class='inp-b5']//span[text()='1']"))
	private WebElement noOfTravellers;
	@FindBy(xpath = ("//div[@class='fd-l']/div[1]"))
	private WebElement FlightDetails;
	@FindBy(xpath = ("//div[@class='row bor-b']/div[2]/div/div[2]/button[text()='Book Now']"))
	private List<WebElement> mulCityBookNowBtn;
	
	

	public BookFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

		this.driver = driver;
	}

	public void compareTrips(int numberOfWays) {
		WaitStatementLib.iWait(2);
		if (numberOfWays == 0) {
			comp();
		} else if (numberOfWays == 1) {
			roundTripComp();
		}
	}
//method for fetching Flight Details for Domestic OneWay
	public void fareDetails() {
		Random flightDetails = new Random();
		domFlightDetails.get(flightDetails.nextInt(domFlightDetails.size())).click();
		int sizeOfFaresDetailstab = fetchingFlightFareDetails.size();
		for (int i = 0; i < sizeOfFaresDetailstab; i++) {
			fetchingFlightFareDetails.get(i).click();
			String tabName = fetchingFlightFareDetails.get(i).getText();
			System.out.println(tabName);
			if (i == 2) {
				List<WebElement> baggageInformation = driver
						.findElements(By.xpath("//div[@class='row bord-bot5 no-margn mar-to-12']/div"));
				int sizeOfBaggage = baggageInformation.size();
				for (int j = 0; j < sizeOfBaggage; j++) {
					String baggageContent = baggageInformation.get(j).getText();
					List<WebElement> baggageText = driver
							.findElements(By.xpath("//div[@class='baggage-info ng-scope']/div[3]/div"));
					String textInBaggageTab = baggageText.get(j).getText();
					System.out.println(baggageContent + "\t");
					System.out.println(textInBaggageTab + "\t");
				}

			} else if (i == 3) {
				List<WebElement> cancellationRule = driver.findElements(By.xpath("//div[@class='bood mg-btm']/div"));
				int sizeOfCancellation = cancellationRule.size();
				for (int k = 0; k < sizeOfCancellation; k++) {
					String dataInRow = cancellationRule.get(k).getText();
					System.out.println(dataInRow + "\t");

				}
			} else {
				String contentOfFareDetails = detailsByEachTab.getText();
				System.out.println(contentOfFareDetails + "\t");
			}
		}
	}

	
	//method for fetching Flight Details for Domestic RoundTrip
	
	/*public void DomRoundTripfareDetails() {
	
		Random rpFltDetails=new Random();
		
		domRoundTripFlightDetailsLink.get(rpFltDetails.nextInt(domRoundTripFlightDetailsLink.size())).click();
		
		int sizeOfRoundTripFareDetailsTab = roundTripFareDetailsTabs.size();
		
		for(int i=0;i<sizeOfRoundTripFareDetailsTab;i++){
			String roundripDomeFlightDetailsTabName = roundTripFareDetailsTabs.get(i).getText();
			System.out.println(roundripDomeFlightDetailsTabName);
			
		}
		 	
	}*/
	
	public void comp() {
		WaitStatementLib.iWaitForSecs(driver, 1);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if (pageTitle.trim().contains("InternationalOwView2")) {
			Random ra3 = new Random();
			//interButtons.size();
			interButtons.get(ra3.nextInt(interButtons.size())).click();
			detailsOfFlight();
		}

		else {
			Random ra3 = new Random();
			fareDetails();//calling method because fetching domestic flight -->flight details
			domButtons.get(ra3.nextInt(domButtons.size())).click();
			detailsOfFlight();
		}

	}

	public void clickingGoingFlights() {
		Random ra4 = new Random();
		oneGoFlight.get(ra4.nextInt(oneGoFlight.size())).click();
		
	

	}

	public void clickingReturningFlights() {
		Random ra5 = new Random();
		returnFlight.get(ra5.nextInt(returnFlight.size())).click();
		
		roundTripBookNowBtn.click();

	}
	public void detailsOfFlight() {
		try {
			String detailsOfSelectedFlight = FlightDetails.getText();
			System.out.println("Details of selected Flights are:  " + detailsOfSelectedFlight);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void roundTripComp() {
		WaitStatementLib.iWait(2);

		String roundTriptDomPageTitle = driver.getTitle();
		System.out.println("Searched url is: " + roundTriptDomPageTitle);
		/*if (roundTriptDomPageTitle.trim()
				.contains("RoundTrip Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com")) {*/
		/*if (roundTriptDomPageTitle.trim()
				.contains("RoundTrip Lowest Airfare, Flight Tickets, Cheap Air Tickets  EaseMyTrip.com")) {*/
		if (roundTriptDomPageTitle
				.contains("RoundTrip Lowest Airfare")) {
			try {
				clickingGoingFlights();
				
				clickingReturningFlights();
				
				detailsOfFlight();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else {
			List<WebElement> intlBookNowBtn = driver.findElements(By.xpath("//button[text()='Book Now']"));
			Random ra6 = new Random();
			intlBookNowBtn.get(ra6.nextInt(intlBookNowBtn.size())).click();
			detailsOfFlight();

		}

	}

	/*
	 * public void BookMulCityFlight(){ // String numberOfTraveller =
	 * noOfTravellers.getAttribute("value"); //System.out.println(
	 * "Selected number of traveller is :"+numberOfTraveller); Random ra5 = new
	 * Random(); int mulCityFlight = ra5.nextInt(mulCityBookNowBtn.size());
	 * WaitStatementLib.iWait(2); System.out.println(
	 * "Number of flights found : " + mulCityFlight); WaitStatementLib.iWait(2);
	 * mulCityBookNowBtn.get(mulCityFlight).click(); WaitStatementLib.iWait(2);
	 * detailsOfFlight(); }
	 */
	public boolean isAlertPresent() {
		try {
			Alert a1 = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a1 != null) {
				System.out.println("Alert is present");
				driver.switchTo().alert().accept();
				clickingGoingFlights();
				clickingReturningFlights();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println("Alert isn't present!!");
		}
		return false;

	}
}
