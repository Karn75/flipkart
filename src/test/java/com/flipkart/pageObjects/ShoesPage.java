package com.flipkart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoesPage {
	
	WebDriver driver;
	
	public ShoesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[text()='BRUTON'])[1]/following::div[contains(text(),'₹')][1]")
	WebElement shoe;
	
	String price;
	public String findShoePrice() {
		if(shoe.isDisplayed()) {
			price = shoe.getText();
		}
		else {
			System.out.println("Shoe is not not present on this webpage");
		}
		return price;
	}

}
