package genericLibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLunchMultipleTimeWithMultipleData {
	@Test (dataProvider = "testdata",dataProviderClass = ExcelUtility.class)
	public void LunchingWithChangingData (String userName, String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demowebshop.tricentis.com/login");
		Thread.sleep(3000);
		
		driver.findElement(By.id("Email")).sendKeys(userName);
		Thread.sleep(3000);

		driver.findElement(By.id("Password")).sendKeys(password);
		Thread.sleep(3000);

		driver.close();
	}


}
