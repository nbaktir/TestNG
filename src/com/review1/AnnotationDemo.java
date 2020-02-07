package com.review1;

import org.testng.annotations.*;

public class AnnotationDemo {

	@BeforeMethod
	public void testOne() {
		System.out.println("Login functionality");
	}
	@Test
	public void testTwo() {
		System.out.println("Search functionality");
	}
	
}
