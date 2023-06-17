package annitaction;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AnnotactionClass extends baseClass {

	@Test
	public void loginWithValidCredintials() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("heelo@123");
		driver.findElement(By.id("Password")).sendKeys("password1");
		driver.findElement(By.className("login-button")).click();
		Thread.sleep(3000);

		
	}
	@Test
	public void loginWithInValidCredintials() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("invalidPassword");
		driver.findElement(By.id("Password")).sendKeys("invalid password");
		driver.findElement(By.className("login-button")).click();
		Thread.sleep(3000);

		
	}
}
