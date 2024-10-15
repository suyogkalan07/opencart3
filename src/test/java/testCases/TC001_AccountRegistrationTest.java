package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void verifyAccountRegistrationTest() {
		
		try {
		logger.info("*****Account Registration test start*****");
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Click on Myaccount link");
		hp.clickRegister();
		logger.info("click on Register link");
		
		logger.info("Enter Customer information");
		AccountRegistrationPage page=new AccountRegistrationPage(driver);
		page.setFirstname(randomString().toUpperCase());
		page.setLastname(randomString().toUpperCase());
		page.setemail(randomString()+"@gmail.com");
		page.setTelephone(randomNumber());
		
		String password=randomStringNumber();
		page.setPassword(password);
		page.setConfpassword(password);
		
		page.clickpolicy();
		page.clickbtn();
		logger.info("verify the confirmation message");
		if(page.getconfmsg().equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed.....");
			Assert.fail();
		}
		
		String confirmation_msg=page.getconfmsg();
		//Assert.assertEquals(confirmation_msg, "Your Account Has Been Created!!");
		logger.info("test passed");
		
		}catch (Exception e) {
			logger.error("Test failed");
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
		logger.info("****** Finished Account Registration test******");
	}
	

}
