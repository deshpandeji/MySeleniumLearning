package com.cpsat.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverProvider {
	
	public WebDriver driver;
	
	public WebDriver getDriver(String browserName) {				
		switch(browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".//lib//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",".//lib//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", ".//lib//drivers//internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
			break;			
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public void stopDriver() {
		driver.quit();
	}
	

}
