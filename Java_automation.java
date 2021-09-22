package com.maersk.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Runner {
	static WebDriver driver= null ;
	@BeforeTest 
	public void intialise() {	
		Runner obj= new Runner();
		obj.setupDriver("chrome");	
	}
	@Test 
	public void bookflight() throws Exception, InterruptedException {
		clickelement(By.xpath("/html/body/div[2]/div/p[2]/a"));
	       TakesScreenshot scrShot =((TakesScreenshot)driver);
	       File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	       File DestFile=new File("C:\\Users\\vishgarg\\eclipse-workspace\\Selenium basic\\test-output\\Hawai.png");
	       FileUtils.copyFile(SrcFile, DestFile);
	       driver.navigate().back();
	       clickelement(By.xpath("/html/body/div[3]/form/div/input"));
	       TakesScreenshot scrShot1 =((TakesScreenshot)driver);
	       File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
	       File DestFile1=new File("C:\\Users\\vishgarg\\eclipse-workspace\\Selenium basic\\test-output\\List of Flights.png");
	       FileUtils.copyFile(SrcFile1, DestFile1);

	       
	       // Fill the Form 
	       clickelement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[1]/input"));
	       sendkeys(By.id("inputName"),"Vishal Garg");
	       driver.findElement(By.id("address")).sendKeys("h no 63, 18th main ,22nd cross, Sector 3- HSR Layout");
	       driver.findElement(By.id("city")).sendKeys("bangalore");
	       driver.findElement(By.id("state")).sendKeys("Karnataka");
	       driver.findElement(By.id("zipCode")).sendKeys("560102");
	       driver.findElement(By.id("creditCardNumber")).sendKeys("123456789");
	       driver.findElement(By.id("nameOnCard")).sendKeys("Vishal Garg");
	       driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();
	      
	       
	       TakesScreenshot scrShot2 =((TakesScreenshot)driver);
	       File SrcFile2=scrShot2.getScreenshotAs(OutputType.FILE);
	       File DestFile2=new File("C:\\Users\\vishgarg\\eclipse-workspace\\Selenium basic\\test-output\\confirmation.png");
	       FileUtils.copyFile(SrcFile2, DestFile2);
	       Thread.sleep(2000);
	       
	       String text= driver.findElement(By.xpath("/html/body/div[2]/div/h1")).getText();
	       System.out.println("the confirmation text is :" +text);
	}
	public WebElement findWebelment(By locator) {
		return driver.findElement(locator);
		
		
	}
	public void sendkeys(By locator, String value) {
		WebElement ele = findWebelment(locator);
		ele.sendKeys(value);
	}

	public void clickelement(By locator) {
		WebElement ele = findWebelment(locator);
		ele.click();
		
	}
	public void setupDriver(String browser) {
		switch (browser) {
		case "chrome":
        intializeChrome();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://blazedemo.com");
	}
        private static void intializeChrome() {
		String currentPath = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver",currentPath+ "\\driver\\chromedriver.exe");
	     driver = new ChromeDriver() ;	
	     
	}
	
	
	
	

}
