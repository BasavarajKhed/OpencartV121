package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven") //getting data provider from defferent class
	public void varify_loginDDT(String email,String pwd,String exp) {
		
		logger.info("****  Starting TC_003 LoginDDT ****");
		try {
		//homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);

		lp.clickLogin();

		// Myaccount Page

		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetpage = myacc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				Assert.assertTrue(true);
				myacc.clickLogout();
				}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")){
			
			if(targetpage==true) {
				Assert.assertTrue(false);
				myacc.clickLogout();
				}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****  Completed TC_003 LoginDDT ****");	
	}

}
