package com.easemytrip.pageobjects;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.easemytrip.generic.WaitStatementLib;

public class TravellerDetailsPage {
	WebDriver driver;
	// List<WebElement> travellers;
	@FindBy(xpath = ("//*[contains(@id,'titleAdult')]"))
	List<WebElement> adultTitle;
	@FindBy(xpath = ("//*[contains(@id,'txtFNAdult')]"))
	List<WebElement> adultFirstName;
	@FindBy(xpath = ("//*[contains(@id,'txtLNAdult')]"))
	List<WebElement> adultLastName;
	@FindBy(xpath = ("//*[contains(@id,'titleChild')]"))
	List<WebElement> childTitle;
	@FindBy(xpath = ("//*[contains(@id,'txtFNChild')]"))
	List<WebElement> childFirstName;
	@FindBy(xpath = ("//*[contains(@id,'txtLNChild')]"))
	List<WebElement> childLastName;
	@FindBy(xpath = ("//*[contains(@id,'titleInfant')]"))
	List<WebElement> infantTitle;
	@FindBy(xpath = ("//*[contains(@id,'txtFNInfant')]"))
	List<WebElement> infantFirstName;
	@FindBy(xpath = ("//*[contains(@id,'txtLNInfant')]"))
	List<WebElement> infantLastName;
	// Xpath for International Flight only
	@FindBy(xpath = ("//*[contains(@id,'divDOBAdult')]"))
	List<WebElement> dateOfBirth;
	@FindBy(xpath = ("//*[contains(@id,'divDOBChild')]"))
	List<WebElement> childDateOfBirth;
	@FindBy(xpath = ("//*[contains(@id,'txtPassAdult')]"))
	List<WebElement> passportNumber;
	@FindBy(xpath = ("//*[contains(@id,'txtPassChild')]"))
	List<WebElement> childPassportNumber;
	@FindBy(xpath = ("//*[contains(@class,'dobn')]"))
	List<WebElement> passportExpiryDate;
	@FindBy(xpath = ("//*[contains(@id,'divDOBInfant')]"))
	List<WebElement> infantDob;
	@FindBy(xpath = ("//*[contains(@id,'txtPassInfant')]"))
	List<WebElement> infantPassportNumber;
	@FindBy(xpath = ("//input[@id='txtCPhone']"))
	private WebElement contactDetails;
	@FindBy(xpath = ("//div[@class='con1']/span"))
	private WebElement continueBtn;
	@FindBy(xpath=("//div[@class='bg_si_d ng-scope']"))
	WebElement domesticFlight;
    @FindBy(xpath=("//div[@class='bg_si_d2 ng-scope']"))
	//@FindBy(xpath=("//div[@ng-if='isDomestic==false']"))
    WebElement internationalFlight;
	public TravellerDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	boolean isDomestic(WebElement domesticFlight){
		
		try{
			
			if(domesticFlight.isDisplayed())
			
				return true;
		}catch(Exception e){
			e.printStackTrace();
				
		}
		
		return false;	
	}
	/*boolean isInternational(WebElement internationalFlight){
		try{
			if(internationalFlight.isDisplayed())
				return true;
		}
		catch(Exception e){
		e.printStackTrace();
		
		}
		return false;
	}*/
	public void travellersDetails() {
		int sizeOfTravellers = adultTitle.size(); 
		System.out.println("Size of the  Adults travellers are: " + sizeOfTravellers);
		List<String> firstNamelist = new ArrayList<String>();
		firstNamelist.add("Rakesh");
		firstNamelist.add("Rajiv");
		firstNamelist.add("Ramesh");
		firstNamelist.add("Ragesh");
		firstNamelist.add("Kamal");
		firstNamelist.add("Kaushal");
		firstNamelist.add("Umesh");
		firstNamelist.add("Rishab");
		firstNamelist.add("Pappu");
		List<String> lastNamelist = new ArrayList<String>();
		lastNamelist.add("Jha");
		lastNamelist.add("Sharma");
		lastNamelist.add("Singh");
		lastNamelist.add("Roy");
		lastNamelist.add("Kriplani");
		lastNamelist.add("Arora");
		lastNamelist.add("Mishra");
		lastNamelist.add("Singh");
		lastNamelist.add("Gaur");
		for (int i = 0; i < sizeOfTravellers; i++) {
			//if(domesticFlight.getText().trim().equalsIgnoreCase("Name should be same as in Goverment ID proof")){
			if(isDomestic(domesticFlight)){
			adultTitle.get(i).sendKeys("MR");
			adultFirstName.get(i).sendKeys(firstNamelist.get(i));
			adultLastName.get(i).sendKeys(lastNamelist.get(i));
			
			}
			//else if(internationalFlight.getText().trim().equalsIgnoreCase("Name should be same as in Passport")){
			else {
				adultTitle.get(i).sendKeys("MR");
				adultFirstName.get(i).sendKeys(firstNamelist.get(i));
				adultLastName.get(i).sendKeys(lastNamelist.get(i));	
				if (dateOfBirth.size() != 0 && passportNumber.size() != 0 && passportExpiryDate.size() != 0) {
					dateOfBirth(i);
					passportNumber(i);
					passportExpiryDate(i);
				} else if (dateOfBirth.size() != 0 && passportNumber.size() != 0 && passportExpiryDate.size() == 0) {
					dateOfBirth(i);
					passportNumber(i);
				} else if (dateOfBirth.size() != 0 && passportNumber.size() == 0 && passportExpiryDate.size() == 0) {
					dateOfBirth(i);
				} else if (dateOfBirth.size() == 0 && passportNumber.size() != 0 && passportExpiryDate.size() == 0) {
					passportNumber(i);
				} else if (dateOfBirth.size() == 0 && passportNumber.size() != 0 && passportExpiryDate.size() != 0) {
					passportNumber(i);
					passportExpiryDate(i);
				}
			}
			
		
		}
		
		int sizeOfChildTravellers = childTitle.size();//Size For Child Passengers
		System.out.println("Size of Child traveller are: " + sizeOfChildTravellers);
		List<String> childFirstNamelist = new ArrayList<String>();
		childFirstNamelist.add("Raju");
		childFirstNamelist.add("Raman");
		childFirstNamelist.add("Sonu");
		childFirstNamelist.add("Sumit");
		childFirstNamelist.add("Kamlesh");
		childFirstNamelist.add("Suman");
		childFirstNamelist.add("Uma");
		childFirstNamelist.add("Sudhir");
		childFirstNamelist.add("Pushpendra");
		List<String> childLastNamelist = new ArrayList<String>();
		childLastNamelist.add("Tiwari");
		childLastNamelist.add("Soni");
		childLastNamelist.add("Agarwal");
		childLastNamelist.add("Rai");
		childLastNamelist.add("Suri");
		childLastNamelist.add("Yadav");
		childLastNamelist.add("Menon");
		childLastNamelist.add("Singh");
		childLastNamelist.add("Kaur");
		for (int j = 0; j < sizeOfChildTravellers; j++) {
			if(isDomestic(domesticFlight)){
			childTitle.get(j).sendKeys("Master");
			childFirstName.get(j).sendKeys(childFirstNamelist.get(j));
			childLastName.get(j).sendKeys(childLastNamelist.get(j));
			
			}
			else{
				childTitle.get(j).sendKeys("Master");
				childFirstName.get(j).sendKeys(childFirstNamelist.get(j));
				childLastName.get(j).sendKeys(childLastNamelist.get(j));
				if (childDateOfBirth.size() != 0 && childPassportNumber.size() != 0 && passportExpiryDate.size() != 0) {
					childDateOfBirth(j);
					childPassportNumber(j);
					childPassportExpiryDate(j);
				} else if (childDateOfBirth.size() != 0 && childPassportNumber.size() != 0
						&& passportExpiryDate.size() == 0) {
					childDateOfBirth(j);
					childPassportNumber(j);
				} else if (childDateOfBirth.size() != 0 && childPassportNumber.size() == 0
						&& passportExpiryDate.size() == 0) {
					childPassportNumber(j);
				} else if (childDateOfBirth.size() == 0 && childPassportNumber.size() != 0
						&& passportExpiryDate.size() == 0) {
					childPassportNumber(j);
				} else if (childDateOfBirth.size() == 0 && childPassportNumber.size() != 0
						&& passportExpiryDate.size() != 0) {
					childPassportNumber(j);
					childPassportExpiryDate(j);
				}
			}
			 
		}
		int sizeOfInfantTravellers = infantTitle.size();//Size of Infant Passengers
		System.out.println("Size of Infant traveller are: " + sizeOfInfantTravellers);
		List<String> infantFirstNamelist = new ArrayList<String>();
		infantFirstNamelist.add("Subham");
		infantFirstNamelist.add("Shivam");
		infantFirstNamelist.add("Hrithik");
		infantFirstNamelist.add("Manish");
		infantFirstNamelist.add("Golu");
		infantFirstNamelist.add("Sumesh");
		infantFirstNamelist.add("Amit");
		infantFirstNamelist.add("Rabish");
		infantFirstNamelist.add("Pulkit");
		List<String> infantLastNamelist = new ArrayList<String>();
		infantLastNamelist.add("Sharma");
		infantLastNamelist.add("yadav");
		infantLastNamelist.add("Jha");
		infantLastNamelist.add("Mishra");
		infantLastNamelist.add("Thakur");
		infantLastNamelist.add("Choudhary");
		infantLastNamelist.add("Pathak");
		infantLastNamelist.add("Singh");
		infantLastNamelist.add("Banerjee");
		for (int k = 0; k < sizeOfInfantTravellers; k++) {
			if(isDomestic(domesticFlight)){
			infantTitle.get(k).sendKeys("Master");
			infantFirstName.get(k).sendKeys(infantFirstNamelist.get(k));
			infantLastName.get(k).sendKeys(infantLastNamelist.get(k));
			infantDateOfBirth(k);
			}
			else{
				infantTitle.get(k).sendKeys("Master");
				infantFirstName.get(k).sendKeys(infantFirstNamelist.get(k));
				infantLastName.get(k).sendKeys(infantLastNamelist.get(k));
				if (infantDob.size() != 0 && infantPassportNumber.size() != 0 && passportExpiryDate.size() != 0) {
					infantDateOfBirth(k);
					infantPassportNumber(k);
					infantPassportExpiryDate(k);
				} else if (infantDob.size() != 0 && infantPassportNumber.size() != 0 && passportExpiryDate.size() == 0) {
					infantDateOfBirth(k);
					infantPassportNumber(k);
				} else if (infantDob.size() != 0 && infantPassportNumber.size() == 0 && passportExpiryDate.size() == 0) {
					infantDateOfBirth(k);
				} else if (infantDob.size() == 0 && infantPassportNumber.size() != 0 && passportExpiryDate.size() == 0) {
					infantPassportNumber(k);
				} else if (infantDob.size() == 0 && infantPassportNumber.size() != 0 && passportExpiryDate.size() != 0) {
					infantPassportNumber(k);
					infantPassportExpiryDate(k);
				}
			}
			}
			
	}
	
