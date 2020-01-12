package codebase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PerpperFryTestNG {
	
	static WebDriver driver;
	
  @Test 
  public void f() {
	  
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

 
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "./src/browser/geckodriver.exe");
	  driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
