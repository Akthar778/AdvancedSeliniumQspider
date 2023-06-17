package genericLibraries;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import annitaction.baseClass;

public class ScreenShotUtility extends baseClass implements PropertiFilesInterface {
	void screenShotUtility (String parametor) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File photo = screenshot.getScreenshotAs(OutputType.FILE);
		
		String ldt = LocalDateTime.now().toString().replace(":", "-");
		String destination = System.getProperty("user.dir")+commondata+parametor+" "+ldt+".png";
		File dest = new File(destination);
		
		
	}

}