	//Date Of Birth for Adult Passengers
	public void dateOfBirth(int count) {
		// Array for Day
		List<String> listForDOBDay = new ArrayList<String>();
		listForDOBDay.add("5");
		listForDOBDay.add("19");
		listForDOBDay.add("23");
		listForDOBDay.add("13");
		listForDOBDay.add("9");
		listForDOBDay.add("29");
		listForDOBDay.add("25");
		listForDOBDay.add("11");
		listForDOBDay.add("21");
		// Array for month
		List<String> listForDOBMon = new ArrayList<String>();
		listForDOBMon.add("Mar");
		listForDOBMon.add("May");
		listForDOBMon.add("Feb");
		listForDOBMon.add("Jul");
		listForDOBMon.add("Aug");
		listForDOBMon.add("Oct");
		listForDOBMon.add("Nov");
		listForDOBMon.add("Jan");
		listForDOBMon.add("Dec");
		// Array for Year
		List<String> listForDOBYear = new ArrayList<String>();
		listForDOBYear.add("1993");
		listForDOBYear.add("1996");
		listForDOBYear.add("2003");
		listForDOBYear.add("1983");
		listForDOBYear.add("1999");
		listForDOBYear.add("1992");
		listForDOBYear.add("1997");
		listForDOBYear.add("1984");
		listForDOBYear.add("1981");
		List<WebElement> sendingDobDay = driver.findElements(By.xpath("//*[contains(@id,'divDOBDayAdult')]"));
		sendingDobDay.get(count).sendKeys(listForDOBDay.get(count));
		List<WebElement> sendingDobMon = driver.findElements(By.xpath("//*[contains(@id,'divDOBMonAdult')]"));
		sendingDobMon.get(count).sendKeys(listForDOBMon.get(count));
		List<WebElement> sendingDobYear = driver.findElements(By.xpath("//*[contains(@id,'divDOBYarAdult')]"));
		sendingDobYear.get(count).sendKeys(listForDOBYear.get(count));
	}
	
