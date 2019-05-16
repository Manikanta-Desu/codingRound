import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

import utilities.BrowserHelperImpl;

public class SignInTest extends BrowserHelperImpl{

    @BeforeClass
	public void BrowserLaunch() {

		// calling launch browser method from abstract class
		launchBrowser("firefox", "http://www.cleartrip.com");

	}

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();
        
        driver.manage().window().maximize();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        
        driver.switchTo().frame(1);
       
        WebDriverWait wait = new WebDriverWait(driver, 75);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        
        driver.findElement(By.id("email")).sendKeys("desumanikanta70@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test1234");

        driver.findElement(By.id("signInButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#errors1>span")));
        String errors1 = driver.findElement(By.id("errors1")).getText();
        System.out.println("error string is" +errors1);
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }
    
    @AfterClass
	public void quitBrowser(){
		closeBrowser();
	}


}
