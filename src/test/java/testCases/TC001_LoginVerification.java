package testCases;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
 

public class TC001_LoginVerification extends BaseClass {
		
	@Test(groups={"Sanity", "master"})
	public void verfify_login() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setEmail("pratikwaikar10@gmail.com");
		Thread.sleep(2000);
		lp.setPass("Paya@1234");
		lp.clickLoginButton();
		
		HomePage hp=new HomePage(driver);
		String Cnfmsg = hp.getConfirmationMsg();
		Assert.assertEquals(Cnfmsg, "Live video");
	}
}
