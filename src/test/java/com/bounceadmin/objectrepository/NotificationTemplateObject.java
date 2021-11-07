package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class NotificationTemplateObject extends SetUp {

	WebDriver driver;
	
	public NotificationTemplateObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Add welcome mail')]")
	public WebElement addWelcomeMail;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Institution add password')]")
	public WebElement institutionAddPassword;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[3]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'New user profile added')]")
	public WebElement newUserProfileAdded;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[4]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Password changed')]")
	public WebElement passwordChanged;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[5]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Reset password')]")
	public WebElement nurseryResetPassword;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[6]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Add employee to nursery')]")
	public WebElement addEmployeeToNursery;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[7]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Student add parent1 verification')]")
	public WebElement addParent1;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[8]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Student add parent2 verification')]")
	public WebElement addParent2;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[9]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'OTP Verification')]")
	public WebElement otpVerification;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[10]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Resend OTP')]")
	public WebElement resentOtp;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[11]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Edit Account')]")
	public WebElement editAccount;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[12]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Payment Successful')]")
	public WebElement paymentSucessful;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[13]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Payment Failed')]")
	public WebElement paymentFailed;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[14]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'New Nursery Added')]")
	public WebElement newDarsInstitutionAdd;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[15]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Institution Status Update')]")
	public WebElement institutionStatUpdate;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[16]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Support Ticket Created')]")
	public WebElement suprtTktCreated;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[17]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Support Ticket Revoked')]")
	public WebElement suprtTktRevoked;
	@FindBy(xpath="//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[18]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'Support Ticket Expired')]")
	public WebElement suprtTktExpired;
	
}
