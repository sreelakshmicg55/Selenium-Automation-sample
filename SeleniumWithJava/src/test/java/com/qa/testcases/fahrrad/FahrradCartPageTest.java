package com.qa.testcases.fahrrad;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.fahrrad.FahrradCartPage;
import com.qa.pages.fahrrad.FahrradMainPage;
import com.qa.pages.fahrrad.FahrradProductListPage;
import com.qa.pages.fahrrad.FahrradProductPage;
import com.qa.utils.TestUtils;

public class FahrradCartPageTest extends TestBase{
	
	
	public FahrradProductPage fahrradProductPage;
	public FahrradProductListPageTest fahrradProductListPageTest;
	public FahrradMainPage fahrradMainPage;
	public FahrradMainPageTest fahrradMainPageTest;
	public FahrradProductListPage fahrradProductListPage;
	public FahrradCartPage fahrradCartPage;
	String sheetName = "fahrrad";
	public TestUtils testUtils;
	
	public FahrradCartPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setUp()
	{
		initializer();
		TestUtils.acceptCookies();
		fahrradMainPage = new FahrradMainPage();
		fahrradProductPage = new FahrradProductPage();
		fahrradProductListPageTest = new FahrradProductListPageTest();
		fahrradMainPageTest = new FahrradMainPageTest();
		fahrradProductListPage = new FahrradProductListPage();
//		fahrradCartPage = new FahrradCartPage();
		
		//Navigate to the page
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Navigate to the page
		fahrradMainPage.performClickOnFahrräderLink();
		fahrradProductListPage = fahrradMainPage.performClickOnStraßenrennräderLink();

	}
	
	@Test (priority =1, dataProvider="getTestData")
	public void checkProductVisibleTest(String city, String design, String product, String actualSize)
	{
		fahrradProductListPage.selectCity(city);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fahrradProductListPage.selectBauArt(design);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fahrradProductPage =fahrradProductListPage.selectProduct(product);
		
		fahrradProductPage.performClickToSelectSize();
		fahrradProductPage.performSelectsizeFromList(actualSize);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fahrradProductPage.performselectAddToCart();			
		fahrradCartPage = fahrradProductPage.performselectGoToCart();
		
		
		Assert.assertTrue(fahrradCartPage.checkProduct(product));
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@AfterClass (enabled=false)
	public void tearDown()
	{
		//driver.quit();
	}
	

}
