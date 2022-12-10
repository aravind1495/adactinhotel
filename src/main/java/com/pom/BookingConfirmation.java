package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation {
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//input[@id='search_hotel']")
	private WebElement searchHotel;
	
	@FindBy(xpath="//input[@id='my_itinerary']")
	private WebElement myItinerary;
	
	@FindBy(xpath="//input[@id='logout']")
	private WebElement logOut;
	
	@FindBy(xpath="//input[@id='order_no']")
	private WebElement orderId;
	
	public BookingConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getSearchHotel() {
		return searchHotel;
	}

	public WebElement getMyItinerary() {
		return myItinerary;
	}

	public WebElement getLogOut() {
		return logOut;
	}
	
	public WebElement getOrderId() {
		return orderId;
	}
}
