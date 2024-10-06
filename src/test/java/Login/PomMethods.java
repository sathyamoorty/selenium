package Login;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Login.LoginDatas;
import Pom.JsDriver;

@Listeners(Login.ExtentReport.class)
public class PomMethods {

	static WebDriver driver;

	@BeforeClass
	public static void startMethod() {
		System.setProperty("weddriver.chrome.driver",
				"C:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://app.leadcircle.ai/login/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void startMethodpostcondition() {
//      driver.manage().window().minimize();
//		driver.quit();
	}

	@Test(priority = 1)
	public void invalidEmail() {
		try {
			LoginDatas.email(driver).sendKeys("rajesh@yopmail");
			LoginDatas.password(driver).sendKeys("Password@123");
			LoginDatas.subbtn(driver).click();
			WebElement errmsg = LoginDatas.errorMessage(driver);
			if (errmsg.isDisplayed()) {
				System.out.println(errmsg.getText());
			} else {
				System.out.println("Working fine");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.navigate().refresh();
		}
	}

	@Test(priority = 2)
	public void invalidPassword() {
		try {
			LoginDatas.email(driver).sendKeys("rajesh@yopmail.com");
			LoginDatas.password(driver).sendKeys("pass");
			LoginDatas.subbtn(driver).click();
			WebElement errmsg = LoginDatas.errorMessage(driver);
			if (errmsg.isDisplayed()) {
				System.out.println(errmsg.getText());
			} else {
				System.out.println("working fine");
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.navigate().refresh();
			// driver.quit();
		}
	}

	@Test(priority = 3)
	public void bothValid() {
		try {
			LoginDatas.email(driver).sendKeys("rajesh@yopmail.com");
			LoginDatas.password(driver).sendKeys("Password@123");
			LoginDatas.subbtn(driver).click();
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement sucessmsg = LoginDatas.dashboard(driver);
			WebElement head = LoginDatas.welcome(driver);
			// WebElement
			// head=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dash-userTitle")));

			if (sucessmsg.isDisplayed() && head.isDisplayed()) {
				System.out.println(sucessmsg.getText() + ", Is the correct page");
			} else {
				System.out.println("it is in wrong page");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void client() {
		try {
//			LoginDatas.email(driver).sendKeys("sathya@yopmail.com");
//			LoginDatas.password(driver).sendKeys("Password@123");
//			LoginDatas.subbtn(driver).click();
			LoginDatas.clickOnClient(driver);
			LoginDatas.clientForm(driver);
			WebElement formpage = LoginDatas.addClientForm(driver);
			if (formpage.isDisplayed()) {
				System.out.println("It is the correct page to test");
			} else {
				System.out.println("Something wrong in the testing");
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 5)
	public void datasOfClientPage() {
		try {
			LoginDatas.jsExcutor(driver);
			Random ran = new Random();
			int num = ran.nextInt(1000);
			LoginDatas.datasOfClient(driver).sendKeys("Car ShowRoom " + num);
			LoginDatas.countryName(driver);
			LoginDatas.phoneField(driver).sendKeys("1234567890");
			LoginDatas.websiteField(driver).sendKeys("www.chatgpt.com");
			LoginDatas.subbutton(driver);
			WebElement viewclientPage = LoginDatas.viewPage(driver);
			if (viewclientPage.isDisplayed()) {
				System.out.println("client has been added");
//				driver.quit();
			} else {
				System.out.println("Something went wrong");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 6)
	public void getDatas() {
		LoginDatas.jsExcutor(driver);
		LoginDatas.retriveTheDatas(driver);
	}

}
