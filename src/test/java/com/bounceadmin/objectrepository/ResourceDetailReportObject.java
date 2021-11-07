package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class ResourceDetailReportObject extends SetUp {

	WebDriver driver;
	
	public ResourceDetailReportObject(WebDriver driver)
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
	
	@FindBy(xpath="//th[contains(text(),'Nursery Name')]")
	public WebElement NurseryName;
	@FindBy(xpath="//th[contains(text(),'Images Count')]")
	public WebElement imageCount;
	@FindBy(xpath="//th[contains(text(),'Videos Count')]")
	public WebElement videoCount;
}
