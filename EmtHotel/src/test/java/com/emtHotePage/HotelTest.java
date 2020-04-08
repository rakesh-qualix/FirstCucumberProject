package com.emtHotePage;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class HotelTest extends BaseLib {
	NewHotel shp;

	@Test
	public void goingToSearchHotel()
			throws Exception, InvalidFormatException, TimeoutException, IOException, InterruptedException {
		shp = new NewHotel(driver);
		shp.hotelSearching();
	}
}
