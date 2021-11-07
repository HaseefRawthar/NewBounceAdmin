package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class SalesCommisionReportObject extends SetUp {


	WebDriver driver;

	public SalesCommisionReportObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath="//button[contains(text(),'Filter')]")
	public WebElement filterButton; 
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	public WebElement resetButton; 
	@FindBy(xpath="//button[contains(text(),'PRINT')]")
	public WebElement printButton; 
	@FindBy(xpath="//ng-multiselect-dropdown[@formcontrolname='countryId']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	public WebElement country;
	@FindBy(xpath="//ng-multiselect-dropdown[@formcontrolname='nurseryId']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	public WebElement nursery;
	
	@FindBy(xpath="//span[@class='mobile-hidden'][contains(text(),'Total Records')]")
	public WebElement totalRecords;

	@FindBy(xpath="//a[@aria-label='go to next page']//i")
	public WebElement goToNextPage;
	@FindBy(xpath="//li[@class='disabled']//a[@aria-label='go to next page']")
	public WebElement lastpagecheck;
	
	@FindBy(xpath="//button[contains(text(),'BACK')]")
	public WebElement backButton;
	
	
}
