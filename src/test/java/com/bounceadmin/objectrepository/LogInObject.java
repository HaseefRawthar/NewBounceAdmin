package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class LogInObject extends SetUp {

	WebDriver driver;
	
	public LogInObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		
	}
	
	@FindBy(xpath="//input[@placeholder = 'Email']")
	public WebElement loginEmail;
	@FindBy(xpath="//input[@placeholder = 'Password']")
	public WebElement loginPassword;
	@FindBy(xpath="//button[contains(text(),'LogIn')]")
	public WebElement loginButton;
	
	@FindBy(xpath="//div[@class='row']//child::small[1]")
	public WebElement noEmailMsg;
	@FindBy(xpath="//div[@class='row']//child::small[2]")
	public WebElement noPasswordMsg;
	
	@FindBy(xpath="//div[@role='alertdialog']")
	public WebElement invalidMsg;
	@FindBy(xpath="//div[@role='alertdialog']")
	public WebElement invalidEmailMsg;
	
	//@FindBy(xpath="//label[contains(text(),'Darisni Admin')]")
	//public WebElement selectDarisniAdmin;
	@FindBy(xpath="//label[contains(text(),'Bounce Admin')]")
	public WebElement selectBounceAdmin;
	@FindBy(xpath="//label[contains(text(),'Darisni Super Admin')]")
	public WebElement selectDarisnisuperAdmin;
	@FindBy(xpath="//button[contains(text(),'Select')]")
	public WebElement selectButton;
	
	public void logIn(String email, String password)
	{
		try {
			log.info("Entered logIn method");
			waitForElementToLoad(loginButton);
			waitForElementToLoad(loginEmail);
			loginEmail.clear();
			loginEmail.sendKeys(email);
			loginPassword.clear();
			loginPassword.sendKeys(password);
			loginButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	
	public void selectRole()
	{
		try
		{
			waitForElementToLoad(selectBounceAdmin);
			selectBounceAdmin.click();
			selectButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
}
