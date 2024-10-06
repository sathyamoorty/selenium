package invalid;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom.WaitUtility;
import takescreenshot.ScreenShot;

public class InvalidPassword {

	public static void main(String[] args) 
	{
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.leadcircle.ai/");
		WebElement email=WaitUtility.click(driver, By.id("email"), 6);
		email.click();
		Random ran= new Random();
		int num=ran.nextInt(1000);
		email.sendKeys("allen"+num+"@yopmail.com");
		WebElement pass=WaitUtility.click(driver, By.id("password"), 6);
		pass.click();
		pass.sendKeys("pass");
		WebElement btn=WaitUtility.click(driver, By.id("loginBtn"), 6);
		btn.click();
		WebElement ermsg=driver.findElement(By.xpath("//div[@class='toast toast-error']"));
		if (ermsg.isDisplayed()) 
		{
			ScreenShot ss=new ScreenShot();
			ss.failedTestCase(driver);
			System.out.println(ermsg.getText());
			driver.quit();
		} 
		else
		{
			System.out.println("you are in correct page");
			driver.quit();
		}
	}

}
