package utils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	Properties prop = new ConfigReader().intializeProperties();
	long duration = Long.parseLong(prop.getProperty("explicitWait"));
	
	public ElementUtils(WebDriver driver)
	{	
		this.driver = driver;
	}

	public void clickOnElement(WebElement element) {
		WebElement webElement = waitForElement(element);
		
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element, String text) {
		WebElement webElement = waitForElement(element);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);	
	}
	
	public WebElement waitForElement(WebElement element) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(duration));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element, String option) {
		WebElement webElement = waitForElement(element);
		
		Select select = new Select(webElement);
		select.selectByVisibleText(option);
	}
	
	public Alert waitForAlert() {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(duration));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void acceptAlert() {
		Alert alert = waitForAlert();
		alert.accept();
	}
	
	public void dismissAlert() {
		Alert alert = waitForAlert();
		alert.dismiss();
	}
	
	public void mouseHoverAndClick(WebElement element) {
		WebElement webElement = waitForVisibilityOfElement(element);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element) {
		WebElement webElement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(duration));
		webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void jsClick(WebElement element, long duration) {
		WebElement webElement = waitForVisibilityOfElement(element);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", webElement);
	}
	
	public void jsType(WebElement element, long duration,String text) {
		WebElement webElement = waitForVisibilityOfElement(element);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+text+"';", webElement);
	}
	
	public String getTextFromElement(WebElement element) {
		WebElement webElement = waitForVisibilityOfElement(element);
		return webElement.getText();
	}
	
	public Boolean displayStatusOfElement(WebElement element) {
		try {
			WebElement webElement = waitForVisibilityOfElement(element);
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
