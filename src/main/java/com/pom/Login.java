package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passWord;
	
	@FindBy(xpath="//input[@id='login']")
	private WebElement logIn;
	
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLogIn() {
		return logIn;
	}

}