	//Date Of Birth for Child Passengers
	public void childDateOfBirth(int childDobCount) {
		// Array for Day
		List<String> listForChildDOBDay = new ArrayList<String>();
		listForChildDOBDay.add("5");
		listForChildDOBDay.add("19");
		listForChildDOBDay.add("23");
		listForChildDOBDay.add("13");
		listForChildDOBDay.add("9");
		listForChildDOBDay.add("29");
		listForChildDOBDay.add("25");
		listForChildDOBDay.add("11");
		listForChildDOBDay.add("21");
		// Array for month
		List<String> listForChildDOBMon = new ArrayList<String>();
		listForChildDOBMon.add("Mar");
		listForChildDOBMon.add("May");
		listForChildDOBMon.add("Feb");
		listForChildDOBMon.add("Jul");
		listForChildDOBMon.add("Aug");
		listForChildDOBMon.add("Oct");
		listForChildDOBMon.add("Nov");
		listForChildDOBMon.add("Jan");
		listForChildDOBMon.add("Dec");
		// Array for Year
		List<String> listForChildDOBYear = new ArrayList<String>();
		listForChildDOBYear.add("2016");
		listForChildDOBYear.add("2006");
		listForChildDOBYear.add("2009");
		listForChildDOBYear.add("2011");
		listForChildDOBYear.add("2014");
		listForChildDOBYear.add("2008");
		listForChildDOBYear.add("2015");
		listForChildDOBYear.add("2012");
		listForChildDOBYear.add("2007");
		List<WebElement> sendingChildDobDay = driver.findElements(By.xpath("//*[contains(@id,'divDOBDayChild')]"));
		sendingChildDobDay.get(childDobCount).sendKeys(listForChildDOBDay.get(childDobCount));
		List<WebElement> sendingChildDobMon = driver.findElements(By.xpath("//*[contains(@id,'divDOBMonChild')]"));
		sendingChildDobMon.get(childDobCount).sendKeys(listForChildDOBMon.get(childDobCount));
		List<WebElement> sendingChildDobYear = driver.findElements(By.xpath("//*[contains(@id,'divDOBYarChild')]"));
		sendingChildDobYear.get(childDobCount).sendKeys(listForChildDOBYear.get(childDobCount));
	}
	
