package com.class3;

import org.testng.annotations.*;

public class AlwaysRun {

	//alwaysRun=true is used to run before and after methods
	//even if there is any restrictions like groups
	@BeforeSuite(alwaysRun=true)  
	public void beforeSuite() {
		System.out.println("I am before suite");
	}
	@BeforeTest(alwaysRun=true)
	public void beforeTest() {
		System.out.println("I am before test");
	}
	@BeforeClass(alwaysRun=true)
	public void beforeClass() {
		System.out.println("I am before class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("I am after method");
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("I am after class");
	}
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("I am after test");
	}
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("I am after suite");
	}
	@Test
	public void testMEthod1() {
		System.out.println("I am test method 1");
	}
}
