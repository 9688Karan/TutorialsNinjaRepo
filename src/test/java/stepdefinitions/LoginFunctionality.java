package stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginFunctionality {
	
	
	WebDriver driver;
	LoginPage lp;
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver=DriverFactory.getDriver();
		HomePage hp=new HomePage(driver);
	    hp.clickOnMyAccount();
	    hp.clickOnLogin();
	}

	@When("User has enteres valid email address {string} into the email field")
	public void user_has_enteres_valid_email_address_into_the_email_field(String validEmail) {
		lp=new LoginPage(driver);
		lp.enterEmailAddress(validEmail);
	  
	}

	@When("User has enteres valid password {string} into the password field")
	public void user_has_enteres_valid_password_into_the_password_field(String validPassword) {
	    lp.enterPassword(validPassword);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	    lp.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	   AccountPage ap=new AccountPage(driver);
		Assert.assertTrue(ap.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User has enteres invalid email address {string} into the email field")
	public void user_has_enteres_invalid_email_address_into_the_email_field(String invalidEmail) {
		driver.findElement(By.name("email")).sendKeys(invalidEmail);
	}

	@When("User has enteres invalid password {string} into the password field")
	public void user_has_enteres_invalid_password_into_the_password_field(String invalidPassword) {
		driver.findElement(By.name("password")).sendKeys(invalidPassword);
	}

	@Then("User should get a proper warning message about credential mismatch")
	public void user_should_get_a_proper_warning_message_about_credential_mismatch() {
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User do not entres email address into email field")
	public void user_do_not_entres_email_address_into_email_field() {
		driver.findElement(By.name("email")).sendKeys("");
	}

	@When("User do not enters password into password field")
	public void user_do_not_enters_password_into_password_field() {
		driver.findElement(By.name("password")).sendKeys("");
	}
	
	
}