	//Date Of Birth for Infant Passengers
	public void infantDateOfBirth(int infantDateOfBirthCount) {
		// Array for Day
		List<String> listForInfantDOBDay = new ArrayList<String>();
		listForInfantDOBDay.add("5");
		listForInfantDOBDay.add("19");
		listForInfantDOBDay.add("23");
		listForInfantDOBDay.add("13");
		listForInfantDOBDay.add("9");
		listForInfantDOBDay.add("29");
		listForInfantDOBDay.add("25");
		listForInfantDOBDay.add("11");
		listForInfantDOBDay.add("21");
		// Array for month
		List<String> listForInfantDOBMon = new ArrayList<String>();
		listForInfantDOBMon.add("Mar");
		listForInfantDOBMon.add("May");
		listForInfantDOBMon.add("Feb");
		listForInfantDOBMon.add("Jul");
		listForInfantDOBMon.add("Aug");
		listForInfantDOBMon.add("Oct");
		listForInfantDOBMon.add("Nov");
		listForInfantDOBMon.add("Jan");
		listForInfantDOBMon.add("Dec");
		// Array for Year
		List<String> listForInfantDOBYear = new ArrayList<String>();
		listForInfantDOBYear.add("2018");
		listForInfantDOBYear.add("2017");
		listForInfantDOBYear.add("2017");
		listForInfantDOBYear.add("2018");
		listForInfantDOBYear.add("2018");
		listForInfantDOBYear.add("2017");
		listForInfantDOBYear.add("2017");
		listForInfantDOBYear.add("2017");
		listForInfantDOBYear.add("2018");
		List<WebElement> sendingInfantDobDay = driver.findElements(By.xpath("//*[contains(@id,'divDOBDayInfant')]"));
		sendingInfantDobDay.get(infantDateOfBirthCount).sendKeys(listForInfantDOBDay.get(infantDateOfBirthCount));
		List<WebElement> sendingInfantDobMon = driver.findElements(By.xpath("//*[contains(@id,'divDOBMonInfant')]"));
		sendingInfantDobMon.get(infantDateOfBirthCount).sendKeys(listForInfantDOBMon.get(infantDateOfBirthCount));
		List<WebElement> sendingInfantDobYear = driver.findElements(By.xpath("//*[contains(@id,'divDOBYarInfant')]"));
		sendingInfantDobYear.get(infantDateOfBirthCount).sendKeys(listForInfantDOBYear.get(infantDateOfBirthCount));
	}
	
