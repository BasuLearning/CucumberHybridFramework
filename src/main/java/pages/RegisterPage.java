package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField; 
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement selectPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarning;
	
	
	public void enterFirstName(String firstNameText)
	{
		elementUtils.typeTextIntoElement(firstNameField,firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		elementUtils.typeTextIntoElement(lastNameField,lastNameText);
	}
	
	public void enterEmail(String emailText)
	{
		elementUtils.typeTextIntoElement(emailField,emailText);
	}
	
	public void enterTelephone(String telephoneText)
	{
		elementUtils.typeTextIntoElement(telephoneField,telephoneText);
	}
	
	public void enterPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordField,passwordText);
	}
	
	public void enterPasswordConfirm(String passwordConfirmText)
	{
		elementUtils.typeTextIntoElement(passwordConfirmField,passwordConfirmText);
	}
	
	public void selectPrivatePolicy()
	{
		elementUtils.clickOnElement(selectPrivacyPolicy);
	}
	
	public AccountSuccessPage clickOnContinueButton()
	{
		elementUtils.clickOnElement(continueButton);
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsLetterOption()
	{
		elementUtils.clickOnElement(yesNewsLetterOption);
	}
	
	public String getWarningMessageText()
	{
		return elementUtils.getTextFromElement(warningMessage);
	}
	
	public String getFirstNameWarningText()
	{
		return elementUtils.getTextFromElement(firstNameWarning);
	}
	
	public String getLastNameWarningText()
	{
		return elementUtils.getTextFromElement(lastNameWarning);
	}
	
	public String getEmailWarningMessageText()
	{
		return elementUtils.getTextFromElement(emailWarning);
	}
	
	public String getTelephoneWarningText()
	{
		return elementUtils.getTextFromElement(telephoneWarning);
	}
	
	public String getPasswordWarningText()
	{
		return elementUtils.getTextFromElement(passwordWarning);
	}
}
