package com.qa.testcases.fahrrad;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.fahrrad.FahrradMainPage;
import com.qa.pages.fahrrad.FahrradProductListPage;
import com.qa.pages.fahrrad.FahrradProductPage;
import com.qa.utils.TestUtils;

public class FahrradProductListPageTest extends TestBase {

public FahrradProductPage fahrradProductPage;
public FahrradProductListPage fahrradProductListPage;
public FahrradMainPage fahrradMainPage;
public FahrradMainPageTest fahrradMainPageTest ;
public String sheetName = "fahrrad";
public TestUtils testUtils;
	
	public FahrradProductListPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initializer();
		TestUtils.acceptCookies();
		fahrradMainPage = new FahrradMainPage();
		fahrradMainPageTest = new FahrradMainPageTest();
		
		//Navigate to the page
		fahrradMainPage.performClickOnFahrräderLink();
		fahrradProductListPage = fahrradMainPage.performClickOnStraßenrennräderLink();

	}
	
	@Test (enabled = false , dataProvider="getTestData")
	public void selectCityTest(String city, String design, String product)
	{
		
		fahrradProductListPage.selectCity(city);
	}
	
	@Test (enabled = false, dataProvider="getTestData")
	public void selectDesignTest(String city, String design, String product)
	{
		fahrradProductListPage.selectBauArt(design);
	}
	
	@Test (dataProvider="getTestData")
	public void selectProductTest(String city, String design, String product, String actualSize)
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
		
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;

	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}

}
