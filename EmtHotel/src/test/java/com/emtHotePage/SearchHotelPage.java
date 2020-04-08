package com.emtHotePage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchHotelPage {
	WebDriver driver;
	@FindBy(xpath = ("//div[@class='prc']"))
	private WebElement hotelPrice;

	public SearchHotelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@Test
	public void hotelSearching() throws TimeoutException, EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		//String baseUrl = "http://hotel.easemytrip.com/metasearch.aspx?HotelID=textHotel&checkinDay=dateChoosen&checkinMonth=12&checkinYear=2018&nights=1&adlts=1|&room=1&user=emthotels";
		String baseUrl = "http://hotel.easemytrip.com/metasearch.aspx?HotelID=textHotel&checkinDay=dateChoosen&checkinMonth=mon&checkinYear=yr&nights=1&adlts=1|&room=1&user=emthotels";
		String filePath = "D:\\EMTHotels.xlsx";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		//try {
			Workbook wb = WorkbookFactory.create(fis);
			// Read sheet inside the workbook by its name
			Sheet sh = wb.getSheet("Sheet1");
			// Find number of rows in excel file
			// int Firstrow=sh.getFirstRowNum();
			int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
			// System.out.println(rowCount);
			// Create a loop over all the rows of excel file to read it
			List<String> listOfHotelId = new ArrayList<String>();

			for (int i = 0; i < rowCount + 1; i++) {
				Row row = sh.getRow(i);
				// Create a loop to print cell values in a row

				for (int j = 0; j < row.getLastCellNum(); j++) {
					String hotelId = row.getCell(j).getStringCellValue();
					listOfHotelId.add(hotelId);
				}

			}
			for (int k = 0; k < listOfHotelId.size(); k++) {
				String id = listOfHotelId.get(k);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
				   LocalDateTime now = LocalDateTime.now(); 
				   System.out.println(dtf.format(now)); 
				   int day = now.getDayOfMonth()+10;
				 
				   String searchStartDay = Integer.toString(day);
				  // System.out.println(day); 
				   int mon=now.getMonthValue();
				   String SearchStartMonth = Integer.toString(mon);
				   //System.out.println(mon); 
				  int year= now.getYear();
				  String SearchStartYear = Integer.toString(year);
				 // System.out.println(year); 
				  String hotelUrl = baseUrl.replaceAll("textHotel", id).replaceAll("dateChoosen", searchStartDay).replaceAll("mon", SearchStartMonth).replaceAll("yr", SearchStartYear);
					driver.get(hotelUrl);
					Thread.sleep(2000);
					
				 
					String urlOne = driver.getCurrentUrl();
					if (urlOne.length() > 29) {
						System.out.println(
								id + " " + "Hotel is available for dated " + ":" + searchStartDay + "-" + SearchStartMonth+ "-" + SearchStartYear);
						Thread.sleep(1000);
						String prc = hotelPrice.getText();
						System.out.println("Price for Selected hotel is Rs." + prc);
				
					}

					else if (urlOne.length() < hotelUrl.length()) {

						System.out.println(id + " " + "Hotel is not available for dated " + "  " + ":" + searchStartDay + "-"
								+ SearchStartMonth + "-" + SearchStartYear + "\n" + " "  + "Going to search for next day!!!");
						
						//Need to work here if date is after 31st december
						int l;
						for ( l = 11; l <= 25; l++) {
							int day1 = now.getDayOfMonth()+l;
							String searchStartDay1 = Integer.toString(day1);
							String hotelUrlTwo = baseUrl.replaceAll("textHotel", id).replaceAll("dateChoosen", searchStartDay1).replaceAll("mon", SearchStartMonth).replaceAll("yr", SearchStartYear);
							driver.get(hotelUrlTwo);
							String urlTwo = driver.getCurrentUrl();
							if (urlTwo.length() > 29) {
								Thread.sleep(3000);
								System.out.println(id +" :"+ " " + "Hotel is available for dated " + ":" + searchStartDay1 + "-" + SearchStartMonth+ "-" + SearchStartYear);
								Thread.sleep(1000);
								String prc = hotelPrice.getText();
								System.out.println("Price for Selected hotel is Rs." + prc);
								break;
						}
							else if (urlTwo.length() < hotelUrlTwo.length()) {
								if(l==20){
									System.out.println(id+" :"+"OOPS!!! Hotel not available.");
								}
							}
					}
			/*for (int k = 0; k < listOfHotelId.size(); k++) {
				String id = listOfHotelId.get(k);
				SimpleDateFormat formatter = new SimpleDateFormat("dd");
				Date date = new Date();
			//	String currentDate = formatter.format(date);
				formatter.format(date);
				Calendar cal = Calendar.getInstance();
				//cal.add(Calendar.DAY_OF_MONTH, 10);
				cal.add(Calendar.DAY_OF_MONTH, 10);
				String searchStartDay = formatter.format(cal.getTime());
				 int month = Calendar.getInstance().get(Calendar.MONTH)+1;
				String startMonth = Integer.toString(month);
				 int year = Calendar.getInstance().get(Calendar.YEAR);
				 String startYear = Integer.toString(year);

				// System.out.println(currentDate);

				//String hotelUrl = baseUrl.replaceAll("textHotel", id).replaceAll("dateChoosen", searchStartDay);
				String hotelUrl = baseUrl.replaceAll("textHotel", id).replaceAll("dateChoosen", searchStartDay).replaceAll("mon", startMonth).replaceAll("yr", startYear);
				driver.get(hotelUrl);
				Thread.sleep(2000);
				String urlOne = driver.getCurrentUrl();
				if (urlOne.length() > 29) {
					System.out.println(
							id + " " + "Hotel is available for dated " + ":" + searchStartDay + "-" + "12" + "-" + "2018");
					Thread.sleep(1000);
					String prc = hotelPrice.getText();
					System.out.println("Price for Selected hotel is Rs." + prc);
			
				}

				else if (urlOne.length() < hotelUrl.length()) {

					System.out.println(id + " " + "Hotel is not available for dated " + "  " + ":" + searchStartDay + "-"
							+ "12" + "-" + "2018" + "\n" + " " + " " + "Going to search for next day!!!");
					int l;
					//for ( l = 11; l <= 25; l++) {
					for ( l = 11; l <= 20; l++) {
						//Thread.sleep(2000);
						//System.out.println(id);
						Calendar cal1 = Calendar.getInstance();
					
						// Displaying current date in the desired format
					cal1.add(Calendar.DAY_OF_MONTH, l);
						// cal.add(Calendar.DAY_OF_MONTH, 9);
						// Date after adding the days to the current date
						String Date1 = formatter.format(cal1.getTime());
						// System.out.println(Date1);
						//String hotelUrlOne = baseUrl.replaceAll("textHotel", id).replaceAll("dateChoosen", Date1);
						String hotelUrlOne = baseUrl.replaceAll("textHotel", id).replaceAll("dateChoosen", Date1).replaceAll("mon", startMonth).replaceAll("yr", startYear);
						driver.get(hotelUrlOne);
						String urlTwo = driver.getCurrentUrl();

						if (urlTwo.length() > 29) {
							Thread.sleep(3000);
							System.out.println(id +" :"+ " " + "Hotel is available for dated " + ":" + Date1 + "-" + "12"+ "-" + "2018");
							Thread.sleep(1000);
							String prc = hotelPrice.getText();
							System.out.println("Price for Selected hotel is Rs." + prc);
						
						}

						else if (urlTwo.length() < hotelUrlOne.length()) {
							if(l==20){
								System.out.println(id+" :"+"OOPS!!! Hotel not available.");
							}
							
						
						}
					}

					Thread.sleep(2000);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
*/
	
	}
}
}	
}
