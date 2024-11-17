package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//to acheive the reusibility we have created base class for all common component/functionality
public class BaseClass {

public WebDriver driver;   //for webdriver
public Properties p;      // for property file which present inside config.properties


	
	@BeforeClass(groups={"master", "Sanity", "Regression", "Datadriven"})// this method needs in every test case that's why grouped in all
	@Parameters({"os", "browser"})    //for cross browser testing
	public void setup(String os, String browser) throws FileNotFoundException, IOException  //this to string variable which accepts value
	{
		//Loading config.properties file
		FileReader file=new  FileReader("./src//test//resources//config.properties");
		p=new Properties(); 
		p.load(file);
		

		//for remote running
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 {
		   DesiredCapabilities capabilities=new DesiredCapabilities();
		
		   	//os
			if (os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform (Platform.WIN11);
			}
		
			else if (os.equalsIgnoreCase("mac"))
			{
			 capabilities.setPlatform (Platform.MAC);
			}
			else
			{
			System.out.println("No matching os");
			return;
			}

		//browser
		switch(browser.toLowerCase())
		{
		case "chrome"	: capabilities.setBrowserName("chrome");		break;
		case "edge"		: capabilities.setBrowserName("MicrosoftEdge");	break;
		case "firefox"	: capabilities.setBrowserName("edge");			break;
		default: System.out.println("No matching browser"); 			return;
		}
		
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
			if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(browser.toLowerCase())
				{
				 case "chrome"  : driver=new ChromeDriver();   break;
				 case "edge"    : driver=new EdgeDriver();     break;
				 case "firefox" : driver=new FirefoxDriver();  break;
				 default 		: System.out.println("Invalid browser Name"); return; //Totaly Exit from the execution return is for if the browser name is invalid still need to exit the execution.
				}
			}
		
		
		driver=new ChromeDriver();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(p.getProperty("appURL2")); //reading URL from properties file
		driver.manage().window().maximize();
	}
	  }
	@AfterClass (groups={"master", "Sanity", "Regression", "Datadriven"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString() //this method is generating random returning same.
	{
		String Randomstring = RandomStringUtils.randomAlphabetic(3);
		return Randomstring;
	}
	
	public String randomNumber() //this method is generating random number and returning same.
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
}
