package com.easemytrip.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.easemytrip.generic.WaitStatementLib;

public class PaymentModePage {
	WebDriver driver;
	@FindBy(xpath = ("//div[@class='bor po-re']"))
	List<WebElement> travelersDetails;
	@FindBy(xpath = ("//div[@class='sidebar']"))
	WebElement priceSummary;
	@FindBy(xpath = ("//div[@class='pymnt-bx-lft']/div[position()>1]"))
	private List<WebElement> paymentMode;//TOTAL NUMBER OF PAYMENT OPTIONS ARE 7
	// Storing elements for Debit and credit cards
	@FindBy(xpath = ("//input[@id='CC']"))
	private WebElement cardNumbrer;
	@FindBy(xpath = ("//input[@id='CCN']"))
	private WebElement cardHolderName;
	@FindBy(xpath = ("//select[@id='CCMM']"))
	private WebElement expMonth;
	@FindBy(xpath = ("//select[@id='CCYYYY']"))
	private WebElement expYear;
	@FindBy(xpath = ("//input[@id='CCCVV']"))
	private WebElement cardCvvNumber;
	@FindBy(xpath = ("//div[@id='DivDebitCardPanel']//div[10][text()='Make Payment']"))
	private WebElement makePaymentForDCCard;
	// Storing WebElement and List<WebElement> for NetBanking
	@FindBy(xpath = ("//label[@id='rdoICIB'] "))
	private WebElement iciciBank;
	@FindBy(xpath = ("//div[@class='mk-pym3']"))
	private WebElement paymentBtnForNetbanking;
	// Icici Internet Banking Details
	@FindBy(xpath = ("//input[@id='AuthenticationFG.USER_PRINCIPAL']"))
	private WebElement userId;
	@FindBy(xpath = ("//input[@id='AuthenticationFG.ACCESS_CODE']"))
	private WebElement password;
	@FindBy(xpath = ("//input[@id='VALIDATE_CREDENTIALS1']"))
	private WebElement loginBtn;
	// Storing WebElements for MyWallet
	@FindBy(xpath=("//div[@class='radi-bt4']/div"))
	private List<WebElement> myWallet;
	@FindBy(xpath = ("//div[@class='mk-pym4']"))
	private WebElement walletMakePayment;
	//WebElements for Airtel Money Wallet
	
