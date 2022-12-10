package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel {
	
	@FindBy(xpath="(//table)[5]/tbody/tr/td[2]/input")
	private List<WebElement> hotelNames;
	
	@FindBy(xpath="(//table)[5]/tbody/tr/td[1]/input[1]")
	private List<WebElement> selectOption;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement clickContinue;
	
	@FindBy(xpath = "//input[@id='cancel']")
	private WebElement clickCancel;
	
	
	public SelectHotel(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	public List<WebElement> getHotelNames() {
		return hotelNames;
	}
	
	public List<WebElement> getSelectOption() {
		return selectOption;
	}

	public WebElement getClickContinue() {
		return clickContinue;
	}

	public WebElement getClickCancel() {
		return clickCancel;
	}
	
}
