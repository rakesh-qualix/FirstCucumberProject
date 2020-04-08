package com.easemytrip.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author RAKESH JHA Created On 14/feb/2018
 * @reviewedBy RAkesh Jha
 */
public class GenericLib {
	/**
	 * description read data from config.properties file based on key.
	 * 
	 * @param Key
	 * @return String
	 */
	public static String getValue(String Key) {
		String value = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		value = prop.getProperty(Key);
		return value;
	}
}
