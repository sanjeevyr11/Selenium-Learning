package stepDefinition;



import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resource.DriverFactory;

import resource.Utility;
import resource.Xpath;

public class Login {
	DriverFactory obj_driverFactory = new DriverFactory();
	
	Utility obj_Utility = new Utility();
	WebDriver driver;
	@Before
	public void setDriver() {
		
		driver = obj_driverFactory.initializeDriver();
		
	}
	
	@Given("^user navigates to naukri$")
		public void navigate() {
		String url= obj_driverFactory.getProperty("url");
		obj_Utility.openUrl(driver, url);
		obj_Utility.waitforpageload(driver);
		String parentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows) {
			if(!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(parentwindow);
		
	}
	
	@When("^user click on login and enters user name and password$")
	public void enterCreds() throws Exception {
		
	   String username = obj_driverFactory.getProperty("username");
	   String password = obj_driverFactory.getProperty("password");
	   
	   WebElement login = obj_Utility.findElement(driver, Xpath.loginButton);
	   obj_Utility.clickElement(driver, login);
	   WebElement user = obj_Utility.findElement(driver, Xpath.emailTextBox);
	   obj_Utility.enterValue(user, username);
	   WebElement pwd = obj_Utility.findElement(driver, Xpath.passwordTextBox);
	   obj_Utility.enterValue(pwd, password);
	   WebElement submit = obj_Utility.findElement(driver, Xpath.submitButton);
	   obj_Utility.clickElement(driver, submit);
	   obj_Utility.waitforpageload(driver);
	}
	
	@Then("^user should successfully login$")
	public void login() {
	   
	}
	
	@After
	public void quit() {
		//driver.quit();
		
	}
}