	//Passport Number for Adult Passenger
	public void passportNumber(int count) {
		List<String> listForPassportNumber = new ArrayList<String>();
		listForPassportNumber.add("J8369854");
		listForPassportNumber.add("M8785654");
		listForPassportNumber.add("P7769854");
		listForPassportNumber.add("N4369854");
		listForPassportNumber.add("K6369854");
		listForPassportNumber.add("Z18369854");
		listForPassportNumber.add("B3369854");
		listForPassportNumber.add("I9369854");
		listForPassportNumber.add("G1369854");
		passportNumber.get(count).sendKeys(listForPassportNumber.get(count));
	}
	
	//Passport Number for Child Passengers
	public void childPassportNumber(int childPassportNumbercount) {
		List<String> listForChildPassportNumber = new ArrayList<String>();
		listForChildPassportNumber.add("J8369854");
		listForChildPassportNumber.add("M8785654");
		listForChildPassportNumber.add("P7769854");
		listForChildPassportNumber.add("N4369854");
		listForChildPassportNumber.add("K6369854");
		listForChildPassportNumber.add("Z18369854");
		listForChildPassportNumber.add("B3369854");
		listForChildPassportNumber.add("I9369854");
		listForChildPassportNumber.add("G1369854");
		childPassportNumber.get(childPassportNumbercount)
				.sendKeys(listForChildPassportNumber.get(childPassportNumbercount));
	}
	
	//Passport Number for Infant Passengers
	public void infantPassportNumber(int infantPassportNumbercount) {
		List<String> listForInfantPassportNumber = new ArrayList<String>();
		listForInfantPassportNumber.add("J8369854");
		listForInfantPassportNumber.add("M8785654");
		listForInfantPassportNumber.add("P7769854");
		listForInfantPassportNumber.add("N4369854");
		listForInfantPassportNumber.add("K6369854");
		listForInfantPassportNumber.add("Z18369854");
		listForInfantPassportNumber.add("B3369854");
		listForInfantPassportNumber.add("I9369854");
		listForInfantPassportNumber.add("G1369854");
		infantPassportNumber.get(infantPassportNumbercount)
				.sendKeys(listForInfantPassportNumber.get(infantPassportNumbercount));
	}
	
