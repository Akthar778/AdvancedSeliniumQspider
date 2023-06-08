package xmlParametrization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import graphql.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class xmlParametarization {
	@Test 
	public void SwiggyTest(XmlTest xml) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(xml.getParameter("url"));
		
		long time = Long.parseLong(xml.getParameter("time"));		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
		WebElement logo = driver.findElement(By.xpath("//*[name()='svg']"));
		
		Assert.assertTrue(logo.isDisplayed());
		
		driver.close();
		
	}

}
