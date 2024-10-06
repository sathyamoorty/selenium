package pommethod;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pom.RegPage;

public class RegDatas {
	@Test
	public void signUp() throws InterruptedException {
		System.setProperty("weddriver.chrome.driver",
				"C:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.leadcircle.ai/registration/");
		// Thread.sleep(3000);
		driver.manage().window().maximize();

		RegPage.name(driver).sendKeys("goat");
		Random ran = new Random();
		int rannum = ran.nextInt(10000);
		String email = "goat" + rannum + "@yopmail.com";
		RegPage.mailId(driver).sendKeys(email);
		RegPage.passWord(driver).sendKeys("Password@123");
		RegPage.checkBox(driver);
		RegPage.submitBtn(driver);
		RegPage.nextPage(driver);
		String agency = "test" + rannum;
		RegPage.agencyName(driver).sendKeys(agency);
		RegPage.agencyCountry(driver);
		RegPage.signBtn(driver);
		RegPage.skipButton(driver);
		RegPage.dashBoard(driver);

	}
}
