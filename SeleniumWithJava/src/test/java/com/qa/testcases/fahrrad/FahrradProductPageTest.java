package com.qa.testcases.fahrrad;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.fahrrad.FahrradCartPage;
import com.qa.pages.fahrrad.FahrradMainPage;
import com.qa.pages.fahrrad.FahrradProductListPage;
import com.qa.pages.fahrrad.FahrradProductPage;
import com.qa.utils.TestUtils;

public class FahrradProductPageTest extends TestBase {
	
	public FahrradProductPage fahrradProductPage;
	public FahrradProductListPageTest fahrradProductListPageTest;
	public FahrradMainPage fahrradMainPage;
	public FahrradMainPageTest fahrradMainPageTest;
	public FahrradProductListPage fahrradProductListPage;
	public FahrradCartPage fahrradCartPage;
	String sheetName = "fahrrad";
	public TestUtils testUtils;
		
		public FahrradProductPageTest()
		{
			super();
		}
		
		@BeforeMethod ()
		public void setUp()
		{
			initializer();
			TestUtils.acceptCookies();
			fahrradMainPage = new FahrradMainPage();
			fahrradProductPage = new FahrradProductPage();
			fahrradProductListPageTest = new FahrradProductListPageTest();
			fahrradMainPageTest = new FahrradMainPageTest();
			fahrradProductListPage = new FahrradProductListPage();
			fahrradCartPage = new FahrradCartPage();
			
			//Navigate to the page
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Navigate to the page
			//fahrradMainPageTest.performClickOnStraßenrennräderLinkTest();
			//fahrradProductListPageTest.selectProductTest();
			
			fahrradMainPage.performClickOnFahrräderLink();
			fahrradMainPage.performClickOnStraßenrennräderLink();			


		}
		
		@Test (priority =1, enabled = false)
		public void selectsizeFromListEnabledTest()
		{
			fahrradProductPage.selectsizeFromListEnabled();
			
		}
		
		
		@Test (priority =2, enabled = false)
		public void performClickToSelectSizeTest()
		{
			fahrradProductPage.performClickToSelectSize();
			
		}
		
		@Test (priority =3, enabled = false)
		public void performSelectsizeFromListTest(String size)
		{
			
			fahrradProductPage.performSelectsizeFromList("60cm (28\")");
			
		}
		
		@Test (priority =4, enabled = false)
		public void selectAddToCartEnabledTest()
		{
			fahrradProductPage.selectAddToCartEnabled();
			
		}
		
		@Test (priority =5, enabled = false)
		public void performselectAddToCartTest()
		{
			fahrradProductPage.performselectAddToCart();
			
		}
		
		@Test (priority =6, enabled = false)
		public void performselectGoToCart()
		{
			
			fahrradProductPage.performselectGoToCart();
		}
		
		@Test (dataProvider="getTestData")
		public void performSelectAndGoToCartTest(String city, String design, String product, String actualSize)
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
