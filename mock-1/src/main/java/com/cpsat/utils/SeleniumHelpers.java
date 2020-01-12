package com.cpsat.utils;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelpers {
	
	public enum LocType{
		XPATH , ID , NAME , CLASSNAME , CSS_VALUE , LINK_TEXT , PARTIAL_LINK_TEXT, TAG_NAME
	}
	
	public WebDriver driver;
	
	public SeleniumHelpers(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(String locator,LocType type) {
		return waitForElementToBePresent(locator,type);
	}
	
	public WebElement waitForElementToBePresent(String locator,LocType type) {
		By loc = getLocator(locator, type);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public By getLocator(String locator,LocType type) {
		By loc = null;
		switch(type) {
		case XPATH:
			loc = By.xpath(locator);
			break;
		case ID:
			loc = By.id(locator);
			break;
		case NAME:
			loc = By.name(locator);
			break;
		case CLASSNAME:
			loc = By.className(locator);
			break;
		case CSS_VALUE:	
			loc = By.cssSelector(locator);
			break;
		}
		return loc;
	}
	
	public void click(String locator,LocType type) {
		WebElement element = getElement(locator, type);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element)).click();
		System.out.println("clicked on element having type ["+type+"]:"+locator);
	}
	
	public void enterText(String locator,LocType type,String text) {
		getElement(locator, type).sendKeys(text);
	}
	
	public void mouseHover(String locator,LocType type) {
		WebElement element = getElement(locator, type);
		new Actions(driver).moveToElement(element).build().perform();
	}
	
	public String getText(String locator,LocType type) {
		return getElement(locator, type).getText();
	}
	
	public void getAttributeValue() {
		
	}
	
	
	public void getCssValue() {
		
	}
	
	public boolean isElementPresent(String locator,LocType type) {
		waitForElementToBePresent(locator, type);
		boolean flag = driver.findElements(getLocator(locator, type)).size() > 0 ? true:false;
		return flag;
	}
	
	public void takeScreenShot(String fileName)  {		
		try {
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(fileName));
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public List<WebElement> getElements(String locator,LocType type){
		return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocator(locator,type)));
	}

}
