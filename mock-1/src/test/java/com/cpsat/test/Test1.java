package com.cpsat.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cpsat.utils.ExcelUtils;
import com.cpsat.utils.SeleniumHelpers;
import com.cpsat.utils.WebDriverProvider;
import com.cpsat.utils.SeleniumHelpers.LocType;

public class Test1 {

	WebDriver driver;
	WebDriverProvider driverProvider = new WebDriverProvider();

	@BeforeMethod
	public void start() {
		driver = driverProvider.getDriver("chrome");
	}

	@AfterMethod
	public void stop() {
		driverProvider.stopDriver();
	}

	@DataProvider(name = "data")
	public Object[][] testData() {
		return new ExcelUtils().getDataSets(".//lib/testdata.xlsx", "Test1");
	}

	@Test(dataProvider = "data")
	public void test1(String searchWord) {
		System.out.println(" search word is :" + searchWord);
		SeleniumHelpers helpers = new SeleniumHelpers(driver);
		helpers.openUrl("http://www.meripustak.com/");
		helpers.enterText("txtsearch", LocType.ID, searchWord);
		helpers.click("btnsearch", LocType.ID);
		String books = "//div[contains(@id,'book_list')]//li/div[contains(@class,'off')]/span[contains(@class,'off_count')][not (contains(text(),'0%'))]/../..";

		List<WebElement> elements = helpers.getElements(books, LocType.XPATH);
		for (WebElement element : elements) {
			String bookName = element.findElement(By.xpath(".//span[contains(@itemprop,'name')]")).getText();
			String price = element.findElement(By.xpath("./div[contains(@itemprop,'offers')]")).getText();
			System.out.println("Name : " + bookName + "  --> " + price);
		}
	}

}
