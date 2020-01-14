package com.cpsat.test;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cpsat.utils.SeleniumHelpers;
import com.cpsat.utils.WebDriverProvider;
import com.cpsat.utils.SeleniumHelpers.LocType;

public class GoogleMaps {

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
	
	@Test
	public void MapsTest() {
		SeleniumHelpers helpers = new SeleniumHelpers(driver);
		helpers.openUrl("https://www.google.com/maps/");
		helpers.click("searchboxinput", LocType.ID);
		helpers.enterText("searchboxinput", LocType.ID, "Wankhede Stadium");
		helpers.click("searchbox-searchbutton", LocType.ID);
		helpers.takeScreenShot("./src/screenshot/"+System.currentTimeMillis()+".png");
		String name = helpers.getText("//h1[contains(@class, 'section-hero-header-title-title')]", LocType.XPATH);
		Assert.assertTrue(name.contains("Stadium"));
		String title = driver.getTitle();
		Assert.assertEquals(title,"Wankhede Stadium - Google Maps");
		String rating = helpers.getText("//span[@class='section-star-display']", LocType.XPATH);
		String reviews = helpers.getText("//span[@class='section-rating-term-list']", LocType.XPATH);
		System.out.println(rating);
		System.out.println(reviews);
		String web = helpers.getText("//div[contains(@class, 'section-info-underline')]", LocType.XPATH);
		Assert.assertTrue(web.contains("mumbaicricket.com"));
		String phone = helpers.getText("//div[contains (@class, 'section-info-speak-numeral')]", LocType.XPATH);
		Assert.assertTrue(phone.contains("022 2279 5500"));
		
	}
	

}
