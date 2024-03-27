package com.qa.pages.fahrrad;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FahrradProductListPage extends TestBase {
	
	//Required Page Factory for Productlist page in Fahrrad.de
	
	@FindBy(xpath = "//span[@title='Filter nach Stuttgart']")
	WebElement selectCheckBoxStuttgart;		
	
	@FindBy(xpath = "//span[@title='Filter nach Fitness']")
	WebElement selectCheckBoxFitness;	
	
	@FindBy(xpath = "//div[contains(@class,'store_availability')]/h3")
	WebElement store;
	
	
	//Initialise Page Factory
	public FahrradProductListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void selectCity(String city)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", store);
		
		WebElement selectCheckBoxFCity	= driver.findElement(By.xpath("//span[contains(@title,'"+city+"')]"));	
		selectCheckBoxFCity.click();
		
	}
	
	public void selectBauArt(String design)
	{
		WebElement selectCheckBoxFitness	= driver.findElement(By.xpath("//span[contains(@title,'"+design+"')]"));	
		selectCheckBoxFitness.click();
	}
	
	public FahrradProductPage selectProduct(String product)
	{
		WebElement selectItem	= driver.findElement(By.xpath("//a[@title='"+product+"']"));
		selectItem.click();
		return new FahrradProductPage();
	}

}
