package senariosAll;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario4 {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");



		try {//login page 
			WebElement userName = driver.findElement(By.name("user_name"));
			userName.sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("0000");

			driver.findElement(By.id("submitButton")).submit();
			System.out.println("log in succesfully");
		}catch (Exception e) {
			System.out.println("log in problem ");
		}
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		Random random = new Random();
		int randomnumber = random.nextInt(1000);
	
		driver.findElement(By.name("lastname")).sendKeys("akthar"+randomnumber);

		
		
		
//		driver.findElement(By.name("button")).click();
		
		
		
		//logout
		

//		WebElement userName1 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//
//		Actions action = new Actions(driver);
//		action.moveToElement(userName1).perform();
//
//		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();

		
		
	}

}
