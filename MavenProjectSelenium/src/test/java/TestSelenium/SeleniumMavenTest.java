package TestSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumMavenTest {

	@Test
	public void ejecutaTest() throws InterruptedException {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jroncancio\\eclipse-workspace\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();	
		
		driver.get("https://www.youtube.com/");
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
	
	
}
