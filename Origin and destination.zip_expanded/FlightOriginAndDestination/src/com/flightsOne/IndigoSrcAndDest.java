package com.flightsOne;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndigoSrcAndDest extends BaseClass {
	String xmlStr1;
	String xmlStr = "<Table>\n" +
	"  <Origin>#origin#</Origin>\n" + 
			"<Destination>#destination#</Destination>\n"
			+ "    <EngineID>Indigo</EngineID>\n" +
			"  </Table>";
	String origin;
	String s="";
	
	

	@Test(priority = 1)
	public void from() throws InterruptedException {

		String from = "//div[@id='bookFlightTab']/form/div[2]/div[1]/div[1]/div/div/input";
		WebElement fromCity = driver.findElement(By.xpath(from));
		//fromCity.click();
		List<String> listOfAirportSourceCode = Arrays.asList("AUH", "DIB", "COK", "RPR", "IXA", "DMU", "CCU", "RJA",
				"AMD", "DOH", "CCJ", "IXR", "IXD", "DXB", "KUL", "SHJ", "ATQ", "GOI", "KWI", "SIN", "IXB", "GOP", "LKO",
				"SXR", "BKK", "GAU", "IXM", "STV", "BLR", "HKG", "MLE", "TRV", "BBI", "HBX", "IXE", "TRZ", "IXC", "HYD",
				"BOM", "TIR", "MAA", "IMF", "MCT", "TCR", "CJB", "IDR", "NAG", "UDR", "CMB", "JAI", "PAT", "BDQ", "DED",
				"IXJ", "HKT", "VNS", "DEL", "JRH", "IXZ", "VGA", "DAC", "KTM", "PNQ");

		int sizeOfAirport = listOfAirportSourceCode.size();
		System.out.println(sizeOfAirport);
		
		for (int i = 0; i < sizeOfAirport - 1; i++) {
			origin = listOfAirportSourceCode.get(i);
			if(i>=0) {
				fromCity.click();
				Thread.sleep(1000);
				fromCity.clear();
				
			}
			
		
		
	fromCity.sendKeys(origin);
	fromCity.sendKeys(Keys.ENTER);
	s="";
	To();
	}
	}

	@Test(priority = 2)
	public void To() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> toList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//div[@id='bookFlightTab']/form/div[2]/div[1]/div[2]/div/div/div/div/div/div[2]")));
		int sizeOfToCities = toList.size();

		for (int i = 0; i < sizeOfToCities; i++) {
			String citiesName = toList.get(i).getText();
			if(!citiesName.equals(origin)) {
			 s = s.concat(citiesName + ",");	
			}
			
			// s = s.concat(citiesName + ",");	
			}
		
		
		xmlStr1 = xmlStr.replace("#origin#", origin);
		xmlStr1 = xmlStr1.replace("#destination#", s);
		System.out.println(xmlStr1);
		Thread.sleep(2000);

	
	}

}



