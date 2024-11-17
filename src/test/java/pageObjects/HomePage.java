package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='Live video']")
	private WebElement btnClickMyAccount;
	
	@FindBy(xpath = "//span[text()='Live video']")
	private WebElement btnclickRegister;
	
	@FindBy(xpath = "//span[text()='Live video']")
	private WebElement msgConfirmation;
	
	@FindBy(xpath = "//span[text()='Live video']")
	private WebElement btnClickLogin;
	
	public void clickMyAccount()
	{
		btnClickMyAccount.click();
	}
	
	public void clickRegister()
	{
		btnclickRegister.click();
	}
	
	public void clickLogin()
	{
		btnClickLogin.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return(msgConfirmation.getText());   // this is just returning gettext() value
		}
		catch (Exception e)
		{
			return(e.getMessage()) ; 	
		}
	}	
}
