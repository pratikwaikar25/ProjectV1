package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{

	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);        // this is sending driver to Parentclass for invoking webdriver
	}
	
	//Locators
   @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
   private WebElement txt_Email;
   
   @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]") 
   private WebElement txt_Pass;
   
   @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[3]/button[1]") 
   private WebElement btn_login;
 
   
   //Action Methods
   public void setEmail(String email)
   {
	   txt_Email.sendKeys(email);
   }
   
   public void setPass(String pass)
   {
	   txt_Email.sendKeys(pass);
   }
   
   public void clickLoginButton()
   {
	   btn_login.click();
   }
 
}
