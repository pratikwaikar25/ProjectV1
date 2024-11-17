package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	//Constructor
		public RegistrationPage(WebDriver driver)
		{
			super(driver);        // this is sending driver to Parentclass for invoking webdriver
		}
	
	@FindBy(xpath="//input[@id='input-confirm']") 	
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-confirm']") 	
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-telephone']") 
	private WebElement txtTelephone;

	@FindBy(xpath="//input[@id='input-password']")
	private WebElement txtPassword;

	@FindBy(xpath="//input[@id='input-confirm']") 
	private WebElement txtConfirmPassword;

	@FindBy(xpath="//input[@name='agree']")
	private WebElement chkPolicy;

	@FindBy(xpath="//input[@value='Continue']")
	private WebElement btnContinue;
	
	@FindBy(xpath = "//h1 [normalize-space()='Your Account Has Been Created!']") 
	private WebElement msgConfirmation;
	
	
	public void setFirstName (String fname) 
	{ 
		txtFirstName.sendKeys(fname);
	
	}
	public void setLastName(String lname) 
	{ 
		txtLastName.sendKeys(lname);
	}
	public void setEmail (String email) 
	{ 
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone (String tel) 
	{ 
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd) 
	{ 
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword (String pwd) 
	{ 
		txtPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	

	public String getConfirmationMsg() 
	{ 
		try 
		{
			return (msgConfirmation.getText()); //this function is returning text of element
		}
		catch (Exception e) 
		{
			return (e.getMessage()); //handling exception if any occurs 
		}
	
} 
}
