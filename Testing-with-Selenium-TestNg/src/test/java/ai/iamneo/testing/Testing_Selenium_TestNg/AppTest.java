package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AppTest {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;
	String url="https://flipkart.com";

	@BeforeTest
	public void beforeTest() throws Exception {
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
	}

	@Test
	public void testcase_1() throws InterruptedException //Go to Ebay
	{
		driver.manage().window().maximize();
		driver.get(url);
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		System.out.println("Number of links on a page :: "+allLink.size());
		Assert.assertTrue(true);
	}

	@Test
	public void testcase_2() throws InterruptedException 
      {
	       //write Your Code here to Login
		   Thread.sleep(3000);
		   boolean isEnabled = driver.findElement(By.xpath("/html/body/div[3]/div/span")).isDisplayed();
		   if(isEnabled) {
			   driver.findElement(By.xpath("/html/body/div[3]/div/span")).click();
		   }
		   List<WebElement> allLink = driver.findElements(By.tagName("a"));
		   for(WebElement link:allLink){
			   System.out.println("Link Text : "+ link.getText());
			   System.out.println("Link URL  : "+ link.getAttribute("href"));
		   }
		   Assert.assertTrue(true);
	}

		
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}