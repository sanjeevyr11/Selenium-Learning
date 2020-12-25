package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="Features", glue= {"stepDefinition"},
plugin = "com.cucumber.listener.ExtentCucumberFormatter:Report/cucumber-reports/report.html")
public class RunnerClass {
	
	@AfterClass
	public static void writeExtentReport() {
		
		
		String reportConfigPath = System.getProperty("user.dir")+File.separator+"ReportConfig"+File.separator+"extent-config.xml";
		
		Reporter.loadXMLConfig(new File(reportConfigPath));
		Reporter.addStepLog("Author - Sanjeev R");
				
	}

}
