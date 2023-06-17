package annitaction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	//setp 1 base class
	public WebDriver driver;
	
	@BeforeClass
	public void setUpTheBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}
	
	@AfterSuite
	public void AfterClass() {
		System.out.println("afer suite");
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("after test");
	}
	
	

}
