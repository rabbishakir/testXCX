package com.saucedomoTestNg.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTest {
	
	WebDriver driver;
	
	@Test(dataProvider = "loginData")  // data is here now
	void login(String username, String password){
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.saucedemo.com/v1/");
		
		driver.findElement(By.xpath("//*[@class='form_input' and @id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='form_input' and @id='password']")).sendKeys(password);
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
		
	}
	
	@DataProvider(name="loginData")
	Object[][] dataprover() {
		
		Object[][]  data = {{"standard_user", "secret_sauce"},{"locked_out_userx", "secret_sauce"}, {"problem_userx", "secret_sauce"}};
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	

}
