package resource;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumber.listener.Reporter;




public class DriverFactory extends TestBase{
    
	WebDriver driver;
	
	public WebDriver initializeDriver() {
		String chromepath= System.getProperty("user.dir")+File.separator+"Driver"+File.separator+"chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS	, true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//Reporter.addStepLog("Initialized the driver successfully");
		return driver;
		
	}
}
