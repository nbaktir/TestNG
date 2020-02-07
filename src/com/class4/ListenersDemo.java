package com.class4;

import org.testng.Assert;
import org.testng.annotations.*;

public class ListenersDemo {
	@Test
	public void test1() {
		System.out.println("I am test 1");
		Assert.assertTrue(true);
	}
	@Test
	public void test2() {
		System.out.println("I am test 2");
	}
	@Test
	public void test3() {
		System.out.println("I am test 3");
	}
	//
}
