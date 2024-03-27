package com.qa.pages.fahrrad;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FahrradMainPage extends TestBase{
   
	//Required Page Factory for Mainpage in Fahrrad.de
	
	@FindBy(xpath = "/html/body/header/div/div[2]/ul/li[1]/a/div")
	WebElement fahrräder;	
	
	
	@FindBy(xpath = "//a[text()='Straßenrennräder']")
	WebElement straßenrennräder;		
	
	
	//Initialise Page Factory
	public FahrradMainPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
    public boolean verifyFahrräderLink()
	{
		return fahrräder.isDisplayed();
	}
		
	public void performClickOnFahrräderLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(fahrräder).build().perform();
	}
	
	public FahrradProductListPage performClickOnStraßenrennräderLink ()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		straßenrennräder.click();
		return new FahrradProductListPage();
	}
	
	
}
