package invalid;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom.RegPage;
import Pom.WaitUtility;
import takescreenshot.ScreenShot;

public class InvalidPassReg {

	public static void main(String[] args) 
	{
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://app.leadcircle.ai/registration");
		driver.manage().window().maximize();
		WebElement name=WaitUtility.click(driver, By.id("name"), 4);
		name.click();
		name.sendKeys("Abdul");
		WebElement mail=WaitUtility.click(driver, By.id("email"), 5);
		mail.click();
		Random ran= new Random();
		int num=ran.nextInt(1000);
		mail.sendKeys("abu"+num+"@yopmail.com");
		WebElement pass=WaitUtility.click(driver, By.id("password"), 5);
		pass.click();
		pass.sendKeys("pass");
		RegPage.checkBox(driver);
		RegPage.submitBtn(driver);
		WebElement errmsg=driver.findElement(By.xpath("//div[@class='toast toast-error']"));
		if (errmsg.isDisplayed()) 
		{
			ScreenShot ss=new ScreenShot();
			ss.failedTestCase(driver);
			System.out.println(errmsg.getText());
			driver.quit();
		}
		else 
		{
			System.out.println("you are in correct page");
			driver.quit();
		}

	}

}
