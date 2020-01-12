package codebase;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PepperfryJunit {
	
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/browser/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test() {
		
		Xls_Reader reader = new Xls_Reader("./src/testData/paperfry.xlsx");
		int rowCount = reader.getRowCount("items");
		for(int rowNum = 2; rowNum <= rowCount; rowNum++) {
		String product = reader.getCellData("items",  "myitems", rowNum);
	
		driver.get("http://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(product);
		driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"curSortType\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"sortBY\"]/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		utility.captureScreenShot(driver);
		
	}
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

}
