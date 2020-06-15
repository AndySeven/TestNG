package com.syntax.class03;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class GroupsDemo {
	
	@BeforeClass(alwaysRun = true) // always will execute
	public void before() {
		System.out.println("BeforeClass");
	}
	@AfterClass(alwaysRun = true)
	public void after() {
		System.out.println("AfterClass");
	}
	
	@Test(dependsOnGroups = {"smoke"})
	public void test01() {
		System.out.println("test01 - depends on smoke");
	}
	@Test(groups = "smoke")
	public void test02() {
		System.out.println("test02 - smoke");
		//Assert.assertTrue(false);
		SoftAssert s = new SoftAssert();
		s.assertTrue(false);
		
		//s.assertAll();
	}
	@Test(groups = {"regression"})
	public void test03() {
		System.out.println("test03 - regression");
	}
	
	@Test(groups = {"smoke","regression"})
	public void test04() {
		System.out.println("test04 - regression and smoke");
	}
}
