package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

	public class AppTest {

		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = null;
		String url=" https://flipkart.com";

		@BeforeTest
		public void beforeTest() throws Exception {
			String Browser = "chrome";
			
			if (Browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/Users/dharmateja/Downloads/DriversForEclipse/chromedriver");
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "");
				driver = new FirefoxDriver();
			} else if (Browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						"/Users/dharmateja/Downloads/DriversForEclipse/edgedriver_mac64_m1/msedgedriver");
				driver = new EdgeDriver();
			} else {
				driver = new SafariDriver();
			}
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