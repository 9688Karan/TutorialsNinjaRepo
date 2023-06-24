package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement emailField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginButton;
	
	public void enterEmailAddress(String validEmail) {
		emailField.sendKeys(validEmail);
	}
	public void enterPassword(String validPassword) {
		passwordField.sendKeys(validPassword);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
}
