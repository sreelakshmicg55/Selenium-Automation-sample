package com.qa.testcases.fahrrad;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.fahrrad.FahrradMainPage;
import com.qa.utils.TestUtils;

public class FahrradMainPageTest extends TestBase{
	
	public FahrradMainPage fahrradMainPage;
	public TestUtils testUtils;

	public FahrradMainPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initializer();
		TestUtils.acceptCookies();
		fahrradMainPage = new FahrradMainPage();

	}
	
	@Test(enabled = false)
	public void verifyFahrräderLinkTest()
	{
		Assert.assertTrue(fahrradMainPage.verifyFahrräderLink());
	}
	
	
	@Test (enabled = false)
	public void performClickOnFahrräderLinkTest()
	{
		fahrradMainPage.performClickOnFahrräderLink();
	}
	
	@Test
	public void performClickOnStraßenrennräderLinkTest()
	{
		fahrradMainPage.performClickOnFahrräderLink();
		fahrradMainPage.performClickOnStraßenrennräderLink();
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}

}
