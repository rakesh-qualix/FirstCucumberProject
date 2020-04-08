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


public class MulticitySearchPage {
	WebDriver driver;
	//private String today;
	@FindBy(xpath=("//span[@class='checkmark']"))
	private WebElement multicityChkBx;
	/*@FindBy(xpath=(" //input[@id='optInfantMul']"))
	private WebElement noOfInfants;
	@FindBy(xpath=("//a[@class='dropbtn_n']"))
	private List<WebElement> clickOnTraveller;*/
	@FindBy(xpath=("//input[@id='FromSector-mul1_show']"))
	private WebElement deptCity1;
	@FindBy(xpath=("//input[@id='ToSector-mul1_show']"))
	private WebElement destCity1;
	@FindBy(xpath=("//input[@id='ToSector-mul2_show']"))
	private WebElement typeDestCity;
	
	@FindBy(xpath=("//input[@id='ddateMul1']"))
	private WebElement date1;
	@FindBy(xpath=("//span[text()='Next']"))
	private WebElement nextArrow;
	@FindBy(xpath=("//div[@class='ui-datepicker-title']"))
	private WebElement monthYearTitle;
	//==========================================
	@FindBy(xpath=("//input[@id='FromSector-mul2_show']"))
	private WebElement deptCity2;
	@FindBy(xpath=("//input[@id='ToSector-mul2_show']"))
	private WebElement destCity2;
	@FindBy(xpath=("//input[@id='ddateMul2']"))
	private WebElement date2;
	@FindBy(xpath=("//div[@class='mobile-wi1-multi mul-sho']/div[1]//div[@id='search']"))
	private WebElement searchBtn;
	public MulticitySearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}	
	public void searchingMulticityWay(){
		//WaitStatementLib.eWaitForVisibility(driver, 5, multicityChkBx);
		WaitStatementLib.iWait(2);
		multicityChkBx.click();
		/*WaitStatementLib.iWait(5);
		WebElement traveller = clickOnTraveller.get(1);
		traveller.click();
		WaitStatementLib.iWait(5);*/
		
	}
	public void deptCity(){
		//WaitStatementLib.eWaitForVisibility(driver, 5, deptCity1);
		deptCity1.click();
		WaitStatementLib.iWait(5);
		//WaitStatementLib.eWaitForVisibility(driver, 2, deptCity1);
		List<WebElement> deptCityOne = driver.findElements(By.xpath("//div[@id='FromMulti1']/div[2]/div/ul/li"));
		Random mulcity = new Random();
		int sizeOfDeptCity1 = mulcity.nextInt(deptCityOne.size());
		WaitStatementLib.iWait(2);
		deptCityOne.get(sizeOfDeptCity1).click();
		WaitStatementLib.iWait(2);
		
	}
	public void destCity(){
		//WaitStatementLib.eWaitForVisibility(driver, 5, destCity1);
		destCity1.click();
		WaitStatementLib.iWait(5);
		//WaitStatementLib.eWaitForVisibility(driver, 2, destCity1);
		List<WebElement> destCityOne = driver.findElements(By.xpath("//div[@id='ToMulti1']/div/div/ul/li"));
		WaitStatementLib.iWait(2);
		Random mulcityDest = new Random();
		int sizeOfDestCity1 = mulcityDest.nextInt(destCityOne.size());
		WaitStatementLib.iWait(2);
		destCityOne.get(sizeOfDestCity1).click();
	}
	public void destCity2(){
		//WaitStatementLib.eWaitForVisibility(driver, 5, typeDestCity);
		typeDestCity.click();
		WaitStatementLib.iWait(5);
		List<WebElement> typeDestCity2 = driver.findElements(By.xpath("//div[@id='ToMulti2']/div/div/ul/li"));
		WaitStatementLib.iWait(2);
		Random mulcityDest2 = new Random();
		int sizeOfDestCity2 = mulcityDest2.nextInt(typeDestCity2.size());
		WaitStatementLib.iWait(2);
		typeDestCity2.get(sizeOfDestCity2).click();
	}
	
	public void pickingDate1(){
		//WaitStatementLib.eWaitForVisibility(driver, 5, date1);
		//Clicking on calendar to open calendar widget
		try
		{
			date1.click();
		nextArrow.click();
		WaitStatementLib.iWait(2);
	//	List<WebElement> storingDate = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr"));//xpath for row
		List<WebElement> storingDate = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));//xpath for column
		
		for (WebElement cell: storingDate) {
            
            //If you want to click 27th Date
            if (cell.getText().trim().equals("5")) {
            	 cell.click();
                 break;     
		}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		public void pickingDate2(){
		
			//Clicking on calendar to open calendar widget
			try{
				date2.click();
				WaitStatementLib.iWait(2);
		
				List<WebElement> storingDate1 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));//xpath for column
				
				for (WebElement cell1: storingDate1) {
		            
		            //If you want to click 27th Date
		            if (cell1.getText().trim().equals("27")) {
		            	 cell1.click();
		                 break;

		            }
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
	   
	}
		public void mulCityFlightSearchBtn(){
			searchBtn.click();
			//driver.manage().deleteAllCookies();
			WaitStatementLib.iWait(3);
		}
		public boolean isAlertPresent() {
			try {
				Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
				
				if (a != null) {
					System.out.println("Alert is present");
					driver.switchTo().alert().accept();
					deptCity();
					destCity();
					destCity2();
					
					//WaitStatementLib.iWait(3);
					mulCityFlightSearchBtn();
				
					return true;
				} 
			} catch (Throwable e) {
				System.err.println("Alert isn't present!!");
				return false;
			}
			return false;

		}
}


