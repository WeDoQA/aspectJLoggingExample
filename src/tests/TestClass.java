package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.PageUtils;


public class TestClass {
	
	WebDriver driver = new FirefoxDriver();
	PageUtils pageUtils = new  PageUtils(driver);
	
	@After
	public void after(){
		driver.quit();
	}
	
	@Test
	public void test(){
		
		driver.get("http://www.google.com");
		
		WebElement queryField = pageUtils.waitForElementToAppear(By.xpath("//*[@name = 'q']"));
		pageUtils.sendChar(queryField, "wedoqa");
		
		WebElement submitButton = pageUtils.waitForElementToAppear(By.name("btnG"));
		pageUtils.click(submitButton);
		
		WebElement wedoqaResult = pageUtils.waitForElementToAppear(By.cssSelector("#rso>li .rc>h3 a"));
		
		Assert.assertEquals("WeDoQA", wedoqaResult.getText());
	}
	
}
