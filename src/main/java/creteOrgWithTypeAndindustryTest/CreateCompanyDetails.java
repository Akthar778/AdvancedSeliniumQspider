package creteOrgWithTypeAndindustryTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompanyDetails {

	@SuppressWarnings("unlikely-arg-type")
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

		if(driver.getTitle().contains("Home"))
			System.out.println("home page is diplayed ");
		else
			System.out.println("home page is not displayed ");

		driver.findElement(By.linkText("Organizations")).click();

		if(driver.getTitle().contains("Organizations"))
			System.out.println("org page is displayed");
		else
			System.out.println("org page is not displayed");



		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

		WebElement CreateNewOrganizationTitle = driver.findElement(By.xpath("//span[contains(.,'Creating New Organization')]"));

		if(CreateNewOrganizationTitle.equals("Creating New Organization"))
			System.out.println("create a new org page is displayed sucessfully");
		else
			System.out.println("Create new org page is not displayed");

		String orgName="tcs"+randomNumber;

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		//dropDowns
		WebElement indusId = driver.findElement(By.name("industry"));
		Select select= new Select(indusId);
		select.selectByValue("Food & Beverage");


		WebElement type = driver.findElement(By.name("accounttype"));
		Select select2= new Select(type);
		select2.selectByValue("Prospect");

		//save the company info

		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])")).click();
		
		
		Thread.sleep(2000);

		 String NewOrgInfoHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgName.contains(NewOrgInfoHeader))
			System.out.println("Org is created");
		else
			System.out.println("org is not created");

		//logout 
		//logout is not working 

		WebElement logoutMouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		Actions ac = new Actions(driver);
		ac.moveToElement(logoutMouseHover);
















		//		Thread.sleep(3000);
		//		driver.close();

	}

}
