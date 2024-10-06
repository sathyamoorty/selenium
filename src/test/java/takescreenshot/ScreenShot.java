package takescreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pom.WaitUtility;

@Listeners(BaseListener.class)
public class ScreenShot extends MainDetails {

	@BeforeClass
	public void startOfTestCase() {
		driverMethod("https://app.leadcircle.ai/login/");
	}

	@AfterClass
	public void takeSS() {

		driver.quit();
		System.out.println("this is the actual result");
		// driver.manage().window().maximize();
	}

	@Test
	public void mainScreenShot() {

		WebElement dash = WaitUtility.visibility(driver, By.linkText("Dashboard"), 8);
		if (dash.isDisplayed()) {
			System.out.println("you are in correct page");
		} else {
			failedTestCase(driver);
			Assert.fail("DashBoard is not displayed");
		}
//		try {
//			Assert.assertEquals(actualTittle, expectTittle, "Tittle mismatch");
//		} catch (AssertionError e) {
//			failedTestCase(driver);
//			throw e;
//		}
	}

}
