package com.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BrowserUtil;
import com.utils.TestDataUtil;
import com.webpages.PageObjectFactory;

public class LoginTest extends BrowserUtil {
   
	@Test (dataProviderClass=TestDataUtil.class, dataProvider="loginTest")
	public void loginTest(String url,String username, String password, String expResult){
		PageObjectFactory pof=new PageObjectFactory(driver);
		pof.loginPage().accessUrl(url);
		pof.loginPage().login(username,password);
	    pof.loginPage().getExpText();
		
		Assert.assertEquals(pof.loginPage().getExpText(),expResult,"Verify Login");
		
	}
	
}
