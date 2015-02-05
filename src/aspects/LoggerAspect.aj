package aspects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public aspect LoggerAspect {
	
	//Pointcuts
	pointcut waitForElementToAppeareWithByParam(By locator): execution(* utils.PageUtils.waitForElementToAppear(By)) && args(locator);
	pointcut click(WebElement element): execution(* utils.PageUtils.click(WebElement)) && args(element);
	pointcut sendChar(WebElement element, String text): execution(* utils.PageUtils.sendChar(WebElement, String)) && args(element, text);
	
	//Advice
	after(By locator) returning: waitForElementToAppeareWithByParam(locator){
		System.out.println("WebElement found with locator: " + locator);
	}
	
	after(By locator) throwing (AssertionError e): waitForElementToAppeareWithByParam(locator) {
		System.out.println(thisJoinPointStaticPart.getSignature());
		e.printStackTrace();
	}
	
	after(WebElement element, String text) returning:  sendChar(element, text){
		System.out.println("\"" + text +"\"" + " inserted into element " + getLocatorFromWebElement(element));
	}
	
	after(WebElement element) returning: click(element){
		System.out.println("Element is clicked: " + getLocatorFromWebElement(element));
	}

	/*
	 * Tricky code part that gives back the locator which was used to find the element
	 */
	private String getLocatorFromWebElement(WebElement element){
		String fragment = element.toString().split("->")[1].trim();
		String retval = fragment.substring(0, fragment.length()-1);
		return retval;
	}
}
