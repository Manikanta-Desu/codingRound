package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ClearTripHomePage {
	
	WebDriver driver;
	
	@FindBy(how = How.LINK_TEXT, using = "Hotels")
	private WebElement hotelLink;
	
	public ClearTripHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public HotelBookingPage clickHotelsLink(){
		this.hotelLink.click();
		return PageFactory.initElements(driver, HotelBookingPage.class);
	}

}