	@FindBy(xpath=("//input[@id='usernameInput']"))
	private WebElement MobileNumber;
	@FindBy(xpath=("//a[text()='LOGIN WITH OTP']"))
	private WebElement loginWithOTP;
	@FindBy(xpath=("//input[@id='mpinInput']"))
	private WebElement mPin;
	//@FindBy(xpath=("//button[text()='LOGIN']"))
	@FindBy(xpath=("//button[@class='btn btn-primary m-b-25']"))
	private WebElement airtelLoginBtn;
	@FindBy(xpath=("//button[text()='Load Money']"))
	private WebElement loadMoneyToAirtel;
	@FindBy(xpath=("//div[@class='form-wrapper']/div[2]/div/div/div/ul/li"))
	private List<WebElement> cards;
	@FindBy(xpath=("//input[@name='CCNumber']"))
	private WebElement HdfcCardNumber;
	@FindBy(xpath=("//input[@id='ccName']"))
	private WebElement hdfcCardHolderName;
	@FindBy(xpath=("//input[@name='expiryMonth']"))
	private List<WebElement> mm;
	@FindBy(xpath=("//input[@id='ccExpiryYear']"))
	private WebElement yyyy;
	@FindBy(xpath=("//input[@id='ccCvv']"))
	private WebElement enterCVV;
//	@FindBy(xpath=("//div[@class='col-md-12']/div/div/div[3]/form/div[2]/div/div/button"))
//	private WebElement pay;
	@FindBy(xpath=("//a[text()='Cancel']"))
	private WebElement cancelTransaction;
//	@FindBy(xpath=("//input[@id='txtOtpPassword']"))
//	private WebElement transactionPassword;
//	@FindBy(xpath=("//button[@id='cmdSubmit']"))
//	private WebElement submit;
	
	
	/*@FindBy(xpath = ("//img[@src='https://flight.easemytrip.com/Content/img/phonepe-w.png']"))
	private WebElement verifyTextForPhonePayWallet;
	@FindBy(xpath = ("//div[@class='mk-pym4']"))
	private WebElement walletMakePayment;
	@FindBy(xpath = ("//input[@id='mobileNumber']"))
	private WebElement mobileNumber;
	@FindBy(xpath = ("//button[text()='Send OTP']"))
	private WebElement sendOtpToMobile;*/
	// Storing WebElement for verifyTextForUPI payment
	@FindBy(xpath = ("//input[@id='txtUpi']"))
	private WebElement virtualAddressForverifyTextForUPI;
	@FindBy(xpath = ("//div[@class='pymnt-bx-rgt5']/div//div[5]"))
	private WebElement makePaymentForverifyTextForUPI;
	// Storing WebElement for verifyTextForPhonePay Option
	@FindBy(xpath = ("//span[@id='PhonePeBtn']"))
	private WebElement makePaymentForverifyTextForPhonePayOpt;
	// Storing WebElement for Bharat QR
	@FindBy(xpath = ("//div[@class='bor mar20 m-bt']/div[3]/div[8]/div[1]/div[3]"))
	private WebElement makePaymentForverifyTextForBharatQR;
	// Storing WebElement for EMI
	@FindBy(xpath = ("//select[@id='drpEMIBank']/option"))
	private List<WebElement> emiBankOptions;
	@FindBy(xpath = ("//input[@id='emi_opt_1']"))
	private WebElement emiPlan;
	@FindBy(xpath = ("//input[@id='CC1']"))
	private WebElement creditCardNo;
	@FindBy(xpath = ("//input[@id='CCN1']"))
	private WebElement creditCardHolderName;
	@FindBy(xpath = ("//select[@id='CCMM1']"))
	private WebElement creditCardExpiryMonth;
	@FindBy(xpath = ("//select[@id='CCYYYY1']"))
	private WebElement creditCardExpiryYear;
	@FindBy(xpath = ("//input[@id='CCCVV1']"))
	private WebElement credirCardCvvNo;
	@FindBy(xpath = ("//div[@class='mk-pym']"))
	private List<WebElement> creditCardMakePayment;
	// Storing WebElement for PhonePay transaction page
	@FindBy(xpath = ("//input[@id='mobileNumber']"))
	private WebElement mobileNumberForPhonePay;
	@FindBy(xpath = ("//button[@id='onboardingFormSubmitBtn']"))
	private WebElement sendBtn;
	@FindBy(xpath = ("//div[text()='Enter Your Card No.']"))
	// @FindBy(xpath=("//div[@class='inp-mnu']"))
	private WebElement verifyTextForDebitCreditCard;
	@FindBy(xpath = ("//div[text()='SELECT POPULAR BANKS']"))
	private WebElement verifyTextForNetBanking;
	@FindBy(xpath = ("//div[text()='SELECT YOUR WALLET']"))
	private WebElement verifyTextForMyWallet;
	@FindBy(xpath = ("//img[@alt='UPI Step']"))
	private WebElement verifyTextForUPI;
	@FindBy(xpath = ("//div[@class='upi-m']/div[3]//span[text()='0']"))
	private WebElement verifyTextForPhonePay;
	@FindBy(xpath = ("//div[@class='bharat-qr-visa']"))
	private WebElement verifyTextForBharatQR;
	@FindBy(xpath = ("html/body/form/div[9]/div[4]/div/div[3]/div[2]/div[3]/div[2]/div[3]/div[8]/div/div[3]/span"))
	private WebElement paymentBtnForBhQr;
	@FindBy(xpath = ("//div[text()='SELECT  BANKS']"))
	private WebElement verifyTextForEmi;
	// For click on cancel button when payment is going to made by Debit/credit
	// card
	@FindBy(xpath = ("//div[@id='buttons']/a[2]"))
	private WebElement cancelBtn;
	// getting text for convenience fees
	
