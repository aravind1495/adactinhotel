package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel {
	
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement lastName;

	@FindBy(xpath="//textarea[@id='address']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='cc_num']")
	private WebElement creditCard;
	
	@FindBy(xpath="//select[@id='cc_type']")
	private WebElement ccType;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	private WebElement ccExpMonth;
	
	@FindBy(xpath="//select[@id='cc_exp_year']")
	private WebElement ccExpYear;
	
	@FindBy(xpath="//input[@id='cc_cvv']")
	private WebElement cvv;
	
	@FindBy(xpath="//input[@id='book_now']")
	private WebElement bookNow;
	
	@FindBy(xpath="//input[@id='cancel']")
	private WebElement cancel;
	
	public BookHotel(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditCard() {
		return creditCard;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcExpMonth() {
		return ccExpMonth;
	}

	public WebElement getCcExpYear() {
		return ccExpYear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public WebElement getCancel() {
		return cancel;
	}	
}
