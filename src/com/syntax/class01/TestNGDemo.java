package com.syntax.class01;
import org.testng.annotations.Test;

public class TestNGDemo {
	@Test
	static void c() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	}
	@Test
	static void a() {
		System.out.println("Test Case 2");
	}
	@Test
	static void b() {
		System.out.println("Test Case 3");
	}
}
