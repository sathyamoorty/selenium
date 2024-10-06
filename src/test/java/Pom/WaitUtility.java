package Pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static WebElement visibility(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	public static WebElement click (WebDriver driver, By locator, int timeclick) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeclick));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	  public static WebElement attributeContains(WebDriver driver, By locator, String attribute, String value, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
	        return driver.findElement(locator);  // Return the element after the condition is met
	    }
}
