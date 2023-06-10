package senariosAll;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogoutApplication {
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

		WebElement userName1 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		Actions action = new Actions(driver);
		action.moveToElement(userName1).perform();

		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();





	}		
}
