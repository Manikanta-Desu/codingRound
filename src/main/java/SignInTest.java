import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

public class SignInTest {

    WebDriver driver = new FirefoxDriver();

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();
        
        driver.manage().window().maximize();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        
        driver.switchTo().frame(1);
       
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        
        driver.findElement(By.id("email")).sendKeys("desumanikanta70@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test1234");

        driver.findElement(By.id("signInButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#errors1>span")));
        String errors1 = driver.findElement(By.id("errors1")).getText();
        System.out.println("error string is" +errors1);
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }


}
