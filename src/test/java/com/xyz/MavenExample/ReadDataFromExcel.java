package com.xyz.MavenExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	
	public WebDriver driver; 
	
	
	@DataProvider(name = "Authentication")
	public String[][] getExcelData() throws IOException{
		String[][] arrayObject = (String[][]) getExcelData("Test.xlsx", "Sheet1");
		return arrayObject;
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
	
	
	public Object getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			XSSFWorkbook workbook= new XSSFWorkbook(fs);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
			int totalRows=sheet.getLastRowNum();
			int totalColums=sheet.getRow(0).getPhysicalNumberOfCells();
			
			arrayExcelData=new String[totalRows][totalColums];
			for(int i=0;i<totalRows;i++)
			{
				arrayExcelData[i][0]=sheet.getRow(i+1).getCell(0).toString();
				arrayExcelData[i][1]=sheet.getRow(i+1).getCell(1).toString();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} 
		return arrayExcelData;
	}
	
	

}
