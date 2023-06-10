package genericLibraries;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility extends BaseClass{
	Actions action = new Actions(driver);

	public void dragAndDropp(WebElement src, WebElement destination) {
		action.dragAndDrop(src, destination).perform();
	}
	public void rightClick() {
		action.contextClick().perform();
	}
	public void rightClick(WebElement element) {
		action.contextClick(element).perform();
	}
	public void doubleclick() {
		action.doubleClick().perform();
	}
	public void doubleclick(WebElement element) {
		action.doubleClick(element).perform();
	}
	public void moveToElement(WebElement element) {
		action.moveToElement(element);
	}
	public void mouseHoverOnElement(WebElement element) {
		action.contextClick().perform();
	}
	public Select selectReference(WebElement dropdown) {
		Select select = new Select(dropdown);
		return select;
	}
	public void handlingDropDown(WebElement dropdown , String index) {
		Select select = new Select(dropdown);
		try {
			select.selectByVisibleText(index);
		}catch (Exception e) {
			select.selectByValue(index);
		}

	}
	public void handlingDropDown1(WebElement dropdown , int index) {
		Select select = new Select (dropdown);
		select.selectByIndex(index);
	}
	public void scrollingAction(int x , int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	public void clickonElement(int x , int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click()",driver);
	}
	public void enteringDataintoElement(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value'"+data+"'",element);
	}
	public void clearingDataFromElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("argument[0].' '",element);
	}
	public void switchingToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchingToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchingToFrame(String data) {
		driver.switchTo().frame(data);
	}
	public void switchingBackToMain() {
		driver.switchTo().defaultContent();
	}
	
	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	public void switchToWindow(Set<String> allWindowID, String targetWindowTitile) {
		for (String idd: allWindowID) {
			driver.switchTo().window(idd);
			if(targetWindowTitile.equalsIgnoreCase(driver.getTitle())) {
				break;
			}else {
				driver.close();
			}
		}
			
	}
}
