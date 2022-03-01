package com.xyz.MavenExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupTestNG {
		
		public WebDriver driver; 
		
		@Test
		public void a1_openBrowser() {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		@Test
		public void a2_openURL() throws InterruptedException {
			driver.get("https://google.com/");
			Thread.sleep(3000); 
		}
		@Test 
		public void a3_search() throws InterruptedException {
			driver.findElement(By.name("q")).click();
			driver.findElement(By.name("q")).sendKeys("NeW York");
			driver.findElement(By.name("q")).submit();
			Thread.sleep(3000);
			driver.close();
		}
}
