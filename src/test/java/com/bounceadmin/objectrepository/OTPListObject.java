package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class OTPListObject extends SetUp{

	WebDriver driver;
	
	public OTPListObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//select[@formcontrolname='status']")
	public WebElement status;
	@FindBy(xpath="//label[contains(text(),'From')]//following::input[1]")
	public WebElement fromDate;
	@FindBy(xpath="//label[contains(text(),'To')]//following::input[1]")
	public WebElement toDate;
	@FindBy(xpath="//select[@formcontrolname='phoneCode']")
	public WebElement phoneCode;
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	public WebElement phoneNumber;
	
	@FindBy(xpath="//span[contains(text(),'Sl.No')]")
	public WebElement slNo;
	@FindBy(xpath="//span[contains(text(),'Phone Number')]")
	public WebElement phone;
	@FindBy(xpath="//span[normalize-space()='OTP']")
	public WebElement otp;
	@FindBy(xpath="//span[contains(text(),'Type')]")
	public WebElement type;
	@FindBy(xpath="//span[contains(text(),'Status')]")
	public WebElement stat;
	
	@FindBy(xpath="//button[contains(text(),'Filter')]")
	public WebElement filterButton;
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	public WebElement resetButton;
	
	@FindBy(xpath="//div[@class='total-rows']//span[@class='mobile-hidden']")
	public WebElement totalRecords;
	@FindBy(xpath="//a[@aria-label='go to next page']//i")
	public WebElement goToNextPage;
	@FindBy(xpath="//li[@class='disabled']//a[@aria-label='go to next page']")
	public WebElement lastpagecheck;
	
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[3]/div[1]/span[2]")
	public WebElement phoneNumSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[6]/div[1]/span[2]")
	public WebElement createDateSortButton;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]")
	public WebElement sortedphoneNum;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]")
	public WebElement sortedDate;
}
