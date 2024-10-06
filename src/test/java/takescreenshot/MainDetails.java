package takescreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import com.google.common.io.Files;

public class MainDetails {
	public static WebDriver driver;

	public static void driverMethod(String url) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(url);
		driver.manage().window().maximize();
	//	System.out.println("it is navigated to the login page");

	}

	public void failedTestCase(WebDriver driver) {
		File srcs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcs, new File("D:\\ss\\fail.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
