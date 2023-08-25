package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddEmployeePage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.PIMPage;

public class BaseClass {
	public static WebDriver driver;
	public PropertyUtility property;
	public LoginPage login;
	public HomePage home;
	public PIMPage pimpage;
	public  AddEmployeePage addemployeepage;
	public WebDriverUtility utility;


	@BeforeClass
	public void launchingBrowser() {

		utility=new WebDriverUtility();
		property=new PropertyUtility();
		if(property.readingDataFromProprtyFile("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else  if (property.readingDataFromProprtyFile("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void navigatingToApplication() {
		login=new LoginPage(driver);
		home=new HomePage(driver);
		pimpage=new PIMPage(driver);
		addemployeepage=new AddEmployeePage(driver);
		driver.get(property.readingDataFromProprtyFile("url"));
		login.loginToApplication(property.readingDataFromProprtyFile("username"), property.readingDataFromProprtyFile("password"));
	}
	@AfterMethod
	public void signOutFromApplication() {
		home.loggingOut();
		System.out.println("signed out");
	}
	@AfterClass
	public void closingTheBrowser() {
		driver.quit();
	}
}
