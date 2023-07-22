package com.saucedomoTestNg.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAsserTest {
	
	
	
@Test
  void testLogin() {
	
	
	WebDriver driver;
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	driver.get("https://saucedemo.com/v1");
	
	
	driver.findElement(By.xpath("//*[@class='form_input' and @id='user-name']")).sendKeys("standard_user");
	driver.findElement(By.xpath("//input[@class='form_input' and @id='password']")).sendKeys("secret_sauce");
	WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
	loginButton.click();
	
	
	
	WebElement pageNameElement = driver
			.findElement(By.xpath("//div[text() = 'Products' and @class='product_label']"));

	String givenTitle = "Productsxyz"; // the test Data
	String actualTitle = pageNameElement.getText(); // title we got from the runtime
	
	
	
	
// in this type of cases we will use soft assert
	
// 	it is a class of TestNG and we will make an object of it
	
	SoftAssert sc = new SoftAssert();
	sc.assertEquals(givenTitle,actualTitle);
	
	
	

	// Assert.assertEquals(actualTitle, givenTitle);  // 
	
	
	
	// something else to test// other functions to test
	
	
	// responsible for logout
	driver.findElement(By.xpath("//button[contains(text(), 'Open Menu')]")).click();
	driver.findElement(By.id("logout_sidebar_link")).click();
	
	
	sc.assertAll();
	
	
	
	
	
	
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
	
	
	
	
	
	
	

}
