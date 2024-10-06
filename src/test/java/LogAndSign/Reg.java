package LogAndSign;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pom.RegPage;
import Pom.WaitUtility;
import takescreenshot.ScreenShot;

public class Reg {
	WebDriver driver;

	@BeforeClass
	public void intialStage() {
		System.setProperty("weddriver.chrome.driver",
				"C:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.leadcircle.ai/registration/");
	}

	@Test(priority = 1)
	public void invalidEmail() {
		// this is for invalid email and the valid password
		try {
			WebElement name = WaitUtility.visibility(driver, By.id("name"), 20);
			name.click();
			name.sendKeys("Abdul");
			WebElement mail = WaitUtility.visibility(driver, By.id("email"), 20);
			mail.click();
			Random ran = new Random();
			int num = ran.nextInt(1000);
			mail.sendKeys("abu" + num + "yopmail");
			WebElement pass = WaitUtility.visibility(driver, By.id("password"), 20);
			pass.click();
			pass.sendKeys("Password@123");

			WebElement ch = WaitUtility.click(driver, By.xpath("//span[@class='checkmark']"), 10);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ch);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ch);
			
			WebElement sub = WaitUtility.click(driver, By.id("signupBtn"), 20);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", sub);

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
		} finally {
			driver.navigate().refresh();
		}
	}

	@Test(priority = 2)
	public void invalidPass() {
		// this is for valid email and the invalid password
		try {
			WebElement name = WaitUtility.click(driver, By.id("name"), 20);
			name.click();
			name.clear();
			name.sendKeys("vijay");

			WebElement mail = WaitUtility.click(driver, By.id("email"), 20);
			mail.click();
			mail.clear();
			Random ran = new Random();
			int num = ran.nextInt(1000);
			mail.sendKeys("vijay" + num + "@yopmail.com");

			WebElement pass = WaitUtility.click(driver, By.id("password"), 20);
			pass.click();
			pass.clear();
			pass.sendKeys("pass");

			WebElement ch = WaitUtility.click(driver, By.xpath("//span[@class='checkmark']"), 10);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ch);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ch);
			WebElement sub = WaitUtility.click(driver, By.id("signupBtn"), 20);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", sub);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errmsg = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));

			if (errmsg.isDisplayed()) {
				System.out.println(errmsg.getText());
			} else {
				System.out.println("You are on the correct page");
			}
		} catch (Exception e) {
			System.err.println("Exception occurred: " + e.getMessage());
		} finally {
			driver.navigate().refresh();
		}
	}

	@Test(priority = 3)
	public void bothInvalid() {
		// this is for invalid email and the invalid password
		try {
			WebElement name = WaitUtility.click(driver, By.id("name"), 20);
			name.click();
			name.clear();
			name.sendKeys("jeevan");

			WebElement mail = WaitUtility.click(driver, By.id("email"), 20);
			mail.click();
			mail.clear();
			Random ran = new Random();
			int num = ran.nextInt(1000);
			mail.sendKeys("jeevan" + num + "@yopmail");

			WebElement pass = WaitUtility.click(driver, By.id("password"), 20);
			pass.click();
			pass.clear();
			pass.sendKeys("pass");

			WebElement ch = WaitUtility.click(driver, By.xpath("//span[@class='checkmark']"), 10);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ch);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ch);
			WebElement sub = WaitUtility.click(driver, By.id("signupBtn"), 20);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", sub);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errmsg = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));

			if (errmsg.isDisplayed()) {
				System.out.println(errmsg.getText());
			} else {
				System.out.println("You are on the correct page");
			}
		} catch (Exception e) {
			System.err.println("Exception occurred: " + e.getMessage());
		} finally {
			driver.navigate().refresh();
		}
	}

	@Test(priority = 4)
	public void bothValid() {
		// this is for valid email and the valid password
		try {
			WebElement name = WaitUtility.click(driver, By.id("name"), 20);
			name.click();
			name.clear();
			name.sendKeys("gandhi");

			WebElement mail = WaitUtility.click(driver, By.id("email"), 20);
			mail.click();
			mail.clear();
			Random ran = new Random();
			int num = ran.nextInt(1000);
			mail.sendKeys("gandhi" + num + "@yopmail.com");

			WebElement pass = WaitUtility.click(driver, By.id("password"), 20);
			pass.click();
			pass.clear();
			pass.sendKeys("Password@123");
			WebElement ch = WaitUtility.click(driver, By.xpath("//span[@class='checkmark']"), 10);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ch);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ch);

			WebElement sub = WaitUtility.click(driver, By.id("signupBtn"), 20);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", sub);

			WebElement nxtpage = WaitUtility.visibility(driver, By.xpath("//div[@class='inner']"), 10);
			if (nxtpage.isDisplayed()) {
				System.out.println("It is navigated to the next page");
				driver.quit();
			} else {
				System.out.println("Invalid credentials");
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
