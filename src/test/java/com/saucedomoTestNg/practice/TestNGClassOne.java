package com.saucedomoTestNg.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClassOne {

	@BeforeTest
	void beforeTest() {
		System.out.println("This is before Test");
	}
	
	@AfterTest
	void afterTest() {
		System.out.println("This is After Test");
	}

	// annotations

	@BeforeClass
	void beforeClass() {
		System.out.println("This is before class");
	}

	@AfterClass
	void afterClass() {
		System.out.println("This is After class ");
	}

	@BeforeMethod
	void beforeMethod() {
		System.out.println("this is before method");
	}

	@AfterMethod
	void afterMethod() {
		System.out.println("this is After method method");
	}

	WebDriver driver;

	@Test(priority = -1)
	void init() {
		System.out.println("This is initialization");
	}

	@Test(priority = 1, groups = { "smoke", "regression"  } )  // smoke
	void login() {
		System.out.println("This is Login");
	}
	
	@Test(groups = "regression")
	void dosortTest() { // is your regression
		System.out.println("Testing product sort a-z");
	}

	@Test(priority = 2, groups = "smoke")
	void logout() {
		System.out.println("This is logout");
	}

}
