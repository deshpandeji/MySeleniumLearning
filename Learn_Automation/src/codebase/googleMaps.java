package codebase;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleMaps {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/browser/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		
		driver.get("http://maps.google.com");
		driver.findElement(By.xpath("//input[@id='searchboxinput']")).sendKeys("Prime Nestor Block");
		driver.findElement(By.xpath("//button[@id='searchbox-searchbutton']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Address = driver.findElement(By.xpath("//span[@class='section-info-text']")).getText();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(Address);
		utility.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[1]/div/div/div[5]/div[1]/div/button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Choose starting point, or click on the map...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Choose starting point, or click on the map...']")).sendKeys("Cynosure, A Zensar Company");
		driver.findElement(By.xpath("//div[@id='directions-searchbox-0']//button[@class='searchbox-searchbutton']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String time = driver.findElement(By.xpath("//*[@id='section-directions-trip-0']/div[2]/div[1]/div[1]/div[1]")).getText();
		String distance = driver.findElement(By.xpath("//*[@id='section-directions-trip-0']/div[2]/div[1]/div[1]/div[2]")).getText();
		System.out.println("Estimated Time is: " + time);
		System.out.println("first option distance is: " + distance);	
		
	}

}
