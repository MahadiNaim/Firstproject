package com.xyz.MavenExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	public WebDriver driver; 
	
	
	@DataProvider(name = "Authentication")
	  public static Object[][] credentials() {
	        return new Object[][] { { "mayank1", "test@123" }, { "mayank2", "test@123" }};
	  }
	
	@Test(dataProvider = "Authentication")
	public void a3_search(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com");
		
		Thread.sleep(3000); 
		driver.findElement(By.id("login2")).click();
		Thread.sleep(3000); 
		driver.findElement(By.id("loginusername")).sendKeys(username);
		Thread.sleep(1000); 
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("logout2")).click();
		
		driver.close();
	}

}
