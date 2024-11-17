package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);        // this is sending driver to Parent class for invoking webdriver
	}
	
	 @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	 private WebElement txt_Email;
	
	public boolean isMyAccountPageExists() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void clickLogout() {
		// TODO Auto-generated method stub
		
	}
	
}
