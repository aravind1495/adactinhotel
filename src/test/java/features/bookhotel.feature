Feature: Validate the functionality of hotel booking in Adactin Hotel app

Scenario: Login to adactin hotel
Given browser is open
And user is on adactin home page "https://adactinhotelapp.com/"
When user enters the username as "JonTheKing" and password as "jontheking123"
And clicks on Login
Then user should be taken to the search hotel page "https://adactinhotelapp.com/SearchHotel.php"

Scenario: Search hotel
When user search hotel with following details
|London|Hotel Sunshine|Deluxe|1|28/11/2022|30/11/2022|2|0|
And click on search
Then user should be taken to the select hotel page "https://adactinhotelapp.com/SelectHotel.php"

Scenario: Select hotel
When user selects the hotel "Hotel Sunshine"
And clicks on Continue
Then user should be taken to the book a hotel page "https://adactinhotelapp.com/BookHotel.php"

Scenario: Book a hotel
When user book a hotel with following details
|Jon|Snow|Castle Black, The Wall, Westeros North|8765432112345678|Master Card|1|2022|123|
And clicks on Book Now
Then user should be taken to the booking confirmation page "https://adactinhotelapp.com/BookingConfirm.php"

Scenario: Verify booking
Given user has booking ID
When user click on My Itinerary
Then user should be taken to the page "https://adactinhotelapp.com/BookedItinerary.php"
And verifies booked hotel is showing in the Booked Itinerary
And clicks on Logout
And close the browser