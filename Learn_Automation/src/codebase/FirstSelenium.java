package codebase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/browser/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.nihilent.com/");
		String tt = driver.getTitle();
		System.out.println(tt);
		utility.captureScreenShot(driver);
		
		driver.quit();

	}

}
