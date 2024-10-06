package Login;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.WebSettingsDocument;

import Pom.JsDriver;
import Pom.WaitUtility;

public class LoginDatas {
	public static WebElement email(WebDriver driver) {
		return WaitUtility.click(driver, By.id("email"), 20);
	}

	public static WebElement password(WebDriver driver) {
		return WaitUtility.click(driver, By.id("password"), 20);
	}

	public static WebElement subbtn(WebDriver driver) {
		return WaitUtility.click(driver, By.id("loginBtn"), 20);
	}

	public static WebElement errorMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errmsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast toast-error']")));
		return errmsg;
	}

	public static WebElement dashboard(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement errmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
		errmsg.click(); // WebElement
		// head=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dash-userTitle")));
		return errmsg;
	}

	public static WebElement welcome(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement head = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dash-userTitle")));
		return head;
	}

	public static WebElement clickOnClient(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement client = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Clients")));
		client.click();
		return client;
	}

	public static WebElement clientForm(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clkbtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='adduserbtn']")));
		clkbtn.click();
		return clkbtn;

	}

	public static WebElement addClientForm(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement formvisible = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']")));
		return formvisible;
	}

	public static WebElement datasOfClient(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement bname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("business_name")));
		bname.click();
		;
		return bname;
	}

	public static void jsExcutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public static WebElement countryName(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement country = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-country-container")));
		country.click();
		List<WebElement> element = driver.findElements(By.xpath("//ul[@id='select2-country-results']//li"));
		for (WebElement webElement : element) {
			String text = webElement.getText().trim().toLowerCase();
			String originalValue = "United States".trim().toLowerCase();
			if (text.equals(originalValue)) {
				webElement.click();
				break;
			}

		}
		return country;
	}

	public static WebElement phoneField(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement phoneNum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")));
		phoneNum.click();
		return phoneNum;
	}

	public static WebElement websiteField(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement web = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("website")));
		web.click();
		return web;
	}

	public static WebElement subbutton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement subbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='stepperbtn']")));
		subbutton.click();
		return subbutton;
	}

	public static WebElement viewPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement clientViewPage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body p-4']")));
		return clientViewPage;
	}

	public static void retriveTheDatas(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement rows=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-12']")));
		System.out.println("the row text"+ rows.getText());
	//	WebElement rows = driver.findElement(By.xpath("//div[@class='col-sm-12']"));
		List<WebElement> rowDatas = rows.findElements(By.xpath("//div[@class='col-sm-12']//table//tbody//tr"));
//		
		System.out.println("Number of rows "+rowDatas.size());
//		for (WebElement element : rowDatas) {
//			List<WebElement> colmn = element.findElements(By.tagName("td"));
//			for (WebElement celldata : colmn) {
//				System.out.println(celldata.getText());
//			}
			
//			if (colmn.size() > 3) {
//				String agencyname = colmn.get(1).getText();
//				String country = colmn.get(2).getText();
//				String PhoneNo = colmn.get(3).getText();
//				String type = colmn.get(4).getText();
//				System.out.println(
//						"Agency Name " + agencyname + " Country " + country + " Phone No " + PhoneNo + " Type " + type);
//			} else {
//				System.out.println("wrong datas..");
//			}
		}

	}


