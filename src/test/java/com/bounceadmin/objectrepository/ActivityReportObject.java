package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityReportObject {

	WebDriver driver;
	
	public ActivityReportObject(WebDriver driver)
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
	
	@FindBy(xpath="//th[contains(text(),'Type')]")
	public WebElement type;
	@FindBy(xpath="//th[contains(text(),'Activity')]")
	public WebElement activity;
	@FindBy(xpath="//th[contains(text(),'Count of comments')]")
	public WebElement countOfComments;
	@FindBy(xpath="//th[contains(text(),'Count of replies')]")
	public WebElement countOfReplies;
	@FindBy(xpath="//td[contains(text(),'Announcements')]")
	public WebElement announcements;
	@FindBy(xpath="//td[contains(text(),'Events')]")
	public WebElement events;
	@FindBy(xpath="//td[contains(text(),'Images')]")
	public WebElement images;
	@FindBy(xpath="//td[contains(text(),'Videos')]")
	public WebElement videos;
	@FindBy(xpath="//td[contains(text(),'Daily Reports')]")
	public WebElement dailyReports;
	@FindBy(xpath="//td[contains(text(),'Payments')]")
	public WebElement payments;
}
