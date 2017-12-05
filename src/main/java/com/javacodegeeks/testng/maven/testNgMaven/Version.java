package com.javacodegeeks.testng.maven.testNgMaven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Version {
	public  class TestChromeBrowser {
		
		 String driverPath = "C:\\Users\\SGARG5\\Downloads\\everything\\";
		public WebDriver driver;
		
		@BeforeClass
		public void setUp() {
			System.out.println("*******************");
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		//	driver.manage().window().maximize();
		}
		
		@Test
		public void testGooglePageTitleInIEBrowser() {
			driver.navigate().to("http://fd-dvops-vm-01.eastus.cloudapp.azure.com:50000/hello-world-war/");
			String strPageTitle = driver.getTitle();
			System.out.println("Page title: - "+strPageTitle);
			Assert.assertTrue(strPageTitle.equalsIgnoreCase("Hello World!"), "Page title doesn't match");
		}

		@AfterClass
		public void tearDown() {
			if(driver!=null) {
				System.out.println("Closing chrome browser");
				driver.quit();
			}
		}

	}
}
