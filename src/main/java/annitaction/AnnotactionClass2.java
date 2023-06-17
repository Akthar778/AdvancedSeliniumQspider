package annitaction;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AnnotactionClass2 extends baseClass {

	@Test
	public void loginWithValidCredintials3() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("test case 2");
		driver.findElement(By.id("Password")).sendKeys("password1");
		driver.findElement(By.className("login-button")).click();
		Thread.sleep(3000);

		
	}
	@Test
	public void loginWithInValidCredintials4() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("test case 4");
		driver.findElement(By.id("Password")).sendKeys("invalid password");
		driver.findElement(By.className("login-button")).click();
		Thread.sleep(3000);

		
	}
}
