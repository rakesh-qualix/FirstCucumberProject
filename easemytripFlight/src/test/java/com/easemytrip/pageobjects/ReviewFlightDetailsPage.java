package com.easemytrip.pageobjects;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.easemytrip.generic.WaitStatementLib;

public class ReviewFlightDetailsPage  {
	WebDriver driver;
//	@FindBy(xpath=("//input[@name='txtEmailId']"))
//	private WebElement emailId;
	@FindBy(xpath=("//div[@class='con-m']//input[@id='txtEmailId']"))
	private WebElement emailId;
	@FindBy(xpath=("//input[@id='txtCouponCode']"))
	private WebElement couponCode;
	@FindBy(xpath=("//div[@class='cancl']"))
	private WebElement clear;
	@FindBy(xpath=("//div[@class='apl']"))
	private WebElement applyBtn;
	@FindBy(xpath = ("//div[@class='con']/span[@ng-click='VerifyTravellerEmail()']"))
	private WebElement continueBtn;
	public ReviewFlightDetailsPage(WebDriver driver) {
		//super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}  // for initialization of WebElements.
	
	
	/*public void modifyAndSearch() throws Exception{
	if (modifyAndSearch.isDisplayed()) {
		modifyAndSearch.click();
		WaitStatementLib.iWait(2);
		selectingWays();
	}
	}*/
	public void enterEmail() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtEmailId")));
			wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@class='con-m']//input"))));
			Thread.sleep(3000);
			//emailId.click();
			emailId.sendKeys("tech@easemytrip.com");
			WaitStatementLib.iWait(2);
		} catch (Exception ae) {
			ae.printStackTrace();

		}

	}
	public void verfyingCouponCode(){
		Random randomCpn=new Random();
		List<String> givenList = Arrays.asList("EMTFLY", "EASEFLY","EMTFIRST", "EMTNCF", "EMT2018","EASEDAY","SALEDAY","EMTINT",
				"PARDES","VIDESH","FLYFAMILY","TRYBIZ");//note: easeday can applied only on vistaara,jetairways and AirIndia.
		
	        int randomIndex = randomCpn.nextInt(givenList.size());
	        System.out.println("Total number of available coupon code is: "+givenList.size());
	        String randomElement = givenList.get(randomIndex);
	        //String randomElement = givenList.get(12);
	        if(randomElement.trim().equalsIgnoreCase("EMTFIRST")){
	 			//System.out.println("Applied Coupon Code is: "+couponCode.getAttribute("value"));
	        	clear.click();
	 			couponCode.click();
	 			couponCode.sendKeys(randomElement);
	 			System.out.println("Applied Coupon Code is: "+couponCode.getAttribute("value"));
	 			applyBtn.click();
	 			loginRequiredForCoupon();
	        }
	 			else if(randomElement.trim().equalsIgnoreCase("EMTBANDHAN")){
	 				clear.click();
		 			couponCode.click();
		 			couponCode.sendKeys(randomElement);
		 			System.out.println("Applied Coupon Code is: "+couponCode.getAttribute("value"));
		 			applyBtn.click();
		 			loginRequiredForCoupon();
	 			}
	 				
	        
	        else
	        {
	        	System.out.println("Going to apply coupon code : "+randomElement);
	 	        clear.click();
	 			couponCode.click();
	 			couponCode.sendKeys(randomElement);
	 			System.out.println("Applied Coupon Code is: "+couponCode.getAttribute("value"));
	 			applyBtn.click();
	        }
	 			 
	 			//break; 
	    }
	 

	public void loginRequiredForCoupon(){
		WebElement LoginId = driver.findElement(By.xpath("//input[@id='log1']"));
		LoginId.click();
		WaitStatementLib.iWait(2);
		LoginId.sendKeys("9971997901");
		WaitStatementLib.iWait(2);
		WebElement password = driver.findElement(By.xpath("//input[@id='log2']"));
		password.click();
		WaitStatementLib.iWait(2);
		password.sendKeys("9971997901");
		WaitStatementLib.iWait(2);
		WebElement loginBtn = driver.findElement(By.xpath("//div[@class='lgn log_in_im3']"));
		loginBtn.click();
		WaitStatementLib.iWait(2);
		applyBtn.click();
		WaitStatementLib.iWait(2);
	}
	public void clickOnContinue() {

		try {
			WaitStatementLib.iWait(5);
			continueBtn.click();
			
			WaitStatementLib.iWait(10);
		} catch (Exception ae) {
			ae.printStackTrace();
		}

	}
}
