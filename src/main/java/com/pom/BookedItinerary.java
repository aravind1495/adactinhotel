package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedItinerary {
	
	@FindBy(xpath="(//table)[5]/tbody/tr/td[2]/input")
	private List<WebElement> bookingId;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logOut;
	
	public BookedItinerary(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	public List<WebElement> getBookingIds() {
		return bookingId;
	}
	
	public WebElement getLogOut() {
		return logOut;
	}
}