	// Phone Pay login button
	@FindBy(xpath = ("//button[@id='onboardingFormSubmitBtn']"))
	private WebElement phonePayLoginBtn;
	// Phone Pay Card Webelement
	@FindBy(xpath = ("//input[@id='cardNumber']"))
	private WebElement emtHdfcCardNumber;
	@FindBy(xpath = ("//select[@id='selMonth']"))
	private WebElement month;
	@FindBy(xpath = ("//select[@id='selYear']"))
	private WebElement Year;
	// @FindBy(xpath=("//input[@id='cvvNumber']"))
	@FindBy(xpath = ("//input[@id='saved-card-cvv-0']"))
	private WebElement cvv;
	@FindBy(xpath = ("//button[@id='paySubmitButton']"))
	private WebElement payBtn;
	@FindBy(xpath = ("//input[@id='txtOtpPassword']"))
	private WebElement phonePayOtp;
	@FindBy(xpath = ("//button[@id='cmdSubmit']"))
	private WebElement phonePaySubmitBtn;
	//Storing WebElement for Paypal Payment option
	@FindBy(xpath=("//div[@class='paypal_btn']"))
	private WebElement paypalBtn;
	@FindBy(xpath=("//div[@class='pym']"))
	private WebElement verifyCurrency;
	@FindBy(xpath=("//input[@id='cc']"))
	private WebElement debitOrCreditCardNumber;
	@FindBy(xpath=("//input[@id='expiry_value']"))
	private WebElement expiryDate;
	@FindBy(xpath=("//input[@id='cvv']"))
	private WebElement cvvNumber;
	@FindBy(xpath=("//input[@id='firstName']"))
	private WebElement firstName;
	@FindBy(xpath=("//input[@id='lastName']"))
	private WebElement lastName;
	@FindBy(xpath=("//input[@id='telephone']"))
	private WebElement phoneNumber;
	@FindBy(xpath=("//input[@id='billingLine1']"))
	private WebElement billingAddress1;
	@FindBy(xpath=("//input[@id='billingLine2']"))
	private WebElement billingAddress2;
	@FindBy(xpath=("//input[@id='billingCity']"))
	private WebElement billingTownOrCity;
	@FindBy(xpath=("//select[@id='billingState']"))
	private WebElement billingState;
	@FindBy(xpath=("//input[@id='billingPostalCode']"))
	private WebElement postalCode;
	@FindBy(xpath=("//input[@id='email']"))
	private WebElement emailAddress;
	@FindBy(xpath=("//input[@id='password']"))
	private WebElement emailPassword;
	@FindBy(xpath=("//input[@id='dobText']"))
	private WebElement dateOfBirth;
	@FindBy(xpath=("//button[@id='guestSubmit']"))
	private WebElement agreeAndpayBtn;

