package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreeenshot {
	
	
	
	public static String  captureScreenShotWithPath(WebDriver Driver, String filename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)Driver;

		 File source = ts.getScreenshotAs(OutputType.FILE);

	
		// String path = "C:\\Users\\Ganeshital\\eclipse-workspace\\Selenium\\src\\findelements\\captureScreenshot\\"+filename+".png";

		String path = System.getProperty("user.dir")+"\\SCREENSHOTS\\"+filename+".png";	
		 
		
		File destination = new File(path);

		FileHandler.copy(source, destination);
		return path;
		
	}
	
	
	
public static void main(String[] args) throws IOException {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver Driver=new ChromeDriver();
		
		Driver.manage().window().maximize();
		
		Driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement username = Driver.findElement (By.id("txtUsername"));
		username.sendKeys("Admin");
		
		WebElement passward = Driver.findElement(By.id("txtPassword"));
		passward.sendKeys("admin123");
		
		WebElement login = Driver.findElement(By.name("Submit"));
		
		login.click();
		
		 captureScreenShotWithPath(Driver,"abcd");
		
//		TakesScreenshot ts = (TakesScreenshot)Driver;
//		
//		 File source = ts.getScreenshotAs(OutputType.FILE);
//		
//		String path=("C:\\Users\\Ganeshital\\Pictures\\Screenshots\\\\orangelogin.png");
//		
//        File destination = new File(path);
//		
//		FileHandler.copy(source, destination);
}
}
