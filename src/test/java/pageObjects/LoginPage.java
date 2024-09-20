package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//*[@id='input-email']")
	WebElement tctEmailAddress;
	@FindBy(xpath = "//*[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement btnLogin;

	public void setEmail(String email) {
		tctEmailAddress.sendKeys(email);
		
	
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		
	}


	public void clickLogin() {
		btnLogin.click();

	}
}
