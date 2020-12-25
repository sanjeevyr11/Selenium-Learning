package resource;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class TestBase {
    Properties prop;
	public TestBase()  {
		
		String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"resource"+File.separator+"config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(path));
		
		prop = new Properties();
		prop.load(fis);
		} catch (Exception e) {
			
		}
	}
	
	public String getProperty(String key) {
		String value = prop.getProperty(key);
		return value;
	}
}
