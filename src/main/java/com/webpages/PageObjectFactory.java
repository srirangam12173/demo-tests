package com.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectFactory {
	HomePage homePage;
	LoginPage loginPage;
	SuggestionsPage suggestionsPage; 
	
	 WebDriver driver;
	public PageObjectFactory(WebDriver driver){
		this.driver=driver;
	}
    
	public HomePage homePage(){
		if(homePage==null)
		homePage=new HomePage(driver);
		return homePage;
	}
 
 public LoginPage loginPage(){
		if(loginPage==null)
			loginPage=new LoginPage(driver);
		return loginPage;
	}
  public SuggestionsPage suggestionsPage() {
	  if(suggestionsPage==null)
		  suggestionsPage=new SuggestionsPage(driver);
		return suggestionsPage;
	  
  }
 
 
 
 
 
 
 
 
 
}
