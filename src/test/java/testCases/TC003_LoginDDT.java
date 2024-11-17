package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC003_LoginDDT extends BaseClass {

	
	@Test(dataProvider="LoginData", dataProviderClass=DataProvider.class, groups={"Datadriven", "master"})
	public void verify_loginDDT (String email, String pwd, String exp)
	{
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Login
		LoginPage lp=new LoginPage(driver); 
		lp.setEmail(email); 
		lp.setPass(pwd);
		lp.clickLoginButton();
		
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver); 
		boolean targetPage=macc.isMyAccountPageExists();
		
		
		/*Data is valid - login success - test pass - logout
		                  login Failed  - test fail
		                  
		  Data is Invalid -login success - test fail - logout
		                   login Failed  - test pass      */          
		 
		
		if(exp.equalsIgnoreCase("valid"))		
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
			   Assert.assertTrue(false);
			}
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
	  catch(Exception e)
		{
				Assert.fail();
		}
	}	
}
