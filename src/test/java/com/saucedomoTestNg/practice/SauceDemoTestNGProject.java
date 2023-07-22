package com.saucedomoTestNg.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoTestNGProject {

	WebDriver driver;
	
	
	// lets pass parameter from xml file // we will run as a suit
	// which browser to use  // we will use a condition here 
	// and which url to go
	
	
	// assertion // assertTrue(); assertFalse(), AsserEqual(); //
	// softassert

	
	

	@BeforeTest
	@Parameters({"browser", "url"})  // this line
	void intiDriver(String browsername, String url) {
		
		System.out.println(browsername);
		System.out.println(url);
		
		if(browsername.equalsIgnoreCase("Chrome")) {
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
		}else if(browsername.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
		}else if(browsername.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
		}else {
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
		}
		
		driver.get(url);

	}

	@AfterTest
	void closeDriver() {
		driver.close();
	}

	@BeforeClass()
	void loginApp() {
		
		driver.findElement(By.xpath("//*[@class='form_input' and @id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@class='form_input' and @id='password']")).sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
	}

	@AfterClass
	void logOutApp() {

		driver.findElement(By.xpath("//button[contains(text(), 'Open Menu')]")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();

	}
	
	@Test
	void logoTest() {
	WebElement appLogo = 	driver.findElement(By.xpath("//div[@class='app_logo']"));
	
	// if the logo is present  // true  // if not its false
	Assert.assertTrue(appLogo.isDisplayed());
	//Assert.assertFalse(appLogo.isDisplayed());

		
	}
	

	@Test(priority = 1)
	void testProductPage() {

		// check the title of the product page
		WebElement pageNameElement = driver
				.findElement(By.xpath("//div[text() = 'Products' and @class='product_label']"));

		String givenTitle = "Products"; // the test Data
		String actualTitle = pageNameElement.getText(); // title we got from the runtime

		
		
		Assert.assertEquals(actualTitle, givenTitle);
		
		
		
		
		
		
		
		

	}

	@Test(priority = 2)
	void testAtoZ() throws InterruptedException {
		// we we have to do here
		WebElement selectelemnt = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sc = new Select(selectelemnt);
		Thread.sleep(3000);
		sc.selectByValue("az");
	}

	@Test(priority = 3)
	void testZtoA() throws InterruptedException {

		WebElement selectelemnt = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sc = new Select(selectelemnt);
		sc.selectByValue("za");
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	void productCount() {

		WebElement parentProduct = driver.findElement(By.className("inventory_list"));
		List<WebElement> childDIv = parentProduct.findElements(By.className("inventory_item"));
		int numberOfDiv = childDIv.size();
		int expectedNumber = 6;
		Assert.assertEquals(numberOfDiv, expectedNumber);

	}

	// checking single product page

	@Test
	void testSingleProduct() throws InterruptedException {
		// find the parent element
		WebElement parentProduct = driver.findElement(By.className("inventory_list"));
		// find the child
		List<WebElement> childDIv = parentProduct.findElements(By.className("inventory_item"));
		// we will find the number of items // which we will use for the loop
		int numberofChild = childDIv.size();

		// we will start the loop from 0

		// we will run the loop until the size of child div
		for (int i = 0; i < numberofChild; i++) {

			System.out.println(i);

			driver.findElement(By.xpath("//div[@class='inventory_item_label']/a[contains(@href, 'id=" + i + "')]"))
					.click();
			Thread.sleep(3000);
			driver.navigate().back();
		}

	}

	// add to cart functions

	@Test
	void producttoCart() throws InterruptedException {
		// find the parent element
		WebElement parentProduct = driver.findElement(By.className("inventory_list"));
		// find the child
		List<WebElement> childDIv = parentProduct.findElements(By.className("inventory_item"));
		// we will find the number of items // which we will use for the loop
		int numberofChild = childDIv.size();

		// run the loop

		for (int i = 1; i <= numberofChild; i++) { // from 0 to 5 // we need 1 to 6
			System.out.println(i);
			driver.findElement(By.xpath("//div[@class = 'inventory_item']["+i+"]/div/button[text()= 'ADD TO CART']")).click();
			//driver.findElement(By.xpath("(//button[text() ='ADD TO CART'])[" +  i  + " ]")).click();
			//Thread.sleep(3000);
		}

	}



} // end of the class
