package com.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuggestionsPage {
	@FindBy(xpath = "//section/h1")
	WebElement pageTitle;

	WebDriver driver;

	public SuggestionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifySuggestionsPage() {
		String getTitle = pageTitle.getText();
		return getTitle;

	}

}
