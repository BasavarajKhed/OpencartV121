package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

//import org.apache.logging.log4j.LogManager;  //log4j
//import org.apache.logging.log4j.Logger;      //log4j
public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void varify_account_registration() {

		logger.info("****Starting TC001_AccountRegistrationTest****");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on Myaccount link...");
			hp.clickRegister();

			logger.info("Clicked on Resister link...");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing customer details ...");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("Validating expected message...");

			String congmsg = regpage.getConfirmation();

			if (congmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}

//			Assert.assertEquals(congmsg, "Your Account Has Been Created!!!");
		} catch (Exception e) {

			Assert.fail();

		}
		logger.info("****Finished TC001_AccountRegistrationTest****");
	}

}