	public PaymentModePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}// for initialization of WebElement

	public void fetchingTravelerDetails() {
		WaitStatementLib.iWait(2);
		String detailsOfTravelers = travelersDetails.get(1).getText();
		System.out.println("Entered Traveller Details are: " + detailsOfTravelers);
	}

	public void fetchingPrice() {
		WaitStatementLib.iWait(2);
		String totalPrice = priceSummary.getText();
		System.out.println("Total Fare calculated  is given Below :" + totalPrice);
	}

	public void selectingPaymentOptions() {
		WaitStatementLib.iWait(2);
		Random ra1 = new Random();
		@SuppressWarnings("unused")
		int rondomNumber1 = ra1.nextInt(paymentMode.size());
		
//		  WebElement NameOfPaymentMethod = paymentMode.get(4);//To check particular index{0,1,2,3,4,5,6} NameOfPaymentMethod.click();
//		System.out.println("Selected payment method is : "+NameOfPaymentMethod.getText());
		 
		//WebElement NameOfPaymentMethod = paymentMode.get(rondomNumber1);
		 WebElement NameOfPaymentMethod = paymentMode.get(9);
		WaitStatementLib.iWait(2);
		NameOfPaymentMethod.click();
		WaitStatementLib.iWait(2);
		System.out.println("Selected payment method is : " + NameOfPaymentMethod.getText());
		WaitStatementLib.iWait(1);
	}

	public void debitCardPayment() {
		cardNumbrer.click();
		cardNumbrer.sendKeys("5546232920724480");
		cardHolderName.click();
		cardHolderName.sendKeys("RAKESH KUMAR JHA");
		Select sel1 = new Select(expMonth);
		sel1.selectByValue("06");
		sel1 = new Select(expYear);
		sel1.selectByValue("2023");
		cardCvvNumber.sendKeys("854");
		// EMT card details
		/*
		 * cardNumbrer.sendKeys("5551530100013067"); cardHolderName.click();
		 * cardHolderName.sendKeys("Nishant Pitti"); Select sel1 = new
		 * Select(expMonth); sel1.selectByValue("05"); sel1 = new
		 * Select(expYear); sel1.selectByValue("2019");
		 * cardCvvNumber.sendKeys("531");
		 */
		makePaymentForDCCard.click();
		WaitStatementLib.iWait(5);
		/*
		 * driver.findElement(By.xpath("//a[@class='active submitotp']"
		 * )).click(); WaitStatementLib.iWait(3);
		 * driver.switchTo().alert().accept(); WaitStatementLib.iWait(20);
		 */
		// For commented card details
		cancelBtn.click();
		WaitStatementLib.iWait(10);
	}

	public void netBankingPayment() {
		iciciBank.click();
		WaitStatementLib.iWait(2);
		paymentBtnForNetbanking.click();
		WaitStatementLib.iWait(2);
		//userId.click();
		userId.sendKeys("RAKESHJHAJ06");
	//	password.click();
		password.sendKeys("EASEMYTRIP@2018");
		// WaitStatementLib.eWaitForVisibility(driver, 10, loginBtn);
		loginBtn.click();
		WaitStatementLib.iWait(5);
		// Handling browser popup
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		// String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		// perform actions on child windo
		driver.close(); // only for child wondow
	}

	public void walletPayment() {
		try{
			WaitStatementLib.iWait(2);
		myWallet.get(3).click();
		WaitStatementLib.iWait(5);
		walletMakePayment.click();
		WaitStatementLib.iWait(3);
		MobileNumber.click();
		WaitStatementLib.iWait(2);
		MobileNumber.sendKeys("9971997901");
		WaitStatementLib.iWait(2);
		loginWithOTP.click();
		WaitStatementLib.iWait(10);
		//mPin.click();
		//WaitStatementLib.iWait(1);
		airtelLoginBtn.click();
		//WaitStatementLib.iWait(2);
		loadMoneyToAirtel.click();
		WaitStatementLib.iWait(5);
		WebElement creditCards = cards.get(2);
		creditCards.click();
		//WaitStatementLib.iWait(5);
		HdfcCardNumber.sendKeys("5172526824902139");
		hdfcCardHolderName.sendKeys("Rakesh Kumar Jha");
		WebElement expMon = mm.get(1);
		expMon.sendKeys("04");
		yyyy.sendKeys("2022");
		enterCVV.sendKeys("350");
		WaitStatementLib.iWait(10);
		WebElement pay= driver.findElement(By.xpath("//div[@class='col-md-12']/div/div/div[3]/form/div[2]/div/div/button"));

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].removeAttribute('disabled','disabled')",pay);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(pay));

		pay.click();
		//WaitStatementLib.iWait(5);
		//transactionPassword.click();
		//submit.click();
		WaitStatementLib.iWait(10);
		cancelTransaction.click();
		driver.switchTo().alert().accept();
		WaitStatementLib.iWait(5);
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		
		
		
		/*verifyTextForPhonePayWallet.click();
		WaitStatementLib.iWait(2);
		walletMakePayment.click();
		WaitStatementLib.iWait(2);
		mobileNumber.click();
		mobileNumber.sendKeys("9971997901");
		WaitStatementLib.iWait(10);
		sendOtpToMobile.click();*/
	}

	public void uPIPayment() {
		virtualAddressForverifyTextForUPI.click();
		virtualAddressForverifyTextForUPI.sendKeys("Rakeshkj@ICICI");
		makePaymentForverifyTextForUPI.click();
	}

	public void phonePayOptionPayment() {
		// Enable code for saved card only
		makePaymentForverifyTextForPhonePayOpt.click();
		WaitStatementLib.iWait(5);
		/*
		 * mobileNumberForPhonePay.click(); WaitStatementLib.iWait(2);
		 * mobileNumberForPhonePay.clear(); WaitStatementLib.iWait(2);
		 * mobileNumberForPhonePay.sendKeys("9971997901");
		 * WaitStatementLib.iWait(2);
		 */
		sendBtn.click();
		// WaitStatementLib.iWait(20);
		phonePayLoginBtn.click();
		/*
		 * emtHdfcCardNumber.click();
		 * emtHdfcCardNumber.sendKeys("5551530100013067"); Select sel3 = new
		 * Select(month); sel3.selectByValue("05"); Select sel4 = new
		 * Select(expYear); sel4.selectByValue("2019");
		 */
		cvv.click();
		cvv.sendKeys("531");
		payBtn.click();
		WaitStatementLib.iWait(3);
		phonePayOtp.click();
		WaitStatementLib.iWait(10);
		phonePaySubmitBtn.click();
	}

	public void bharatQRPayment() {
		// WebElement makePaymentBtn = paymentBtnForBhQr.get(1);
		// makePaymentBtn.click();
		paymentBtnForBhQr.click();
		WaitStatementLib.iWait(2);
		System.out.println("clicked on payment button....");
	}

	public void emiPayment() {
		WebElement bankName = emiBankOptions.get(1);
		bankName.click();
		WaitStatementLib.iWait(2);
		emiPlan.click();
		creditCardNo.click();
		creditCardNo.sendKeys("4375514558134002");
		creditCardHolderName.click();
		creditCardHolderName.sendKeys("Rakesh Kumar Jha");
		Select sel2 = new Select(creditCardExpiryMonth);
		sel2.selectByVisibleText("09");
		sel2 = new Select(creditCardExpiryYear);
		sel2.selectByVisibleText("2020");
		credirCardCvvNo.click();
		credirCardCvvNo.sendKeys("144");
		WaitStatementLib.iWait(5);
		creditCardMakePayment.get(1).click();
		WaitStatementLib.iWait(20);
		driver.navigate().back();
	}
	
	public void payPalPayment(){
		paypalBtn.click();
		WaitStatementLib.iWait(10);
		debitOrCreditCardNumber.sendKeys("4143661824007701");
		expiryDate.sendKeys("0822");
		cvvNumber.sendKeys("817");
		WaitStatementLib.iWait(3);
		firstName.clear();
		firstName.sendKeys("Rakesh Kumar");
		lastName.clear();
		lastName.sendKeys("Jha");
		phoneNumber.click();
		phoneNumber.sendKeys("9971997901");
		WaitStatementLib.iWait(2);
		billingAddress1.click();
		billingAddress1.sendKeys("223");
		billingAddress2.click();
		billingAddress2.sendKeys("Easy Trip Planners Pvt Ltd");
		billingTownOrCity.sendKeys("Patparganj");
		/*Select selState=new Select(billingState);
		selState.getOptions().get(9);*/
		billingState.sendKeys("Delhi");
		postalCode.click();
		postalCode.sendKeys("110092");
		emailAddress.clear();
		emailAddress.sendKeys("rakesh.emt052018@gmail.com");
		emailPassword.click();
		emailPassword.sendKeys("rakeshjha1990");
		dateOfBirth.sendKeys("05071990");
		agreeAndpayBtn.click();
		WaitStatementLib.iWait(3);
		//driver.navigate().back();
		WaitStatementLib.iWait(10);
	}

	public boolean isDebitCard(WebElement verifyTextForDebitCreditCard) {

		try {
			WaitStatementLib.iWait(5);
			if (verifyTextForDebitCreditCard.isDisplayed()) {
				// WaitStatementLib.iWait(5);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public boolean isInternetBanking(WebElement verifyTextForNetBanking) {

		try {
			if (verifyTextForNetBanking.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public boolean isWallet(WebElement verifyTextForMyWallet) {

		try {
			if (verifyTextForMyWallet.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public boolean isUpi(WebElement verifyTextForUPI) {

		try {
			if (verifyTextForUPI.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public boolean isQR(WebElement verifyTextForBharatQR) {

		try {
			if (verifyTextForBharatQR.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public boolean isEmi(WebElement verifyTextForEmi) {

		try {
			if (verifyTextForEmi.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}
	public boolean isPayPalPayment(WebElement verifyCurrency){
		try{
			if(verifyCurrency.isDisplayed()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}

	public void findingClickedPaymentOption() {
		WaitStatementLib.iWait(5);
		if (isDebitCard(verifyTextForDebitCreditCard)) {
			// if (verifyTextForDebitCreditCard.isDisplayed()) {
			System.out.println("Going to enter Debit card details:");
			debitCardPayment();
		} else if (isInternetBanking(verifyTextForNetBanking)) {
			System.out.println("Going to enter internet banking details:");
			netBankingPayment();
		} else if (isWallet(verifyTextForMyWallet)) {
			System.out.println("Going to enter Wallet details:");
			walletPayment();
		} else if (isUpi(verifyTextForUPI)) {
			System.out.println("Going to enter verifyTextForUPI details:");
			uPIPayment();
		}

		else if (isQR(verifyTextForBharatQR)) {
			System.out.println("Going to enter verifyTextForBharatQR details:");
			bharatQRPayment();
		} else if (isEmi(verifyTextForEmi)) {
			emiPayment();
		}
		else if(isPayPalPayment(verifyCurrency)){
			System.out.println("Going to make Payment through Paypal");
			payPalPayment();
		}
		else  {
			System.out.println("Going to enter verifyTextForPhonePay details:");
			phonePayOptionPayment();
		}

	}
}
