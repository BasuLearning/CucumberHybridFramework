package factory;


import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;
import utils.ConfigReader;

public class DriverFactory {

	static WebDriver driver=null;
	
	public static WebDriver intializeBrowser(String browser) {
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
