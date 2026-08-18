package com.flipkart.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	
	public Logger logger = LogManager.getLogger(BaseClass.class);
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Incorrect browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tName) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/screenshots/" + tName + ".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot taken");
	}

}
