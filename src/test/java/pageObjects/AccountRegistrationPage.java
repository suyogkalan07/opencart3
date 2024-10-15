package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement chkpolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btncotinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement confmsg;
	
	//actions method
	public void setFirstname(String firstname) {
		txtfirstname.sendKeys(firstname);
	}
	
	public void setLastname(String lname) {
		txtlastname.sendKeys(lname);
	}
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txttelephone.sendKeys(telephone);
	}
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void setConfpassword(String confpass) {
		txtConfPassword.sendKeys(confpass);
	}
	public void clickpolicy() {
		chkpolicy.click();
	}
	
	public void clickbtn() {
		btncotinue.click();
	}
	
	public String getconfmsg() {
		try{
			return(confmsg.getText());
		}
		catch (Exception e) {
			return(e.getMessage());
		}
		
	}
	

}
