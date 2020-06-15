package com.syntax.class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DifferentAnnotations {
	
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("BeforeSuite");
	}
	@AfterSuite
	public void AfterSuite() {
		System.out.println("AfterSuite");
	}
	@BeforeMethod
	public void beforMethod() {
	//	BayramGul();
		System.out.println("beforMethod");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	@BeforeClass
	public void BeforeClass() {
		System.out.println("BeforeClass");
	}
	@Test
	public void test() {
		System.out.println("Actual test");
	}
	
	public void BayramGul() {
		System.out.println("Hi from BayramGul");
	}
}
