package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel {
	
	@FindBy(xpath="//select[@id='location']")
	private WebElement location;
	
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotels;
	
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomType;
	
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement roomNos;
	
	@FindBy(xpath="//input[@id='datepick_in']")
	private WebElement checkIn;
	
	@FindBy(xpath="//input[@id='datepick_out']")
	private WebElement checkOut;
	
	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adultRoom;
	
	@FindBy(xpath="//select[@id='child_room']")
	private WebElement childRoom;
	
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//input[@id='Reset']")
	private WebElement reset;
	
	
	public SearchHotel(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}


	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getAdultRoom() {
		return adultRoom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getReset() {
		return reset;
	}

}
