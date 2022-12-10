package com.pom;

import org.openqa.selenium.WebDriver;

public class POMManager {
	
	private static WebDriver driver;
	
	public POMManager(WebDriver webDriver) {
		driver = webDriver;
	}

	public Login login() {
		return new Login(driver);
	}
	
	public SearchHotel searchHotel() {
		return new SearchHotel(driver);
	}
	
	public SelectHotel selectHotel() {
		return new SelectHotel(driver);
	}
	
	public BookHotel bookHotel() {
		return new BookHotel(driver);
	}
	
	public BookingConfirmation bookingConfirmation() {
		return new BookingConfirmation(driver);
	}
	
	public BookedItinerary bookedItinerary() {
		return new BookedItinerary(driver);
	}
}