	// Passport Expiry Date for Adult Passengers
	public void passportExpiryDate(int count) {
		List<String> listForPassportExpDay = new ArrayList<String>();
		listForPassportExpDay.add("25");
		listForPassportExpDay.add("17");
		listForPassportExpDay.add("27");
		listForPassportExpDay.add("31");
		listForPassportExpDay.add("8");
		listForPassportExpDay.add("19");
		listForPassportExpDay.add("23");
		listForPassportExpDay.add("30");
		listForPassportExpDay.add("13");
		listForPassportExpDay.add("28");
		List<String> listForPassportExpMon = new ArrayList<String>();
		listForPassportExpMon.add("Mar");
		listForPassportExpMon.add("May");
		listForPassportExpMon.add("Feb");
		listForPassportExpMon.add("Jul");
		listForPassportExpMon.add("Aug");
		listForPassportExpMon.add("Jul");
		listForPassportExpMon.add("Feb");
		listForPassportExpMon.add("May");
		listForPassportExpMon.add("Feb");
		List<String> listForPassportExpYear = new ArrayList<String>();
		listForPassportExpYear.add("2019");
		listForPassportExpYear.add("2021");
		listForPassportExpYear.add("2020");
		listForPassportExpYear.add("2026");
		listForPassportExpYear.add("2023");
		listForPassportExpYear.add("2021");
		listForPassportExpYear.add("2025");
		listForPassportExpYear.add("2021");
		listForPassportExpYear.add("2023");
		List<WebElement> sendingExpDay = driver.findElements(By.xpath("//*[contains(@id,'passEXDayAdult')]"));
		sendingExpDay.get(count).sendKeys(listForPassportExpDay.get(count));
		List<WebElement> sendingExpMon = driver.findElements(By.xpath("//*[contains(@id,'passEXMonAdult')]"));
		sendingExpMon.get(count).sendKeys(listForPassportExpMon.get(count));
		List<WebElement> sendingExpYear = driver.findElements(By.xpath("//*[contains(@id,'passEXYearAdult')]"));
		sendingExpYear.get(count).sendKeys(listForPassportExpYear.get(count));

	}
	
	//Passport Expiry date for Child Passengers
	
	public void childPassportExpiryDate(int childPassportExpDateCount) {
		List<String> listForChildPassportExpDay = new ArrayList<String>();
		listForChildPassportExpDay.add("25");
		listForChildPassportExpDay.add("17");
		listForChildPassportExpDay.add("27");
		listForChildPassportExpDay.add("31");
		listForChildPassportExpDay.add("8");
		listForChildPassportExpDay.add("19");
		listForChildPassportExpDay.add("23");
		listForChildPassportExpDay.add("30");
		listForChildPassportExpDay.add("13");
		List<String> listForChildPassportExpMon = new ArrayList<String>();
		listForChildPassportExpMon.add("Mar");
		listForChildPassportExpMon.add("May");
		listForChildPassportExpMon.add("Feb");
		listForChildPassportExpMon.add("Jul");
		listForChildPassportExpMon.add("Aug");
		listForChildPassportExpMon.add("Jul");
		listForChildPassportExpMon.add("Feb");
		listForChildPassportExpMon.add("May");
		listForChildPassportExpMon.add("Feb");
		List<String> listForChildPassportExpYear = new ArrayList<String>();
		listForChildPassportExpYear.add("2019");
		listForChildPassportExpYear.add("2021");
		listForChildPassportExpYear.add("2022");
		listForChildPassportExpYear.add("2023");
		listForChildPassportExpYear.add("2017");
		listForChildPassportExpYear.add("2024");
		listForChildPassportExpYear.add("2026");
		listForChildPassportExpYear.add("2029");
		listForChildPassportExpYear.add("2032");
		List<WebElement> sendingChildPassExpDay = driver.findElements(By.xpath("//*[contains(@id,'passEXDayChild')]"));
		sendingChildPassExpDay.get(childPassportExpDateCount)
				.sendKeys(listForChildPassportExpDay.get(childPassportExpDateCount));
		List<WebElement> sendingChildPassExpMon = driver.findElements(By.xpath("//*[contains(@id,'passEXMonChild')]"));
		sendingChildPassExpMon.get(childPassportExpDateCount)
				.sendKeys(listForChildPassportExpMon.get(childPassportExpDateCount));
		List<WebElement> sendingChildPassExpYear = driver
				.findElements(By.xpath("//*[contains(@id,'passEXYearChild')]"));
		sendingChildPassExpYear.get(childPassportExpDateCount)
				.sendKeys(listForChildPassportExpYear.get(childPassportExpDateCount));
	}
	
