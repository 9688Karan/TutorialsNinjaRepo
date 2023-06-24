package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterFunctionality {

	WebDriver driver;
	@Given("User navigates to register account page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
	}

	@When("User enters below detail into the field")
	public void user_enters_below_detail_into_the_field(DataTable dataTable) {
		Map<String,String>dataMap=dataTable.asMap(String.class,String.class);
	    driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
	    driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	    driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
	    driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	    driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	    driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}

	@When("User selects privacy policy checkbox")
	public void user_selects_privacy_policy_checkbox() {
	    driver.findElement(By.xpath("//input[@name='agree']")).click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
	    driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
	    Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
	}

	@When("User selects yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	    driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	}

	@Then("Account should get a proper warning about duplicate email")
	public void account_should_get_a_proper_warning_about_duplicate_email() {
	    Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enteres any details into field")
	public void user_dont_enteres_any_details_into_field() {
	    //Intentionally kept blank
	}

	@Then("User should get a proper warning message for every mandetory field")
	public void user_should_get_a_proper_warning_message_for_every_mandetory_field() {
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: You must agree to the Privacy Policy!"));
	    Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText());
	    Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div")).getText());
	    Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@name='email']/following-sibling::div")).getText());
	    Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div")).getText());
	    Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@name='password']/following-sibling::div")).getText());
	}
}
