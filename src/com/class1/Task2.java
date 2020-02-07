package com.class1;

import org.testng.annotations.*;

public class Task2 {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class method");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After class method");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}
	
	@Test
	public void testA() {
		System.out.println("Test A");
	}
	@Test
	public void testB() {
		System.out.println("Test B");
	}
}
