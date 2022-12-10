package stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.base.BaseClass;
import com.pom.POMManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookHotelSteps extends BaseClass {

	private static String bookingId;
	
	static Logger log = Logger.getLogger(BookHotelSteps.class);

	@Given("browser is open")
	public void browser_is_open() {
		log.info("Executing...");
		setup("chrome");
		log.info("Chrome browser has been launched");
	}

	@Given("user is on adactin home page {string}")
	public void user_is_on_adactin_home_page(String url) {
		driver.get(url);
		log.info("Launching Adactin home page: "+url);
		pom = new POMManager(driver);
	}

	@When("user enters the username as {string} and password as {string}")
	public void user_enters_the_username_as_and_password_as(String userName, String passWord) {
		pom.login().getUserName().sendKeys(userName);
		log.info("Entered username");
		pom.login().getPassWord().sendKeys(passWord);
		log.info("Entered password");
	}

	@When("clicks on Login")
	public void clicks_on_login() {
		pom.login().getLogIn().click();
		log.info("clicked on Login");
	}

	@Then("user should be taken to the search hotel page {string}")
	public void user_should_be_taken_to_the_search_hotel_page(String url) {
		assertURL(url);
		log.info("Verified URL");
	}

	@When("user search hotel with following details")
	public void user_search_hotel_with_following_details(io.cucumber.datatable.DataTable dataTable) {

		List<List<String>> list = dataTable.asLists();

		singleSelect(pom.searchHotel().getLocation(), "text", list.get(0).get(0));
		singleSelect(pom.searchHotel().getHotels(), "text", list.get(0).get(1));
		singleSelect(pom.searchHotel().getRoomType(), "text", list.get(0).get(2));
		singleSelect(pom.searchHotel().getRoomNos(), "index", list.get(0).get(3));
		pom.searchHotel().getCheckIn().clear();
		pom.searchHotel().getCheckIn().sendKeys(list.get(0).get(4));
		pom.searchHotel().getCheckOut().clear();
		pom.searchHotel().getCheckOut().sendKeys(list.get(0).get(5));
		singleSelect(pom.searchHotel().getAdultRoom(), "index", list.get(0).get(6));
		singleSelect(pom.searchHotel().getChildRoom(), "index", list.get(0).get(7));
		
		log.info("Entered hotel details to search");

	}

	@When("click on search")
	public void click_on_search() {
		pom.searchHotel().getSubmit().click();
		log.info("Clicked on Submit");
	}

	@Then("user should be taken to the select hotel page {string}")
	public void user_should_be_taken_to_the_select_hotel_page(String url) {
		assertURL(url);
		log.info("Verified URL");
	}

	@Then("user selects the hotel {string}")
	public void user_selects_the_hotel(String hotel) {

		List<WebElement> hotelNames = pom.selectHotel().getHotelNames();
		List<WebElement> select = pom.selectHotel().getSelectOption();

		for (int i = 0; i < hotelNames.size(); i++) {
			if (hotelNames.get(i).getAttribute("value").equalsIgnoreCase(hotel)) {
				select.get(i).click();
			}
		}

		log.info("Selected hotel");
	}

	@Then("clicks on Continue")
	public void clicks_on_continue() {
		pom.selectHotel().getClickContinue().click();
		log.info("Clicked on Continue");
	}

	@Then("user should be taken to the book a hotel page {string}")
	public void user_should_be_taken_to_the_book_a_hotel_page(String url) {
		assertURL(url);
		log.info("Verified URL");
	}

	@When("user book a hotel with following details")
	public void user_book_a_hotel_with_following_details(io.cucumber.datatable.DataTable dataTable) {

		List<List<String>> list = dataTable.asLists();

		pom.bookHotel().getFirstName().sendKeys(list.get(0).get(0));
		pom.bookHotel().getLastName().sendKeys(list.get(0).get(1));
		pom.bookHotel().getAddress().sendKeys(list.get(0).get(2));
		pom.bookHotel().getCreditCard().sendKeys(list.get(0).get(3));
		singleSelect(pom.bookHotel().getCcType(), "text", list.get(0).get(4));
		singleSelect(pom.bookHotel().getCcExpMonth(), "index", list.get(0).get(5));
		singleSelect(pom.bookHotel().getCcExpYear(), "text", list.get(0).get(6));
		pom.bookHotel().getCvv().sendKeys(list.get(0).get(7));
		
		log.info("Entered details to book the hotel");

	}

	@When("clicks on Book Now")
	public void clicks_on_book_now() {

		pom.bookHotel().getBookNow().click();
		
		log.info("Clicked on Book Now");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pom.bookingConfirmation().getPageTitle()));
	}

	@Then("user should be taken to the booking confirmation page {string}")
	public void user_shpould_be_taken_to_the_booking_confirmation_page(String url) {
		assertURL(url);
		log.info("Verified URL");
	}

	@Given("user has booking ID")
	public void user_has_booking_id() {
		bookingId = pom.bookingConfirmation().getOrderId().getAttribute("value");

	}

	@When("user click on My Itinerary")
	public void user_click_on_my_itinerary() {
		pom.bookingConfirmation().getMyItinerary().click();
		
		log.info("Clicked on My Itinerary");
	}

	@Then("user should be taken to the page {string}")
	public void user_should_be_taken_to_the_page(String url) {
		assertURL(url);
		log.info("Verified URL");
	}

	@Then("verifies booked hotel is showing in the Booked Itinerary")
	public void verifies_booked_hotel_is_showing_in_the_booked_itinerary() {

		boolean bookingFlag = false;

		List<WebElement> bookingIds = pom.bookedItinerary().getBookingIds();
		for (WebElement bookingConfirmId : bookingIds) {
			if (bookingConfirmId.getAttribute("value").equals(bookingId)) {
				System.out.println("Successfully Booked\nBooking ID:" + bookingId);
				bookingFlag = true;
				break;
			}
		}

		if (bookingFlag) {
			Assert.assertTrue(true);
			log.info("Booking successful");
		} else {
			Assert.assertTrue(false);
			log.error("Booking error");
		}

	}

	@Then("clicks on Logout")
	public void clicks_on_logout() {
		pom.bookedItinerary().getLogOut().click();
		log.info("Clicked on Logout");
	}
	
	@Then("close the browser")
	public void close_the_browser() {
		
	}

	@After
	public void takeScreenshot(Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	
	}
	
	@AfterAll
	public static void closeBrowser() {
		log.info("Test completed");
		exit();
		log.info("Browser has been closed");
	}

}
