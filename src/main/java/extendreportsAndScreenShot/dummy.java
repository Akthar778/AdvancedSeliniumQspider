package extendreportsAndScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class dummy {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TakesScreenshot tc = (TakesScreenshot)driver;
		File photo = tc.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "./ErrorShot/facebookdemo.png";

		File file = new File(path);
		FileUtils.copyFile(photo, file);

		ExtentReports report1 = new ExtentReports();
		ExtentSparkReporter report = new ExtentSparkReporter("./reports/swiggy1.png");
		report1.attachReporter(report);
		ExtentTest logger = report1.createTest("testcase check2");

		// logger.log(Status.INFO,"this step info");
		logger.log(Status.PASS,"this step info");
		logger.log(Status.FAIL, "this step is fail");
		//   logger.log(Status.SKIP, "this step is skip");

		logger.addScreenCaptureFromPath(path);

		ExtentTest logger1 = report1.createTest("testcase check3");

		logger1.log(Status.INFO,"this step info");
		logger1.log(Status.PASS,"this step info");
		logger1.log(Status.FAIL, "this step is fail");
		logger1.log(Status.SKIP, "this step is skip");

		logger1.addScreenCaptureFromPath(path);
		report1.flush();






	}

}
