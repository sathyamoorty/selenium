package LogAndSign;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pom.WaitUtility;
import takescreenshot.ScreenShot;

public class Login {
	WebDriver driver;

	@BeforeClass
	public void intialStage() {
		System.setProperty("weddriver.chrome.driver",
				"C:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.leadcircle.ai/login/");
	}

	@Test(priority = 1)
	public void invalidEmail() {
		//this is for valid email and the invalid password using testng
		try {
			WebElement email = WaitUtility.visibility(driver, By.id("email"), 7);
			email.click();
			Random ran = new Random();
			int num = ran.nextInt(1000);
			email.sendKeys("allen" + num + "gmail");
			WebElement pass = WaitUtility.visibility(driver, By.id("password"), 7);
			pass.click();
			pass.sendKeys("Password@123");
			WebElement btn = WaitUtility.visibility(driver, By.id("loginBtn"), 7);
			btn.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errmsg = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast toast-error']")));
			if (errmsg.isDisplayed()) {
				ScreenShot ss = new ScreenShot();
				ss.failedTestCase(driver);
				System.out.println(errmsg.getText());
			} else {
				System.out.println("It is a correct way, you can proceed with your testing");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			driver.navigate().refresh();
		}
	}

	@Test(priority = 2)
	public void invalidPassword() {
		//this is for invalid email and the valid password using testng

		try {
			WebElement email = driver.findElement(By.id("email"));
			email.clear();
			email.click();
			Random ran = new Random();
			int num = ran.nextInt(1000);
			email.sendKeys("allen" + num + "@yopmail.com");
			WebElement pass = WaitUtility.click(driver, By.id("password"), 10);
			pass.clear();
			pass.click();
			pass.sendKeys("pass");
			WebElement btn = WaitUtility.click(driver, By.id("loginBtn"), 10);
			btn.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errmsg = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast toast-error']")));
			if (errmsg.isDisplayed()) {
				ScreenShot ss = new ScreenShot();
				ss.failedTestCase(driver);
				System.out.println(errmsg.getText());
			} else {
				System.out.println("you are in correct page");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			driver.navigate().refresh();
		}
	}

	@Test(priority = 3)
	public void bothInvalid() {
		//this is for invalid email and the invalid password using testng

		try {
			WebElement email = WaitUtility.visibility(driver, By.id("email"), 10);
			email.clear();
			email.click();
			Random ran = new Random();
			int num = ran.nextInt(1000);
			email.sendKeys("allen" + num + "@yopmail");
			WebElement pass = WaitUtility.visibility(driver, By.id("password"), 10);
			pass.clear();
			pass.click();
			pass.sendKeys("pass");
			WebElement btn = WaitUtility.click(driver, By.id("loginBtn"), 10);
			btn.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errmsg = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
			if (errmsg.isDisplayed()) {
				ScreenShot ss = new ScreenShot();
				ss.failedTestCase(driver);
				System.out.println(errmsg.getText());
				// driver.quit();
			} else {
				System.out.println("you are in correct page");
				// driver.quit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.navigate().refresh();
		}
	}

	@Test(priority = 4)
	public void BothValid() {
		//this is for valid email and the valid password using testng

		try {
			WebElement email = WaitUtility.visibility(driver, By.id("email"), 10);
			// driver.findElement(By.id("email"));
			email.clear();
			email.click();
			email.sendKeys("aadhi@yopmail.com");
			WebElement pass = WaitUtility.visibility(driver, By.id("password"), 10);
			// driver.findElement(By.id("password"));
			pass.clear();
			pass.click();
			pass.sendKeys("Password@123");
			WebElement btn = WaitUtility.click(driver, By.id("loginBtn"), 10);
			// driver.findElement(By.id("loginBtn"));
			btn.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement dash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
			if (dash.isDisplayed()) {
				System.out.println("continue with your testing...");
				driver.quit();

			} else {
				ScreenShot ss = new ScreenShot();
				ss.failedTestCase(driver);
				System.out.println("Both email and password is wrong");
				driver.quit();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
