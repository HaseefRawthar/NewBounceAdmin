package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class DAUReportObject extends SetUp {

	WebDriver driver;
	
	public DAUReportObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//select[@formcontrolname='countryId']")
	public WebElement country;
	@FindBy(xpath="//select[@formcontrolname='institutionId']")
	public WebElement nurseryName;
	@FindBy(xpath="//label[contains(text(),'From Date')]//following::input[1]")
	public WebElement fromDtae;
	@FindBy(xpath="//label[contains(text(),'To Date')]//following::input[1]")
	public WebElement toDate;
	@FindBy(xpath="//button[contains(text(),'Filter')]")
	public WebElement filterButton;
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	public WebElement resetButton;
	
	@FindBy(xpath="//span[contains(text(),'Sl.No')]")
	public WebElement slno;
	@FindBy(xpath="//span[contains(text(),'Nursery Name')]")
	public WebElement NurseryName;
	@FindBy(xpath="//span[contains(text(),'Country')]")
	public WebElement countryname;
	@FindBy(xpath="//span[contains(text(),'Number of active students')]")
	public WebElement noOfActiveStudents;
	
	@FindBy(xpath="//div[@class='total-rows ml-3']//span[@class='mobile-hidden']")
	public WebElement totalRecords;
	@FindBy(xpath="//a[@aria-label='go to next page']//i")
	public WebElement goToNextPage;
	@FindBy(xpath="//li[@class='disabled']//a[@aria-label='go to next page']")
	public WebElement lastpagecheck;
}
