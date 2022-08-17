package pomTestCasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomMethodPages.DashboardPage;
import pomMethodPages.LoginPage;
import pomMethodPages.LoginPageAdvance;

public class BaseTest {
	public static WebDriver driver;

	LoginPage lp;
	public LoginPageAdvance lpa;
	public DashboardPage dp;
	
	@BeforeSuite
	public void initBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		//driver = new ChromeDriver();
		
        WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
//		
		options.addArguments("--start-maximized");
//		
		//options.addArguments("--incognito");
		
		//options.addArguments("--headless");
		
		driver = new ChromeDriver(options);

		//driver.manage().window().maximize();

		driver.get("https://kite.zerodha.com/");
	}


	@BeforeClass
	public void createObject()
	{
		 lp = new LoginPage(driver);
		 
		 lpa = new LoginPageAdvance(driver);

		 dp = new DashboardPage(driver);
	}


//	@AfterSuite
//	public void tearDown()
//	{
//		driver.quit();
//	}
//	
}
