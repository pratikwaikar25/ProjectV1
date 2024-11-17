package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
// This Is a reusable component of all the POM Classes
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//This is constructor part to invoke driver to each POM classes 
	//by extending this class
	
	
	
	
}
