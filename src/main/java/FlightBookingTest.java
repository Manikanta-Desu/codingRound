import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

import utilities.BrowserHelperImpl;
import utilities.ClearTripHomePage;

public class FlightBookingTest extends BrowserHelperImpl {

	@BeforeClass
	public void BrowserLaunch() {

		// calling launch browser method from abstract class
		launchBrowser("firefox", "http://www.cleartrip.com");

	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		driver.findElement(By.id("OneWay")).click();

		driver.findElement(By.id("FromTag")).clear();
		driver.findElement(By.id("FromTag")).sendKeys("Bangalore");

		// wait for the auto complete options to appear for the origin

		WebDriverWait wait = new WebDriverWait(driver, 55);
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-1")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-id-1")));

		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("destination")));

		driver.findElement(By.name("destination")).clear();
		driver.findElement(By.name("destination")).sendKeys("Delhi");

		// wait for the auto complete options to appear for the destination

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-2")));
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

		// all fields filled in. Now click on search
		driver.findElement(By.id("SearchBtn")).click();

		waitFor(5000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));

		// close the browser
		driver.quit();

	}


	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}


}
