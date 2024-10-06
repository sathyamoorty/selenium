package datapoi;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	static List<String> udatas = new ArrayList<String>();
	static List<String> pdatas = new ArrayList<String>();

	public void readData() throws IOException {
		FileInputStream fi = new FileInputStream("C:\\Users\\Admin\\Downloads\\Excel Data.xlsx");
		Workbook work = new XSSFWorkbook(fi);
		Sheet sh = work.getSheetAt(0);
		Iterator<Row> fetchrow = sh.iterator();

		while (fetchrow.hasNext()) {
			Row r = fetchrow.next();
			Iterator<Cell> colm = r.iterator();
			int i = 2;
			while (colm.hasNext()) {
				if (i % 2 == 0) {
					udatas.add(colm.next().getStringCellValue());
				} else {
					pdatas.add(colm.next().getStringCellValue());
				}
				i++;
			}
			System.out.println();
		}

	}

	public void login(String udatas, String pdatas) {
		System.setProperty("weddriver.chrome.driver",
				"C:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.leadcircle.ai/login/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement user = driver.findElement(By.id("email"));
		user.sendKeys(udatas);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pdatas);
		WebElement subbtn = driver.findElement(By.id("loginBtn"));
		subbtn.click();
		//driver.close();
	}

	public void timeOfExe() {
		for (int i = 0; i < udatas.size(); i++) {
			login(udatas.get(i), pdatas.get(i));

		}
	}

	public static void main(String[] args) throws IOException {
		Login log = new Login();
		log.readData();
//		System.out.println("User Datas" + udatas);
//		System.out.println("Password Datas" + pdatas);
		log.timeOfExe();
		
	}
}
