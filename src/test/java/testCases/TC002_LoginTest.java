package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void varify_login() {
		logger.info("***TC002_LoginTest***");
		try {
			// Homepage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));

			lp.clickLogin();

			// Myaccount Page

			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetpage = myacc.isMyAccountPageExists();
			Assert.assertTrue(targetpage); // Assert.assertEquals(targetpage, true,"Login failed");

		}

		catch (Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC002_LoginTest***");
	}
}
