package com.flipkart.pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public WebDriverWait wait;
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@role=\"button\"]")
	WebElement popup;
	
	@FindBy(xpath="(//input[@name=\"q\"])[1]")
	WebElement searchBoxField;
	
	public void removePopup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(popup));
		popup.click();
	}
	
	public void clickAndSearch() {
		searchBoxField.clear();
		searchBoxField.click();
		searchBoxField.sendKeys("Bruton Shoes");
		searchBoxField.sendKeys(Keys.ENTER);
	}

}
