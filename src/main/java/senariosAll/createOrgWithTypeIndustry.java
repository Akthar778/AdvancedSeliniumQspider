package senariosAll;

import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.DriverFactory;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrgWithTypeIndustry {
	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		int randomeNUmber = random.nextInt();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		WebElement userName = driver.findElement(By.name("user_name"));
		userName.sendKeys("admin");

		try {//login page 

			driver.findElement(By.name("user_password")).sendKeys("0000");

			driver.findElement(By.id("submitButton")).submit();

			driver.findElement(By.linkText("Organizations")).click();
		}catch (Exception e) {
			System.out.println("log in problem ");
		}
		//clicking the org moduled
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

		WebElement dropdown = driver.findElement(By.xpath("//select[@name=\"industry\"]"));

		Select select = new Select(dropdown);
		select.selectByValue("Insurance");

		WebElement orgName = driver.findElement(By.name("accountname"));

		String orgnameValues= "tcs"+ randomeNUmber;

		orgName.sendKeys(orgnameValues);

		WebElement SaveButton = driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]\r\n"));

		SaveButton.click();

		//sign out

		WebElement logout_symbol_locator = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		Actions action = new Actions(driver);
		action.moveToElement(logout_symbol_locator);
		Thread.sleep(3000);
		
		//click singout button 
		WebElement singOutButton = driver.findElement(By.xpath("//a[normalize-space()='Sign Out']"));
		singOutButton.click();
		
		Thread.sleep(3000);
		driver.quit();

		
		











	}

}
