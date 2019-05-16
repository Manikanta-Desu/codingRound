import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserHelperImpl;
import utilities.ClearTripHomePage;
import utilities.HotelBookingPage;

public class HotelBookingTest extends BrowserHelperImpl {

	
	HotelBookingPage hotelBookingPage ;
	
	ClearTripHomePage clearTripHomepage;

	
	@BeforeClass
	public void BrowserLaunch(){
		
		//calling launch browser method from abstract class 
		launchBrowser("firefox", "http://www.cleartrip.com");
		
		clearTripHomepage = new ClearTripHomePage(driver);
	}
	
	
	@Test
	public void shouldBeAbleToSearchForHotels() {
		
		hotelBookingPage=clearTripHomepage.clickHotelsLink();

		hotelBookingPage.setLocalityText("Indiranagar, Bangalore");
		
		hotelBookingPage.setTravellersOnHome("1 room, 2 adults");
		
		hotelBookingPage.setSearchButton();

	}
	
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}

}
