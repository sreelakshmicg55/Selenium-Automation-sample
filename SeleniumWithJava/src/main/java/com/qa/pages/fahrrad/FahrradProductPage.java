package com.qa.pages.fahrrad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FahrradProductPage extends TestBase {
	
	//Required Page Factory for Product page in Fahrrad.de
	
		@FindBy(xpath = "//li[contains(@class,'openDrawer')]")
		WebElement selectsizeFromList;		
		
		@FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
		WebElement selectAddToCart;	

		@FindBy(xpath = "//a[contains(@title,'Zum Warenkorb')]")
		WebElement selectGoToCart;	

		
		//Initialise Page Factory
		public FahrradProductPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public boolean selectsizeFromListEnabled()
		{
			return selectsizeFromList.isDisplayed();
			
		}
		
		public boolean selectAddToCartEnabled()
		{
			return selectAddToCart.isDisplayed();
			
		}
		
		public void performClickToSelectSize()
		{
			selectsizeFromList.click();
			
		}
		
		public void performSelectsizeFromList(String size)
		{
			
			WebElement selectSizeBox	= driver.findElement(By.xpath("//div[contains(text(),'"+size+"')]"));	
			selectSizeBox.click();
			
		}
		
		public void performselectAddToCart()
		{
			
			selectAddToCart.click();
			
		}
		
		public FahrradCartPage performselectGoToCart()
		{
			
			selectGoToCart.click();
			return new FahrradCartPage();
		}
		
		
		
		

}
