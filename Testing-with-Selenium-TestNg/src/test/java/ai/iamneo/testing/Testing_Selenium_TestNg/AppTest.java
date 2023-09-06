package ai.iamneo.testing.Testing_Selenium_TestNg;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.List;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class AppTest {
	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception {
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
	}
	@Test
	public void testcase_1() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://flipkart.com");
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