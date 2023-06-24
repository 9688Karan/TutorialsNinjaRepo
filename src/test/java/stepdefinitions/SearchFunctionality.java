package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFunctionality {

	WebDriver driver;
	@Given("User opens the application")
	public void user_opens_the_application() {
	    driver=DriverFactory.getDriver();
	}

	@When("User enteres valid product {string} into search box field")
	public void user_enteres_valid_product_into_search_box_field(String validProduct) {
	    driver.findElement(By.xpath("//input[@name='search']")).sendKeys(validProduct);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	    driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

	@Then("User should get valid product displayed in search result")
	public void user_should_get_valid_product_displayed_in_search_result() {
	    Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("User enteres invalid product {string} into search box field")
	public void user_enteres_invalid_product_into_search_box_field(String invalidProduct) {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(invalidProduct);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	    Assert.assertTrue(driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).isDisplayed());
	}

	@When("User dont enteres any product name into search box field")
	public void user_dont_enteres_any_product_name_into_search_box_field() {
	    //Intentionally kept blank
	}
}
