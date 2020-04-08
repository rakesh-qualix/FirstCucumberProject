package com.easemytrip.scripts;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.easemytrip.generic.BaseLib;
import com.easemytrip.generic.WaitStatementLib;
import com.easemytrip.pageobjects.BookFlightPage;
import com.easemytrip.pageobjects.MulticitySearchPage;
import com.easemytrip.pageobjects.PaymentModePage;
import com.easemytrip.pageobjects.ReviewFlightDetailsPage;
import com.easemytrip.pageobjects.SearchFlightsPage;
import com.easemytrip.pageobjects.TravellerDetailsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RunScript extends BaseLib {
	ExtentReports extent;
	ExtentTest logger;
	MulticitySearchPage msp;
	SearchFlightsPage sf;
	BookFlightPage bfp;
	ReviewFlightDetailsPage rfp;
	TravellerDetailsPage tdp;
	PaymentModePage pmp;
	int numberOfWays;

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/html/FlightExtentReport.html", true);
		//extent = new ExtentReports(System.getProperty("user.dir") + "FlightxtEntReport.html", true);

		extent.addSystemInfo("Host Name", "RAKESH KUMAR JHA").addSystemInfo("Environment", "QA Server")
				.addSystemInfo("User Name", "EASY TRIP PLANNERS PVT LTD.");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	/*
	 * @Test(testName = "Multicity Searching Flight", priority = 1, description
	 * = "Searching Flight.....") public void mulCityFlightSearch(){ msp=new
	 * MulticitySearchPage(driver); msp.searchingMulticityWay(); msp.deptCity();
	 * msp.destCity(); msp.pickingDate1(); msp.destCity2(); msp.pickingDate2();
	 * msp.mulCityFlightSearchBtn(); msp.isAlertPresent();
	 * 
	 * } //For multicity only /*@Test(testName = "Multicity Book Flight",
	 * priority = 2, description = "Flight displayed.....") public void
	 * bookMulticityFlight(){ bfp = new BookFlightPage(driver);
	 * bfp.BookMulCityFlight(); }
	 */
	@Test(testName = "Searching Flight", priority = 1, description = "Flight displayed.....")
	public void callSearchFlight() throws Exception {
		logger = extent.startTest("callSearchFlight");
		Assert.assertTrue(true);
		// To generate the log when the test case is passed
		// logger.log(LogStatus.PASS, "Test Case callSearchFlight Passed");
		sf = new SearchFlightsPage(driver);
		numberOfWays = sf.selectingWays();
	}

	@Test(testName = "Checking Flight ", priority = 2, dependsOnMethods = "callSearchFlight", description = "Check Whether searching flight is for Domestic or International:")
	// @Test(testName = "Checking Flight ", priority = 2, dependsOnMethods =
	// "mulCityFlightSearch", description = "Multicity Flight:")
	public void toCheckInternationOrDomesticFlights() {
		logger = extent.startTest("toCheckInternationOrDomesticFlights");
		Assert.assertTrue(true);
		// To generate the log when the test case is passed
		// logger.log(LogStatus.PASS, "Test Case
		// toCheckInternationOrDomesticFlights Passed");

		// public void multicityFlight(){
		bfp = new BookFlightPage(driver);
		WaitStatementLib.iWait(2);
		// bfp.BookMulCityFlight();//For multicity only
		bfp.compareTrips(numberOfWays);
		// bfp.isAlertPresent();
	}

	@Test(testName = "Entering Email", priority = 3, dependsOnMethods = "toCheckInternationOrDomesticFlights", description = " Going to Enter Email Id:")
	// @Test(testName = "Entering Email", priority = 3, dependsOnMethods =
	// "multicityFlight", description = " Going to Enter Email Id:")
	public void enteringEmailId() throws Exception {
		logger = extent.startTest("enteringEmailId");
		Assert.assertTrue(true);
		// To generate the log when the test case is passed
		// logger.log(LogStatus.PASS, "Test Case enteringEmailId Passed");
		rfp = new ReviewFlightDetailsPage(driver);
		// rfp.modifyAndSearch();
		rfp.enterEmail();
		WaitStatementLib.iWait(3);
//		rfp.verfyingCouponCode();
//		WaitStatementLib.iWait(2);
		rfp.clickOnContinue();
		WaitStatementLib.iWait(1);
	}

	@Test(testName = "Enter travellers details", priority = 4, dependsOnMethods = "enteringEmailId", description = "Going to enter travellers details:")
	public void enteringAdults() {
		logger = extent.startTest("enteringAdults");
		Assert.assertTrue(true);
		// To generate the log when the test case is passed
		// logger.log(LogStatus.PASS, "Test Case enteringAdults Passed ");
		tdp = new TravellerDetailsPage(driver);
		tdp.travellersDetails();
		tdp.contactNumber();
		tdp.clickOnContinueButton();

	}

	@Test(priority = 5, dependsOnMethods = "enteringAdults", description = "Going to enter payment details")
	public void goingToMakePayment() {
		logger = extent.startTest("goingToMakePayment");
		Assert.assertTrue(true);
		// To generate the log when the test case is passed
		pmp = new PaymentModePage(driver);
		pmp.fetchingTravelerDetails();
		pmp.fetchingPrice();
		pmp.selectingPaymentOptions();
		pmp.findingClickedPaymentOption();
		
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test Case Failed");
			logger.log(LogStatus.FAIL, "Test Case Failed Exception is " + result.getThrowable());
			WaitStatementLib.iWait(5);
			
		/*	logger.log(LogStatus.FAIL,
					logger.addScreenCapture("D:\\EasemytripFlightProject\\easemytripFlight\\screenshots\\"
							+ result.getMethod().getMethodName() + ".png"));*/
			
			logger.log(LogStatus.FAIL,
					logger.addScreenCapture("http://localhost:8080\\job\\EaseMyTrip%20Flight\\com.easytripplanners.easemytrip$easemytripFlight\\ws\\screenshots\\"
							+ result.getMethod().getMethodName() + ".png"));
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, result.getName() + "  " + "Test Case Passed");
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}

		extent.endTest(logger);

	}

	@AfterTest
	public void endReport() {

		// flush() - to write or update test information to your report.
		extent.flush();

		extent.close();
	}

}
