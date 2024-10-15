package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC0002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verifyLogin() {
		logger.info("********Starting Login page Test************");
		try {
		HomePage hp =new HomePage(driver);
		hp.clickMyaccount();
		logger.info("click on myaccount page");
		hp.clickLogin();
		logger.info("click on login Page");
		
		LoginPage lp =new LoginPage(driver);
		logger.info("Enter login details");
		lp.setEmail("xyz@gmail.com");
		lp.setPassword("test@123");
		lp.clickbtn();
		
		MyAccountPage myact=new MyAccountPage(driver);
		boolean targetpage=myact.MyaccountPageExist();
		Assert.assertEquals(targetpage, true,"login fail");
	}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****Finish TC002 _Login Test*********");
		}

}
