package creteOrgWithTypeAndindustryTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerLogoutProblem {
	public static void main(String[] args) throws InterruptedException {
		Random random= new Random();
		int randomNumber=random.nextInt();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		if(driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM"))
			System.out.println("login page displayed");
		else 
			System.out.println("not diplayed");

		WebElement userName = driver.findElement(By.name("user_name"));
		userName.sendKeys("admin");


		driver.findElement(By.name("user_password")).sendKeys("0000");

		driver.findElement(By.id("submitButton")).submit();

		//problem solving here
		try{
			
			
			WebElement hoverAction = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			Actions a = new Actions(driver);
			Thread.sleep(3000);

			a.moveToElement(hoverAction).perform();
			System.out.println("log out element identified ");
		}catch (Exception e) {
			System.out.println("log out problem");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		
		
		



	}
}
