package utilities;

public abstract class BrowserHelper {
	
	
	public abstract void setDriverPath();
	
	public abstract void launchBrowser(String broserName, String url);
	
	public abstract void closeBrowser();
	
	public abstract void waitFor(int durationInMilliSeconds);

}
