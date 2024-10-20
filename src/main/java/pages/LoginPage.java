package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	WebDriver driver;
    private ElementUtils elementUtils;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(css ="#input-email")
	private WebElement emailField;
	
	@FindBy(css = "#input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMsg;

	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton);
		return new AccountPage(driver);
	}
	
	public boolean displayWarningMessage() {
		return elementUtils.displayStatusOfElement(warningMsg);
	}
}
