package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class ViewStaffObject extends SetUp{

	WebDriver driver;
	
	public ViewStaffObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//label[contains(text(),'Name')]//following::p[1]")
	public WebElement viewName;
	@FindBy(xpath="//label[contains(text(),'Phone Number')]//following::p[1]")
	public WebElement viewphoneNumber;
	@FindBy(xpath="//label[contains(text(),'Email')]//following::p[1]")
	public WebElement viewEmail;
	@FindBy(xpath="//label[contains(text(),'Role Type')]//following::p[1]")
	public WebElement viewRole;
	@FindBy(xpath="//label[contains(text(),'Status')]//following::p[1]")
	public WebElement viewStatus;
	
	@FindBy(xpath="//span[contains(text(),'Activate')]")
	public WebElement activateButton;
	@FindBy(xpath="//span[contains(text(),'Deactivate')]")
	public WebElement deactivateButton;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement yesButton;
	
	@FindBy(xpath="//div[@aria-label='Darisni Employee has been deactivated']")
	public WebElement deactivateMsg;
	@FindBy(xpath="//div[@aria-label='Darisni Employee has been activated']")
	public WebElement activateMsg;
}
