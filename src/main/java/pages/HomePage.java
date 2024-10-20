package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	WebDriver driver ;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;	
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDownMenu;
	 
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public void clickOnMyAccount()
	{
		elementUtils.clickOnElement(myAccountDropDownMenu);
	}
	
	public LoginPage selectLoginOption()
	{
		elementUtils.clickOnElement(loginOption);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption()
	{
		elementUtils.clickOnElement(registerOption);
		return new RegisterPage(driver);
	}
	
	public void enterValidProductIntoSearchBox(String product)
	{
		elementUtils.typeTextIntoElement(searchBoxField,product);
	}
	
	public SearchResultPage clickOnSearchButton()
	{
		elementUtils.clickOnElement(searchButton);
		return new SearchResultPage(driver);
	}
}
