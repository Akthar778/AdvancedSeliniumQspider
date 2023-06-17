package genericLibraries;

import java.io.File;
import java.time.LocalTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility extends BaseClass implements PropertiFilesInterface{
	Actions action = new Actions(driver);
	/***
	 * this is method is used for drang and drop purpose 
	 * @param src
	 * @param destination
	 */
	public void dragAndDropp(WebElement src, WebElement destination) {
		action.dragAndDrop(src, destination).perform();
	}

	public void rightClick() {
		/***
		 * this method is used to perform right click action 
		 */
		action.contextClick().perform();
	}
	public void rightClick(WebElement element) {
		/***
		 * this method used for perform right click operations with parameters
		 */
		action.contextClick(element).perform();
	}
	public void doubleclick() {
		/***
		 * this method is used to perform doublick click on element 
		 */
		action.doubleClick().perform();
	}
	public void doubleclick(WebElement element) {
		/***
		 * this method is used to double click with parameters 
		 */
		action.doubleClick(element).perform();
	}
	public void moveToElement(WebElement element) {
		/***
		 * this method is used for mouse Hover
		 */
		action.moveToElement(element);
	}
	public void mouseHoverOnElement(WebElement element) {
		/***
		 * this method is used for mouse hover on element with passing an parameters
		 */
		action.contextClick().perform();
	}
	public Select selectReference(WebElement dropdown) {
		/***
		 * retrun the dropdown value  
		 */
		Select select = new Select(dropdown);
		return select;
	}
	public void handlingDropDown(WebElement dropdown , String index) {
		/***
		 * This method is used to handaling the dropdown 
		 * mainly for selectbyVisableText method
		 * & SelectByValue method 
		 */
		Select select = new Select(dropdown);
		try {
			select.selectByVisibleText(index);
		}catch (Exception e) {
			select.selectByValue(index);
		}

	}
	public void handlingDropDown1(WebElement dropdown , int index) {
		/***
		 * This method is used to handaling the dropdwon which is having
		 * index value in dropdown
		 */
		Select select = new Select (dropdown);
		select.selectByIndex(index);
	}
	public void scrollingAction(int x , int y) {
		/***
		 * scroll the webpage by using scrollBy
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	public void clickonElement(int x , int y) {
		/***
		 *Single click by using javascript executor
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click()",driver);
	}
	public void enteringDataintoElement(WebElement element, String data) {
		/***
		 * It's act like sendKeys 
		 * basically used to send the data into filed
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value'"+data+"'",element);
	}
	public void clearingDataFromElement(WebElement element) {
		/***
		 * It's simular to clear 
		 * It's used to clear the text into filed
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("argument[0].' '",element);
	}
	public void switchingToFrame(int index) {
		/***
		 * It's used to Switch control into frame by using integer 
		 */
		driver.switchTo().frame(index);
	}
	public void switchingToFrame(WebElement element) {
		/***
		 * It's used to Switch control into frame by using element
		 */
		driver.switchTo().frame(element);
	}
	public void switchingToFrame(String data) {
		/***
		 * It's used to Switch control into frame by using string
		 */
		driver.switchTo().frame(data);
	}
	public void switchingBackToMain() {
		/***
		 * It's used to Switch control to back to webpage (default page)
		 */
		driver.switchTo().defaultContent();
	}

	public Alert switchToAlert() {
		/***
		 * Switch the control into AlertPopup & Return the alert 
		 */
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	public void switchToWindow(Set<String> allWindowID, String targetWindowTitile) {
		/***
		 * its used to change mouse control into newpage or newtab
		 */
		for (String idd: allWindowID) {
			driver.switchTo().window(idd);
			if(targetWindowTitile.equalsIgnoreCase(driver.getTitle())) {
				break;
			}else {
				driver.close();
			}
		}

	}
	public String takingScreenShot() {
		/***
		 * its used to take screenShot 
		 */
		TakesScreenshot ts= (TakesScreenshot) driver;
		File photo = ts.getScreenshotAs(OutputType.FILE);
		String ldt = LocalTime.now().toString().replace(":", "-");
		String path = System.getProperty("user.dir")+commondata+" "+ldt+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(photo, destination);

		}
		catch (Exception e) {
			e.printStackTrace();		
		}
		return path;

	}

}
