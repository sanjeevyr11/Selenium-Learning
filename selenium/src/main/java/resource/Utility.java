package resource;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;



public class Utility {
	
	
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
		Reporter.addStepLog("The URL "+url+" is launced");
	}
    
	public void waitforpageload(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		
		Wait<WebDriver> wait = new WebDriverWait(driver, 180);
		wait.until(expectation);
	}
	
	public WebElement findElement(WebDriver driver,String xpath) throws Exception {
		Thread.sleep(3000);
		return driver.findElement(By.xpath(xpath));
		
	}
	
	public void enterValue(WebElement element, String value) {
		
		element.sendKeys(value);
		Reporter.addStepLog("value "+value+" is entered");
	}
	
	public void clickElement(WebDriver driver,WebElement element) throws Exception {
		//Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	public void clickElementJavaScript(WebDriver driver,WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
}
