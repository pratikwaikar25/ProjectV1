package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC002_RegistrationVerification extends BaseClass {

		
	@Test(groups={"Regression", "master"})
	public void verify_account_registration()
	{
		/* This will works only one time due to every time needed new email, ph no.
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		RegistrationPage regpage=new RegistrationPage(driver);
		regpage.setFirstName("shantanu"); 
		regpage.setLastName("David");
		regpage.setEmail("abc@gmail.com"); // randomly generated the emai
		regpage.setTelephone("23123123");
		//String password=randomAlphaNumeric();
		regpage.setPassword("xyz12356"); regpage.setConfirmPassword("xyz123456");
		regpage.setPrivacyPolicy();
		regpage.clickContinue();		
		
		String cnfMsg = regpage.getConfirmationMsg();
		Assert.assertEquals(cnfMsg, "Your Account Has Been Created!");*/
		
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		RegistrationPage regpage=new RegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase()+"sh"); regpage.setLastName("David");
		regpage.setEmail(randomString()+"@gmail.com"); // randomly generated the email
		
		String Pass=randomNumber()+"@"+randomString();
		
		regpage.setTelephone(randomNumber());
		//String password=randomAlphaNumeric();
		regpage.setPassword(Pass); regpage.setConfirmPassword(Pass);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();		
		
		String cnfMsg = regpage.getConfirmationMsg();
		Assert.assertEquals(cnfMsg, "Your Account Has Been Created!");	
	}
	
	
}
