package com.saucedomoTestNg.practice;

import org.testng.annotations.Test;

public class ParallelOne {
	
	@Test
	void testOne() throws InterruptedException {
		
		System.out.println("This is test1 first line ");
		
		Thread.sleep(3000);

		System.out.println("This is test1 Second line ");
		
	}
	
	
	
	
	

}
