package utils;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageUtils {
	
	public static final int WAIT_TIME = 10;
	
	WebDriver driver;
	
	public PageUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElementToAppear(By locator) {
		int count = 0;
		while (count < 5){
			try {				
				WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME / 5);	
				return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}catch (StaleElementReferenceException e){
				count = count+1;
			}
			catch (TimeoutException e) {
				count = count+1;
			}
		}
		Assert.fail("Element is not appeared.");
		return null;
	}
	
	public void click(WebElement element){
		element.click();
	}
	
	public void sendChar(WebElement element, String text){
		element.sendKeys(text);
	}

}
