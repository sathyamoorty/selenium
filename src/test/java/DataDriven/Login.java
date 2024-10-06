package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {

	WebDriver driver;
	String[][] datas;

	public String[][] retrivingData() throws BiffException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Downloads\\Book 4 (1).xls");
		Workbook work = Workbook.getWorkbook(file);
		Sheet sh = work.getSheet(0);
		int row = sh.getRows();
		int colm = sh.getColumns();

		String[][] dataOfLog = new String[row - 1][colm - 1];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < colm; j++) {
				dataOfLog[i - 1][j] = sh.getCell(j, i).getContents();
			}
		}
		return dataOfLog;

	}

	
	
	@DataProvider(name = "login")
	public String[][] dataprovider() throws BiffException, IOException {
		datas = retrivingData();
		return datas;
	}

	
	
	@BeforeTest
	public void beforeExe() {
		System.setProperty("weddriver.chrome.driver",
				"C:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
	}
    @AfterTest
	public void afterExe() {
		driver.quit();
	}
	
	

	@Test(dataProvider = "login")
	public void setUp(String uname, String pass) {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://app.leadcircle.ai/login/");
		WebElement user = driver.findElement(By.id("email"));
		user.sendKeys(uname);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pass);
		WebElement check=driver.findElement(By.className("checkmark"));
		WebElement subbtn = driver.findElement(By.id("loginBtn"));
		subbtn.click();

	}

}
