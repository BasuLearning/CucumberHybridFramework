package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement myAccountHeader; 
	
	public boolean displayOfMyAccountHeader()
	{
		return elementUtils.displayStatusOfElement(myAccountHeader);
	}
}
