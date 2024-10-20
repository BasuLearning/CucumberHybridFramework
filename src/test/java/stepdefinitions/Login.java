package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	
	
	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
	}
	
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText) {
		loginPage.enterEmailAddress(emailText);
	}
	
	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		loginPage.enterPassword(passwordText);	
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		accountPage.displayOfMyAccountHeader();
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());  
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);	
	}

	@Then("User should get a warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.displayWarningMessage());
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field(){
		loginPage.enterEmailAddress("");	
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field(){
		loginPage.enterPassword(""); 	
	}
	
}
