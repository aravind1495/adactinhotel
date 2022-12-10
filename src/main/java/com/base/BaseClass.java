package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.pom.POMManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static POMManager pom;
	
	private static Actions act = null;
	
	public static void setup(String browser) {

switch (browser.toLowerCase()) {
		
		case "chrome" :
			
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Driver\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default: 
			
			System.out.println(">>>> No Browser Found <<<<<");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static void exit() {
		driver.quit();
	}

	public static void assertURL(String url) {
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
	
	private static String timeStamp() {

		DateFormat dateFormat = new SimpleDateFormat("ddMMhhmmss");
		Date date = new Date();
		String result = dateFormat.format(date);
		return result;

	}

	public static void takeScreenShot(String fileName) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File des = new File("./Screenshot/" + fileName + "_" + timeStamp() + ".png");
		FileUtils.copyFile(src, des);

	}

	public static void takeElementScreenShot(WebElement element, String fileName) throws IOException {

		File src = element.getScreenshotAs(OutputType.FILE);
		File des = new File("./Screenshot/" + fileName + "_" + timeStamp() + ".png");
		FileUtils.copyFile(src, des);

	}

	public static WebElement singleSelect(WebElement selEle, String selectType, String value) {

		WebElement selectedEle = null;

		Select select = new Select(selEle);

		if (selectType.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(value));
		} else if (selectType.equalsIgnoreCase("value")) {
			select.selectByValue(value);
		} else if (selectType.equalsIgnoreCase("text") || selectType.equalsIgnoreCase("visibletext")) {
			select.selectByVisibleText(value);
		} else {
			System.err.println(">>>>> Exception : Invalid Tag Name. Accepts only <select> tag element");
		}

		return selectedEle;
	}
	
	public static List<WebElement> getSelectOptions(WebElement selEle) {
		
		return new Select(selEle).getOptions();
	}

	public static void scrollBy(int value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + value + ")");
	}

	private static void createActions() {
		act = new Actions(driver);
	}

	public static void mouseOver(WebElement element) {
		if (act == null) {
			createActions();
		}
		act.moveToElement(element).perform();
	}
	
	public static void actionClick(WebElement element) {
		if (act == null) {
			createActions();
		}
		act.click(element);
	}

	public static void rightClick(WebElement element) {
		if (act == null) {
			createActions();
		}
		act.contextClick(element).perform();
	}
	
	public static void scrollIntoElement(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}

	public static void jsClick(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}
	
	public static String pageState() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = js.executeScript("return document.readyState").toString();
		return state;
		
	}
	
	private static int keyBinding(String keyType) {
		
		int key = 0;
		switch (keyType.toLowerCase()) {
		case "down": key = KeyEvent.VK_DOWN; break;
		case "up": key = KeyEvent.VK_UP; break;
		case "right": key = KeyEvent.VK_RIGHT; break;
		case "left": key = KeyEvent.VK_LEFT; break;
		case "enter": key = KeyEvent.VK_ENTER; break;
		case "tab": key = KeyEvent.VK_TAB; break;
		case "space": key = KeyEvent.VK_SPACE; break;
		case "backspace": key = KeyEvent.VK_BACK_SPACE; break;
		case "pageup": key = KeyEvent.VK_PAGE_UP; break;
		case "pagedown": key = KeyEvent.VK_PAGE_DOWN; break;
		case "ctrl": key = KeyEvent.VK_CONTROL; break;
		case "add": key = KeyEvent.VK_ADD; break;
		case "sub": key = KeyEvent.VK_SUBTRACT; break;
		default: System.err.println(">>>Invalid Key Type<<<");
		}
		
		return key;
	}
	
	public static void pressKey(String keyType, int keyCount) throws AWTException {

		Robot rob = new Robot();
		int key = keyBinding(keyType);

		for (int i = 0; i < keyCount; i++) {
			rob.keyPress(key);
			rob.keyRelease(key);
		}
	}
	
	public static void ctrlPress(String keyType) throws AWTException {
		
		Robot rob = new Robot();
		
		int key = keyBinding(keyType);
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(key);
		rob.keyRelease(key);
		rob.keyRelease(KeyEvent.VK_CONTROL);
 
		
	}
	
}
