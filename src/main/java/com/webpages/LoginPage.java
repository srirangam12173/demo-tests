package com.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
      @FindBy(id="login-username")
      WebElement textboxUsername;
      @FindBy(id="login-password")
      WebElement textboxPassword;
      @FindBy(id="login-submit")
      WebElement loginButton;
      @FindBy(xpath="//div[2]/section/h1")
      WebElement reviewerText;
      
      
	
	
	WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean accessUrl(String url){
		driver.get(url);
		return true;
	}
   public boolean login(String username,String password){
	   textboxUsername.sendKeys(username);
	   textboxPassword.sendKeys(password);
	   loginButton.click();
	   
	   return true;
   }
   

	public String getExpText() {
	String reviewerTitle=reviewerText.getText();
		return reviewerTitle;
	}
}
