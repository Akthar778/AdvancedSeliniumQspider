package senariosAll;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.fasterxml.jackson.core.sym.Name;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario3 {
	public static void main(String[] args) throws InterruptedException {
		//login click contacts create contacts logout

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://localhost:8888/");

		try {//login page 
			driver.findElement(By.name("user_name")).sendKeys("admin");


			driver.findElement(By.name("user_password")).sendKeys("0000");

			driver.findElement(By.id("submitButton")).submit();

			driver.findElement(By.linkText("Organizations")).click();
		}catch (Exception e) {
			System.out.println("log in problem ");
		}


		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();

		Random randomNumber = new Random();
		int randomnumber1 = randomNumber.nextInt(1000);
		driver.findElement(By.name("lastname")).sendKeys("niyaz"+randomnumber1);

		driver.findElement(By.name("button")).click();

		WebElement userName1 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(userName1).perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();


		//driver.close();
	}

}
