package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrenShot {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com");
		TakesScreenshot tc = (TakesScreenshot)driver;
		File photo = tc.getScreenshotAs(OutputType.FILE);
		String localTime = LocalTime.now().toString().replace(":", "-");
		File dest = new File("./ErrorShot/demo"+localTime+".png");
		FileUtils.copyFile(photo, dest);
		driver.quit();

	}
}
