package com.emtHotePage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewHotel {
	WebDriver driver;
	String id="";
	String availableRoomType="";
	String inclusions ="";
	String chkOutDate ;
	List hotelDetails =  new ArrayList<>();
	@FindBy(xpath = ("//article[@id='jump']/div[3]/div[1]/div/div[1]/div[2]/div[2]/div[1]"))
	private WebElement hotelPrice;
	@FindBy(xpath = ("//form[@id='myDescForm']/div[4]/div[1]/div[1]//span"))
	private WebElement hotelName;
	@FindBy(xpath = ("//input[@id='txtCheckInDate']"))
	private WebElement checkInDate;
	@FindBy(xpath = ("//input[@id='txtCheckOutDate']"))
	private WebElement checkOutDate;
	@FindBy(xpath = ("//div[@class='main_pnl ng-scope']/div[2]/div[1]/div[1]"))
	private List<WebElement> roomType;
	@FindBy(xpath = ("//div[@class='main_pnl ng-scope']/div[2]/div[1]/div[3]/div[2]"))
	private List<WebElement> inclusion;
	public NewHotel(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@Test
	public void fetchingHotelDetails() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		Thread.sleep(3000);
		String nameOfHotel = hotelName.getAttribute("textContent");
		System.out.println("Name of the Hotel is :" + nameOfHotel);
		// To find hidden value
		String ChkInDate = checkInDate.getAttribute("value");
		System.out.println("CheckInDate : " + " " + ChkInDate);
		 chkOutDate = checkOutDate.getAttribute("value");
		System.out.println("CheckOutDate : " + " " + chkOutDate);
		for (int r = 0; r < roomType.size();) {
			//String availableRoomType = roomType.get(r).getText();
			availableRoomType = roomType.get(r).getText();
			System.out.println("Room Type : " + availableRoomType);
			break;
		}
		for (int inc = 0; inc < inclusion.size();) {
			//String inclusions = inclusion.get(inc).getText();
			inclusions = inclusion.get(inc).getText();
			System.out.println("Inclusions : " + inclusions);
			break;
		}
		String prc = hotelPrice.getText();
		System.out.println("Price for Selected hotel is Rs." + prc);
		System.out.println("============================================================================");
		dddd dd=new dddd();
		dd.id=id;
		
		dd.nameOfHotel=nameOfHotel;
		dd.ChkInDate=ChkInDate;
		dd.chkOutDate=chkOutDate;
		//dd.inclusions=inclusions;
		dd.MealType=inclusions;
		dd.availableRoomType=availableRoomType;
		dd.prc=prc;
		hotelDetails.add(dd);		
	}
class dddd{
	String id="";
	//String InventoryHotelID;
	String nameOfHotel="";
	String ChkInDate;
	String chkOutDate ;
	String availableRoomType="";
	//String inclusions ="";
	String MealType ="";
	String prc;

}
	@Test
	public void hotelSearching() throws TimeoutException, EncryptedDocumentException, InvalidFormatException,
			IOException, InterruptedException {
		String baseUrl = "http://hotel.easemytrip.com/metasearch.aspx?HotelID=textHotel&checkinDay=dateChoosen&checkinMonth=mon&checkinYear=yr&nights=1&adlts=1|&room=1&user=emthotels";
		//String filePath = "D:\\EMTHotels.xlsx";
		String filePath = "D:\\EMTHOTELSNEWDATA.xlsx";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		// Read sheet inside the workbook by its name
		Sheet sh = wb.getSheet("Sheet1");
		// Find number of rows in excel file
		// int Firstrow=sh.getFirstRowNum();
		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
		// System.out.println(rowCount);
		// Create a loop over all the rows of excel file to read it
		List<String> listOfHotelId = new ArrayList<String>();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sh.getRow(i);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				String hotelId = row.getCell(j).getStringCellValue();
				listOfHotelId.add(hotelId);
			}

		}
		for (int k = 0; k < listOfHotelId.size(); k++) {
			//String id = listOfHotelId.get(k);
		id = listOfHotelId.get(k);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime today = LocalDateTime.now();
			LocalDateTime afterTenDays = today.plusDays(10);
			int day1 = afterTenDays.getDayOfMonth();
			String searchStartDay1 = Integer.toString(day1);
			int mon1 = afterTenDays.getMonthValue();
			String SearchStartMonth = Integer.toString(mon1);
			int year1 = afterTenDays.getYear();
			String SearchStartYear = Integer.toString(year1);
			String hotelUrl = baseUrl.replaceAll("textHotel", id).replaceAll("dateChoosen", searchStartDay1)
					.replaceAll("mon", SearchStartMonth).replaceAll("yr", SearchStartYear);
			driver.get(hotelUrl);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.navigate().refresh();
//			driver.get(hotelUrl);
			Thread.sleep(10000);
			String urlOne = driver.getCurrentUrl();
			if (urlOne.length() > 29) {
				Thread.sleep(1000);
				WebDriverWait wait = new WebDriverWait(driver, 10);
				System.out.println("============================================================================");
				System.out.println(id + " " + "Hotel is available for dated " + ":" + searchStartDay1 + "-"
						+ SearchStartMonth + "-" + SearchStartYear);
				wait.until(ExpectedConditions.visibilityOf(hotelName));
				fetchingHotelDetails();
				//writeReportInExcel();

			}

			else if (urlOne.length() < hotelUrl.length()) {
				System.out.println(id + " " + "Hotel is not available for dated " + "  " + ":" + searchStartDay1 + "-"
						+ SearchStartMonth + "-" + SearchStartYear + " " + " " + "Going to search for next day!!!");
				int l;
				for (l = 11; l <= 27; l++) {
					LocalDateTime newSearchDate = today.plusDays(l);
					int day2 = newSearchDate.getDayOfMonth();
					String searchStartDay2 = Integer.toString(day2);
					int mon2 = newSearchDate.getMonthValue();
					String SearchStartMonth2 = Integer.toString(mon2);
					int year2 = newSearchDate.getYear();
					String SearchStartYear2 = Integer.toString(year2);
					String hotelUrlTwo = baseUrl.replaceAll("textHotel", id).replaceAll("dateChoosen", searchStartDay2)
							.replaceAll("mon", SearchStartMonth2).replaceAll("yr", SearchStartYear2);
					driver.get(hotelUrlTwo);
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					String urlTwo = driver.getCurrentUrl();
					if (urlTwo.length() > 29) {
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
						WebDriverWait wait = new WebDriverWait(driver, 10);
						Thread.sleep(3000);
						System.out.println(id + " :" + " " + "Hotel is available for dated " + ":" + searchStartDay2
								+ "-" + SearchStartMonth2 + "-" + SearchStartYear2);
						wait.until(ExpectedConditions.visibilityOf(hotelName));
						Thread.sleep(5000);
						fetchingHotelDetails();
						//writeReportInExcel();
					}
					if (urlTwo.length() < hotelUrlTwo.length()) {
						if (l > 26) {
							if(chkOutDate != null){
								System.out.println(id + " :" + "OOPS!!! Hotel not available between :" + chkOutDate + " " + "To " + searchStartDay2
										+ "-" + SearchStartMonth2 + "-" + SearchStartYear2);
							
							}else{
								System.out.println(id + " :" + "OOPS!!! Hotel not available between :" + searchStartDay1
										+ "-" + SearchStartMonth + "-" + SearchStartYear + " " + "To " + searchStartDay2
										+ "-" + SearchStartMonth2 + "-" + SearchStartYear2);
							}
							/*System.out.println(id + " :" + "OOPS!!! Hotel not available between :" + chkOutDate + " " + "To " + searchStartDay2
									+ "-" + SearchStartMonth2 + "-" + SearchStartYear2);*/
							System.out.println(
									"============================================================================");
						}

					}
				}
			}
		}
		writeReportInExcel();
	}
	@Test
	public void writeReportInExcel() throws IOException{
		//String [] columns={"Hotel Id","Hotel Name","CheckInDate","CheckOutDate","RoomType","Inclusion","Hotel Price"};
		String [] columns={"EMTHotelID","InventoryHotelID","HotelName","CheckInDate","CheckOutDate","Hotel Price","RoomType","Mealtype","Availability"};
		// Create a Workbook
        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        // Create a Sheet
        Sheet sheet = workbook.createSheet("Hotel Report");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);
     // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
       
     // Resize all columns to fit the content size
         for(int i = 0; i < columns.length; i++) {
             sheet.autoSizeColumn(i);
        }
         
        for (int k=0; k<hotelDetails.size();k++ ) {
        	Row r = sheet.createRow(k+1);
        	
        	//r.createCell(0).setCellValue(hotelDetails);
        	dddd ee= (dddd)hotelDetails.get(k);
        	r.createCell(0).setCellValue( ee.id );
        	r.createCell(1).setCellValue( ee.nameOfHotel);
        	r.createCell(2).setCellValue( ee.ChkInDate);
        	r.createCell(3).setCellValue( ee.chkOutDate );
        	r.createCell(4).setCellValue( ee.availableRoomType);
        	r.createCell(5).setCellValue( ee.MealType );
        	r.createCell(6).setCellValue( ee.prc );
        }
        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("Report.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
	}
}