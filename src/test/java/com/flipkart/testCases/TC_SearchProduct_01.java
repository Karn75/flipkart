package com.flipkart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.ShoesPage;

@Test
public class TC_SearchProduct_01 extends BaseClass {
	
	public void searchTest() throws InterruptedException, IOException  {
		
		logger.info("URL opened");
		
		HomePage hp = new HomePage(driver); 
		
		hp.removePopup();
		logger.info("Popup removed");
		
		hp.clickAndSearch();
		logger.info("Typed and searched");
		
		Thread.sleep(2000);
		ShoesPage sp = new ShoesPage(driver);
		
		String price = sp.findShoePrice();
		System.out.println("BRUTON shoe price is: "+price);
		logger.info("Got price of shoe");
		
		if(price.equalsIgnoreCase(price)) {
			Assert.assertTrue(true);
			logger.info("Test passed");
		}
		else {
			captureScreen(driver, "searchTest");
			Assert.assertTrue(false);
			logger.info("Test failed");
		}
		
	}
}
