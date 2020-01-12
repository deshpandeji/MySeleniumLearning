package codebase;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class annaUniversity {
	
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
		
		driver.get("https://www.wikipedia.org/");
		String article = driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/small")).getText();
		System.out.println(article);
		driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Anna University");
		driver.findElement(By.xpath("//button[@class='pure-button pure-button-primary-progressive']")).click();
		String motto = driver.findElement(By.xpath("//td[contains(text(),'Progress Through Knowledge')]")).getText();
		System.out.println("Motto in English: " + motto);
		assertTrue(motto.contains("Knowledge"));
		
		
		String NP = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/ul[1]")).getText();
		for(int i = 0; i < NP.length(); i++) {
		//System.out.println(NP);
		//assertTrue(NP.contains("Shiv Nadar"));
		assertTrue(NP.contains("Ravi Ruia"));
		}
	
		
	}

}
