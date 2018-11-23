package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BrowserUtil;
import com.utils.TestDataUtil;
import com.webpages.PageObjectFactory;

public class FindSuggestionsTest extends BrowserUtil {
	@Test(dataProviderClass = TestDataUtil.class, dataProvider = "searchTest")
	public void findSuggestionsTest(String url, String username, String password, String expResult1, String textTitle,
			String textAuthor, String textAbstract, String textKeyword, String expResult2) {
		PageObjectFactory pof = new PageObjectFactory(driver);
		pof.loginPage().accessUrl(url);
		pof.loginPage().login(username, password);
		pof.loginPage().getExpText();
        Assert.assertEquals(pof.loginPage().getExpText(), expResult1, "Verify Login");
		pof.homePage().findReviewer(textTitle, textAuthor, textAbstract, textKeyword);
		pof.suggestionsPage().verifySuggestionsPage();
		Assert.assertEquals(pof.suggestionsPage().verifySuggestionsPage(), expResult2);

	}
}