package utilities;

import com.sun.javafx.PlatformUtil;

public abstract class BrowserHelper {
	
	
	public void setDriverPath() {
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
