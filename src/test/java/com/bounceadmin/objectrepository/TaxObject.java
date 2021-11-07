package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class TaxObject extends SetUp {

	WebDriver driver;

	public TaxObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Bahrain')]")
	public WebElement baharain;
	@FindBy(xpath="//td[contains(text(),'Egypt')]")
	public WebElement egypt;
	@FindBy(xpath="//td[contains(text(),'India')]")
	public WebElement india;
	@FindBy(xpath="//td[contains(text(),'Jordan')]")
	public WebElement jordan;
	@FindBy(xpath="//td[contains(text(),'Kuwait')]")
	public WebElement kuwait;
	@FindBy(xpath="//td[contains(text(),'Oman')]")
	public WebElement oman;
	@FindBy(xpath="//td[contains(text(),'Qatar')]")
	public WebElement qatar;
	@FindBy(xpath="//td[contains(text(),'Saudi Arabia')]")
	public WebElement saudiArabia;
	@FindBy(xpath="//td[contains(text(),'UAE')]")
	public WebElement uae;
	
	@FindBy(xpath="//tbody/tr[1]/td[3]/div[1]/span[1]/i[1]")
	public WebElement editBaharainTax;
	@FindBy(xpath="//input[@formcontrolname='tax']")
	public WebElement tax;
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	public WebElement baharainTax;
	@FindBy(xpath="//tbody/tr[1]/td[3]/div[1]/span[1]/i[1]")
	public WebElement tickButton;
	@FindBy(xpath="//tbody/tr[1]/td[3]/div[1]/span[1]/i[2]")
	public WebElement crossButton;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement yesButton;
	@FindBy(xpath="//div[@aria-label='Success']")
	public WebElement success;
}
