package com.xyz.MavenExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//parameters - description, enable, priority, dependsonmethod, groups, timeout
public class TestNG_BASMCMG {

	@BeforeClass
	public void m1() {
		System.out.println("Before Class Annotation");
	}
	
	
	@BeforeTest
	public void m2() {
		System.out.println("Test Execution Started");
	}
	
	@AfterTest
	public void m3() {
		System.out.println("Test Execution Ended");
	}
	
	
	@Test(description ="Testcase One")
	public void m4(){
		System.out.println("Hello");
	}
	
	@Test(description ="Testcase Two")
	public void m5(){
		System.out.println("World");
	}
	
	
}			
