package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class PaymentGatewayObject extends SetUp{

	WebDriver driver;

	public PaymentGatewayObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//input[@formcontrolname='fixedFee']")
	public WebElement fixedFee;
	@FindBy(xpath="//input[@formcontrolname='variableFee']")
	public WebElement variableFee;
	
	@FindBy(xpath="//table[1]/tbody[1]/tr[2]/td[8]/span[1]/i[1]")
	public WebElement tickButton;
	@FindBy(xpath="//table[1]/tbody[1]/tr[2]/td[8]/span[1]/i[2]")
	public WebElement crossButton;
	@FindBy(xpath="//tbody/tr[2]/td[8]/span[1]/i[1]")
	public WebElement editBaharain;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement yesButton;
	@FindBy(xpath="//div[@aria-label='Success']")
	public WebElement success;
	
	@FindBy(xpath="//tbody/tr[2]/td[5]/span[1]")
	public WebElement baharainFixed;
	@FindBy(xpath="//tbody/tr[2]/td[6]/span[1]")
	public WebElement baharainVariable;
}
