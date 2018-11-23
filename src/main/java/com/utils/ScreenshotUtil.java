package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ScreenshotUtil implements ITestListener {

	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailure(ITestResult result) {
				  
		  try {
			  String methodName=result.getMethod().getMethodName();
		      String className=result.getMethod().getRealClass().getSimpleName();
			  File  srcFile  = ((TakesScreenshot)BrowserUtil.driver).getScreenshotAs(OutputType.FILE);
			  DateFormat dateFormat =new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ssaa");
			  String destDir ="Fail";
			  new File(destDir).mkdirs();
			  String path=System.getProperty("user.dir")+"/"+destDir+"/"+className+"_"+methodName+"_"+dateFormat.format(new Date())+"screenshot.png".replace("/", File.separator);
			  FileUtils.copyFile(srcFile, new File(path));
			  Reporter.log("<a href=" + "file:///" + path + " >" + "ScreenshotLink" + "</a>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		  
				  
	}

	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
  
     
	
	 
	       
	 
	
	
	
	
	
	
	
	
	

}
