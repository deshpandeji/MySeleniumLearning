package codebase;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MumbaiUni {
	
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/browser/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://mu.ac.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//header[@id='masthead']//a[contains(text(),'ACADEMICS')]"));
		action.moveToElement(element).perform();
		WebElement element1 = driver.findElement(By.xpath("//header[@id='masthead']//a[contains(text(),'FACULTY')]"));
		action.moveToElement(element1).perform();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"menu-item-2773\"]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'DEPARTMENT OF INFORMATION TECHNOLOGY')]")).click();
		
	}

}
