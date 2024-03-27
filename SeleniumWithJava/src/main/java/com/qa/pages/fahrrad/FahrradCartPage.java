package com.qa.pages.fahrrad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class FahrradCartPage extends TestBase {
	
	//Required Page Factory for CartPage page in Fahrrad.de
	
	@FindBy(xpath = "//select[contains(@id , 'quantity')]")
	WebElement productQty;		
	
	@FindBy(xpath = "//img[contains(@title,'VOTEC VRX grün/schwarz grün/schwarz')]")
	WebElement cartProduct;	
	
	//Initialise Page Factory
	public FahrradCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean checkProduct(String product)
	{
		WebElement selectedProduct= driver.findElement(By.xpath("//img[contains(@title,'"+product+"')]"));	
		return selectedProduct.isDisplayed();
	}
	
	public String checkQty()
	{
		System.out.println("option selected is checkQty");
		Select select  = new Select(productQty);		
		String optionSelected = select.getFirstSelectedOption().getText();	
		System.out.println("option selected is" + optionSelected);
		return optionSelected;
	}
	
	

}
