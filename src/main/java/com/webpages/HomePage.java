package com.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	/*	@FindBy(xpath="//p[@class='name']")
	WebElement productNameInPdp;  */
	@FindBy(xpath="//div/a[@class='logout_url pull-right']")
	WebElement logoutButton;
	@FindBy(xpath="//div[@data-role='alert-button-container']/p")
	WebElement errorMsg;
	@FindBy(id="paper_authors")
	WebElement manuscriptTitle;
	@FindBy(id="paper_authors")
	WebElement authorname;
	@FindBy(id="paper_abstract")
	WebElement abstractTitle;
	@FindBy(id="paper_keywords")
	WebElement keywordTitle;
	@FindBy(xpath="//div//input[@type='submit']")
	WebElement findsuggessionButton;
	
	
	
	
	 WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
    public boolean findReviewer(String textTitle,String textAuthor,String textAbstract,String textKeyword) {
		manuscriptTitle.sendKeys(textTitle);
		authorname.sendKeys(textAuthor);
		abstractTitle.sendKeys(textAbstract);
		keywordTitle.sendKeys(textKeyword);
		findsuggessionButton.click();
		return true;		
		}
	
	

	
}
