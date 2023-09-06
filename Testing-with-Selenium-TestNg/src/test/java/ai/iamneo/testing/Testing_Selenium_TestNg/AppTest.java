package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class AppTest {
	WebDriver driver = null;
	String url="https://flipkart.com";
	ChromeOptions options = new ChromeOptions();
	
	@BeforeTest
	public void beforeTest() throws IOException{
		System.setProperty("webdriver.chrome.driver", "/home/coder/project/workspace/chromedriver");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
	}

		@Test
	public void testcase_1() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get(url);
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		System.out.println("Number of links on a page :: "+allLink.size());
	}
	@Test
	public void testcase_2() throws InterruptedException 
      {
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		for(WebElement link:allLink){
			System.out.println("Link Text : "+ link.getText());
			System.out.println("Link URL  : "+ link.getAttribute("href"));
		}
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}