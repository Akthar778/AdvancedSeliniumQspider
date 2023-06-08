package senariosAll;

import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.DriverFactory;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

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

		driver.findElement(By.name("user_password")).sendKeys("0000");

		driver.findElement(By.id("submitButton")).submit();

		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

		WebElement dropdown = driver.findElement(By.xpath("//select[@name=\"industry\"]"));


		Select select = new Select(dropdown);
		select.selectByValue("Insurance");

		//		Thread.sleep(3000);
		//		driver.close();

	}

}