	//Passport Expiry date for Infant Passengers
	public void infantPassportExpiryDate(int infantPassportExpDateCount) {
		List<String> listForInfantPassportExpDay = new ArrayList<String>();
		listForInfantPassportExpDay.add("25");
		listForInfantPassportExpDay.add("17");
		listForInfantPassportExpDay.add("27");
		listForInfantPassportExpDay.add("31");
		listForInfantPassportExpDay.add("8");
		listForInfantPassportExpDay.add("19");
		listForInfantPassportExpDay.add("23");
		listForInfantPassportExpDay.add("30");
		listForInfantPassportExpDay.add("13");
		List<String> listForInfantPassportExpMon = new ArrayList<String>();
		listForInfantPassportExpMon.add("Mar");
		listForInfantPassportExpMon.add("May");
		listForInfantPassportExpMon.add("Feb");
		listForInfantPassportExpMon.add("Jul");
		listForInfantPassportExpMon.add("Aug");
		listForInfantPassportExpMon.add("Jul");
		listForInfantPassportExpMon.add("Feb");
		listForInfantPassportExpMon.add("May");
		listForInfantPassportExpMon.add("Feb");
		List<String> listForInfantPassportExpYear = new ArrayList<String>();
		listForInfantPassportExpYear.add("2019");
		listForInfantPassportExpYear.add("2021");
		listForInfantPassportExpYear.add("2022");
		listForInfantPassportExpYear.add("2023");
		listForInfantPassportExpYear.add("2017");
		listForInfantPassportExpYear.add("2024");
		listForInfantPassportExpYear.add("2026");
		listForInfantPassportExpYear.add("2029");
		listForInfantPassportExpYear.add("2032");
		List<WebElement> sendingInfantPassExpDay = driver
				.findElements(By.xpath("//*[contains(@id,'passEXDayInfant')]"));
		sendingInfantPassExpDay.get(infantPassportExpDateCount)
				.sendKeys(listForInfantPassportExpDay.get(infantPassportExpDateCount));
		List<WebElement> sendingInfantPassExpMon = driver
				.findElements(By.xpath("//*[contains(@id,'passEXMonInfant')]"));
		sendingInfantPassExpMon.get(infantPassportExpDateCount)
				.sendKeys(listForInfantPassportExpMon.get(infantPassportExpDateCount));
		List<WebElement> sendingInfantPassExpYear = driver
				.findElements(By.xpath("//*[contains(@id,'passEXYearInfant')]"));
		sendingInfantPassExpYear.get(infantPassportExpDateCount)
				.sendKeys(listForInfantPassportExpYear.get(infantPassportExpDateCount));
	}
	public void contactNumber() {
		try {
			WaitStatementLib.iWait(2);
			contactDetails.clear();
			contactDetails.sendKeys("9999113674");
			WaitStatementLib.iWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnContinueButton() {
		try {
			WaitStatementLib.iWait(5);
			continueBtn.click();
			WaitStatementLib.iWait(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

