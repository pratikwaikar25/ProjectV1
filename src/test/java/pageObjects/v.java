package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class v  {
public static void main(String[] args)
{
	
	/*WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pratikwaikar10@gmail.com");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Paya@1234");
	driver.findElement(By.xpath("//button[text()='Log in']")).click();
	
	Thread.sleep(2000);
	String T = driver.findElement(By.xpath("//span[text()='Live video']")).getText();
	
	System.out.println(T); */
	
	System.out.println(randomNumber());
	System.out.println(randomNumber());
		
}
public static String randomNumber()
{
	String generatedNumber=RandomStringUtils.randomNumeric(10);
	return generatedNumber;

}

}
