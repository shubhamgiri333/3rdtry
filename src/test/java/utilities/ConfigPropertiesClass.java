package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigPropertiesClass {

	public static String readConfigData(String datatoberead) throws IOException 
	{
		Properties prop = new Properties();
		
		String path = System.getProperty("user.dir")+"\\config.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		prop.load(fis);
		
		String value = prop.getProperty(datatoberead);
		
		System.out.println(value);
		
		return value;	
	}
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Properties prop = new Properties();
		
		String path = System.getProperty("user.dir")+"\\config.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		prop.load(fis);
		
		String url = prop.getProperty("testsiteurl");
		
		System.out.println(url);
		
		driver.get(url);
		
		
		
		
	}

}
