package invalid;

import java.util.Random;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom.WaitUtility;
import takescreenshot.*;

public class InvalidLogin {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://app.leadcircle.ai/login/");
		driver.manage().window().maximize();
		WebElement email = WaitUtility.visibility(driver, By.id("email"), 7);
		email.click();
		Random ran = new Random();
		int num = ran.nextInt(1000);
		email.sendKeys("allen"+num+"gmail");
		//email.sendKeys("aadhi@yopmail.com");
		WebElement pass = WaitUtility.visibility(driver, By.id("password"), 7);
		pass.click();
		pass.sendKeys("Password@123");
		WebElement btn = WaitUtility.visibility(driver, By.id("loginBtn"), 7);
		btn.click();
		WebElement errmsg = driver.findElement(By.xpath("//div[@class='toast toast-error']"));
		if (errmsg.isDisplayed()) {
			ScreenShot ss = new ScreenShot();
			ss.failedTestCase(driver);
			
			System.out.println(errmsg.getText());
			driver.quit();
		} else {
			System.out.println("It is a correct way, you can proceed with your testing");
		}

	}

}
