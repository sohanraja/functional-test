package com.javacodegeeks.testng.maven.testNgMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;




public class Chrome {
	private WebDriver driver;
	
	@BeforeSuite
	public void initDriver() throws Exception {
	 System.out.println("You are testing in firefox");
	 System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	 System.setProperty("webdriver.gecko.driver","C:\\Users\\SGARG5\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
}
	
	@Test
    public void searchTestNGInGoogle() {
        final String searchKey = "TestNG";
        System.out.println("Search " + searchKey + " in google");
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        System.out.println("Enter " + searchKey);
        element.sendKeys(searchKey);
        System.out.println("submit");
        element.submit();
	
        

        System.out.println("Got " + searchKey + " results");

    }

 

    @AfterSuite
    public void quitDriver() throws Exception {

        driver.quit();

    }
}