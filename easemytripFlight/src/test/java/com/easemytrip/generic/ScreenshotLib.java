package com.easemytrip.generic;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


/**
 * 
 * @author RAKESH JHA Reviewed By Rakesh Jha CreatedBy Rakesh Jha
 */
public class ScreenshotLib {

	/**
	 * @description take screenshot(.png) into screenshot folder
	 * @param driver
	 * @param fileName
	 */
	public void takeScreenshot(WebDriver driver, String fileName) {
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File srcFile = efw.getScreenshotAs(OutputType.FILE);
		//String dateName = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
		File destFile = new File("./screenshots/" + fileName +".png");
		
			//File destFile = new File("./screenshots/" +"timestamp()"+ ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		
		}		catch (IOException e) {

		e.printStackTrace();
		}
		 
         }
	}


