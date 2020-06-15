package com.syntax.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTwo {
	@Test
	public void test1() {
		System.out.println("test 1");
	}
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	@Test
	public void test3() {
		System.out.println("Test 3");
	}
	@BeforeClass
	public void BeforeClass() {
		System.out.println("BeforeClass");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
	}
	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	
	
}
