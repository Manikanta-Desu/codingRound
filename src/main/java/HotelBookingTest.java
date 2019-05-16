import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserHelper;
import utilities.ClearTripHomePage;
import utilities.HotelBookingPage;

public class HotelBookingTest extends BrowserHelper {

	WebDriver driver;
	
	HotelBookingPage hotelBookingPage ;
	
	ClearTripHomePage clearTripHomepage;

	
	@BeforeClass
	public void BrowserLaunch(){
		setDriverPath();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		
		clearTripHomepage = new ClearTripHomePage(driver);
	}
	
	
	@Test
	public void shouldBeAbleToSearchForHotels() {
		
		hotelBookingPage=clearTripHomepage.clickHotelsLink();

		hotelBookingPage.setLocalityText("Indiranagar, Bangalore");
		
		hotelBookingPage.setTravellersOnHome("1 room, 2 adults");
		
//		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		hotelBookingPage.setSearchButton();

		driver.quit();

	}

}
