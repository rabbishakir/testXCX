package com.saucedomoTestNg.practice;

import org.testng.annotations.Test;

public class ParallelTwo {
	
	
	
	@Test
	void testTwo() throws InterruptedException {
		
		System.out.println("This is test2 first line ");
		
		Thread.sleep(3000);

		System.out.println("This is test2 Second line ");
		
	}

}
