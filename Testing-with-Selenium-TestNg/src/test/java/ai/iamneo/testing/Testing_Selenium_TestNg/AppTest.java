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
		public void testcase_1() throws InterruptedException //Go to Ebay
		{
			
			driver.get("https://www.flipkart.com/");
			String title = driver.getTitle();
			Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		}

		@Test
		public void testcase_2() throws InterruptedException 
	      {
			Thread.sleep(2000);
		    boolean isEnabled = driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).isDisplayed();
		    if(isEnabled) {
		    	driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		    }else {
		    	Assert.fail();
		    }
		    	//write Your Code here to Login
		    List<WebElement> list = driver.findElements(By.tagName("a"));
		    System.out.println(list.size());
		    int nlinks = 374;//   //Get the Number of links
			 int get = list.size();
			 for(WebElement link:list){
					System.out.println("Link Text :: "+ link.getText());
					System.out.println("Link URL  :: "+ link.getAttribute("href"));
			}
			 Assert.assertEquals(get, nlinks);
		}
			
		@AfterTest
		public void afterTest() {
			driver.quit();
		}

	}
