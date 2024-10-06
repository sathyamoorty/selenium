package Pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage {
	public static WebElement name(WebDriver driver) {
		// return driver.findElement(By.id("name"));
		return WaitUtility.visibility(driver, By.id("name"), 7);
	}

	public static WebElement mailId(WebDriver driver) {
		// return driver.findElement(By.id("email"));
		return WaitUtility.visibility(driver, By.id("email"), 7);
	}

	public static WebElement passWord(WebDriver driver) {
		// return driver.findElement(By.id("password"));
		return WaitUtility.visibility(driver, By.id("password"), 7);
	}

	public static WebElement checkBox(WebDriver driver) {
		List<WebElement> ele = driver.findElements(By.xpath("//label[@class='checkbox-container']"));
		for (WebElement web : ele) {
			System.out.println(web.getText());
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement ch =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='checkmark']")));
		WebElement ch = WaitUtility.click(driver, By.xpath("//span[@class='checkmark']"), 7);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ch);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ch);
		// WebElement ch = driver.findElement(By.xpath(" //span[@class='checkmark']"));
		return ch;

	}

	public static WebElement submitBtn(WebDriver driver) {
//		 WebElement sub=driver.findElement(By.id("signupBtn"));
		WebElement sub = WaitUtility.click(driver, By.id("signupBtn"), 7);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sub);
		System.out.println("SignUp is done");
		return sub;
	}

	public static void nextPage(WebDriver driver) {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String path = "/html/body/div/div[2]/div/div/div[2]/article[2]/div/div[2]/button";
		try {
//			WebElement element=driver.findElement(By.xpath(path));
			WebElement element = WaitUtility.visibility(driver, By.xpath(path), 7);
			if (element.isDisplayed()) {
				System.out.println("the page is displayed , you can continue your work");
				element.click();
			}
		} catch (InvalidSelectorException e) {
			System.out.println("the page is not displayed , you can't do the further steps => " + e.getMessage());
			driver.quit();
		} catch (TimeoutException | NoSuchElementException e) {
			WaitUtility.visibility(driver, By.tagName("body"), 7);
			System.out.println("the page is not displayed , you can't do the further steps");
			String url = driver.getCurrentUrl();
			String regurl = "https://app.leadcircle.ai/registration/";
			if (url.equals(regurl)) {
				System.out.println("You are in the current reg page");
				driver.quit();
			} else {
				System.out.println("the page is navigated but the element is not found");
			}
		}
	}

	public static WebElement agencyName(WebDriver driver) {
		return WaitUtility.visibility(driver, By.id("company"), 5);
	}

	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void agencyCountry(WebDriver driver) {

		System.out.println("It is clicked");
		WebElement country = WaitUtility.visibility(driver, By.id("select2-country-container"), 5);
		scrollIntoView(driver, country);
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
		WebElement contact = WaitUtility.click(driver, By.id("phone"), 6);
		contact.click();
		contact.sendKeys("1234567890");

		WebElement web = WaitUtility.click(driver, By.id("website"), 6);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", web);
		web.sendKeys("www.chatgpt.com");

	}

	public static WebElement signBtn(WebDriver driver) {

		// WebElement signbtn=driver.findElement(By.id("signupBtn"));
		WebElement btn = WaitUtility.click(driver, By.id("signupBtn"), 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
		System.out.println("Submit is done");
		return btn;
//

	}

	public static void skipButton(WebDriver driver) {
		WebElement skip = WaitUtility.click(driver, By.xpath("//label[text()='Skip']"), 9);
		skip.click();
	}

	public static void dashBoard(WebDriver driver) {
		WebElement element = driver.findElement(By.linkText("Dashboard"));
		if (element.isDisplayed()) {
			System.out.println("it is in the dashboard page");
			driver.quit();
		} else {
			System.out.println("it is not in the dashboard page");
		}
	}
}
