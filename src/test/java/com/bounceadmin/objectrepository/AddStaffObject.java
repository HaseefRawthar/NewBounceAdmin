package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class AddStaffObject extends SetUp {

	WebDriver driver;

	public AddStaffObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath="//input[@formcontrolname='firstName']//following::small[contains(text(),'First name is required.')]")
	public WebElement firstNameMandatoryMsg;
	@FindBy(xpath="//input[@formcontrolname='email']//following::small[contains(text(),'Email is required.')]")
	public WebElement emailMandatoryMsg;
	@FindBy(xpath="//select[@formcontrolname='phoneNumberCode']//following::small[contains(text(),'Code is required')]")
	public WebElement countryCodeMandatoryMsg;
	@FindBy(xpath="//input[@formcontrolname='phoneNumber']//following::small[contains(text(),'Phone number is required.')]")
	public WebElement phoneNumberMandatoryMsg;
	@FindBy(xpath="//div[@aria-label='Please select atleast one role']")
	public WebElement roleMandatoryMsg;

	@FindBy(xpath="//label[contains(text(),'Bounce Admin')]")
	public WebElement bounceAdmin;
	@FindBy(xpath="//label[contains(text(),'Customer Support Agent')]")
	public WebElement customerSupportAgent;
	@FindBy(xpath="//label[contains(text(),'Sample')]")
	public WebElement sample;
	@FindBy(xpath="//label[contains(text(),'InsAdmin')]")
	public WebElement insAdmin;
	@FindBy(xpath="//label[contains(text(),'Newrole')]")
	public WebElement newRole;
	@FindBy(xpath="//label[contains(text(),'Active Student Report Only')]")
	public WebElement activeStudentReportOnly;
	@FindBy(xpath="//label[contains(text(),'Testrole')]")
	public WebElement testRole;
	
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	public WebElement firstName;
	@FindBy(xpath="//input[@formcontrolname='middleName']")
	public WebElement middleName;
	@FindBy(xpath="//input[@formcontrolname='lastName']")
	public WebElement lastName;
	@FindBy(xpath="//input[@formcontrolname='email']")
	public WebElement email;
	@FindBy(xpath="//select[@formcontrolname='phoneNumberCode']")
	public WebElement countryCode;
	@FindBy(xpath="//input[@formcontrolname='phoneNumber']")
	public WebElement phoneNumber;

	@FindBy(xpath="//button[contains(text(),'ADD')]")
	public WebElement addButton;

	@FindBy(xpath="//div[@aria-label='Dars Employee created successfully']")
	public WebElement staffSuccessMsg;

	public void addStaffDetails(String[] test) //add staff details
	{
		try
		{
			waitForElementToLoad(firstName);
			firstName.sendKeys(test[0]);
			middleName.sendKeys(test[1]);
			lastName.sendKeys(test[2]);
			email.sendKeys(test[3]);
			countryCode.sendKeys(test[4]);
			phoneNumber.sendKeys(test[5]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info(e);
		}

	}
}
