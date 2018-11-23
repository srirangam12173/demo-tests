package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BrowserUtil {
	protected static WebDriver driver=null;
	@Parameters ({"browser"})
	@BeforeMethod
	public void openBrowser(String browser){
	 if(browser.toLowerCase().startsWith("c")){
	 ChromeOptions options = new ChromeOptions();
		 options.addArguments("headless");
		// driver=new ChromeDriver(options);
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//resources//chromedriver");
		driver=new ChromeDriver();
	 }else if(browser.toLowerCase().startsWith("f")){
		 driver=new FirefoxDriver();
	 }else if(browser.toLowerCase().startsWith("i")){
         System.setProperty("webdriver.internetexplorer.driver", System.getProperty("user.dir")+"//src//main//resources//IEDriverServer.exe" );
	 driver=new InternetExplorerDriver();
	 
	 
	 }
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
		 }
			
	@AfterMethod
  public void closeBrowser(){
	  driver.quit();
  }
}

