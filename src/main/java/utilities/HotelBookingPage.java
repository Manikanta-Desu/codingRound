package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPage {
	
	WebDriver driver;
	
//	@FindBy(how = How.LINK_TEXT, using = "Hotels")
//    private WebElement hotelLink;
	
	@FindBy(how = How.ID, using = "Tags")
	private WebElement localityTextBox;

	@FindBy(how = How.ID, using = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(how = How.ID, using = "travellersOnhome")
	private WebElement travellerSelection;

	// Constructor for page factory class
	public HotelBookingPage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}
	
//	public HotelBookingPage setHotelLink(){
//		this.hotelLink.click();
//		return PageFactory.initElements(driver,HotelBookingPage.class);
//	}

	public void setLocalityText(String localotyNname) {
		this.localityTextBox.clear();
		this.localityTextBox.sendKeys(localotyNname);
	}

	public void setSearchButton() {
		this.searchButton.click();
	}
	
	public void setTravellersOnHome(String travellerType){
		new Select(this.travellerSelection).selectByVisibleText(travellerType);
	}
	
	

}
