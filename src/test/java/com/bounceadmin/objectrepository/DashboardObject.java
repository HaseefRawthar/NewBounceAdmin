package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class DashboardObject extends SetUp {

	WebDriver driver;

	public DashboardObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath="//a[@id='3']//child::span")
	public WebElement currentRole;
	@FindBy(xpath="//a[@id='3']//child::span[contains(text(),'Darisni Super Admin')]")
	public WebElement DarisniSuperAdmin;
	@FindBy(xpath="//a[@id='3']//child::span[contains(text(),'Bounce Admin')]")
	public WebElement BounceAdmin;

	@FindBy(xpath="//h5[contains(text(),'Darisni Super Admin')]")
	public WebElement superAdmin;
	@FindBy(xpath="//h5[contains(text(),'Bounce Admin')]")
	public WebElement Admin;



	@FindBy(xpath="//div[@class='card nursery_dashboard_widget text-white']//child::h4")
	public WebElement nursery;
	@FindBy(xpath="//div[@class='card students_dashboard_widget text-white']//child::h4")
	public WebElement students;
	@FindBy(xpath="//div[@class='card parents_dashboard_widget text-white']//child::h4")
	public WebElement parents;
	@FindBy(xpath="//h4[contains(text(),'Employees')]")
	public WebElement employees;

	@FindBy(xpath="//span[contains(text(),'Nurseries')]")
	public WebElement nurseries;
	@FindBy(xpath="//span[contains(text(),'Add Nursery')]")
	public WebElement addNursery;
	@FindBy(xpath="//span[contains(text(),'Nursery List')]")
	public WebElement listNursery;

	@FindBy(xpath="//span[normalize-space()='Payment Transactions']")
	public WebElement paymentTransactions;
	@FindBy(xpath="//span[contains(text(),'Payment Transactions List')]")
	public WebElement paymentTransactionsList;

	@FindBy(xpath="//span[contains(text(),'Transfers')]")
	public WebElement transfers;
	@FindBy(xpath="//span[contains(text(),'Transfer List')]")
	public WebElement transferList;

	@FindBy(xpath="//span[normalize-space()='Staff']")
	public WebElement staff;
	@FindBy(xpath="//span[contains(text(),'Add Staff')]")
	public WebElement addStaff;
	@FindBy(xpath="//span[contains(text(),'Staff List')]")
	public WebElement listStaff;


	@FindBy(xpath="//span[contains(text(),'Reports')]")
	public WebElement reports;
	@FindBy(xpath="//span[contains(text(),'Activity Report')]")
	public WebElement activityReport;
	@FindBy(xpath="//span[contains(text(),'Lvc Report')]")
	public WebElement lvcReport;
	@FindBy(xpath="//span[contains(text(),'Resource Detail Report')]")
	public WebElement resourceDetailReport;
	@FindBy(xpath="//span[contains(text(),'Active Students')]")
	public WebElement activeStudents;
	@FindBy(xpath="//span[contains(text(),'Sales Commission Report')]")
	public WebElement salesCommissionReport;
	@FindBy(xpath="//span[contains(text(),'Sales and Collection Report')]")
	public WebElement salesAndCollectionReport;

	@FindBy(xpath="//span[contains(text(),'DAU Report')]")
	public WebElement DauReport;

	@FindBy(xpath="//span[contains(text(),'Configurations')]")
	public WebElement configurations;
	@FindBy(xpath="//span[contains(text(),'Notification Template')]")
	public WebElement notificationTemplate;
	@FindBy(xpath="//span[contains(text(),'OTP List')]")
	public WebElement otpList;
	@FindBy(xpath="//span[contains(text(),'Tax')]")
	public WebElement tax;
	@FindBy(xpath="//span[contains(text(),'Payment Gateway')]")
	public WebElement paymentGateway;

	@FindBy(xpath="//li[@class='nav-item dropdown']//child::a")
	public WebElement profile;
	@FindBy(xpath="//button[@id='logout-link']")
	public WebElement logoutButton;

	public void logout()
	{
		try
		{
			waitIfElementClickIsIntercepted(profile, "click", "");

			waitForElementToLoad(logoutButton);
			logoutButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}

	public void clickAddNurseries()
	{
		try
		{
			waitIfElementClickIsIntercepted(nurseries, "click", "");

			waitIfElementClickIsIntercepted(addNursery, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}	
	}

	public void clickListNurseries()
	{
		try
		{
			waitIfElementClickIsIntercepted(nurseries, "click", "");
			waitIfElementClickIsIntercepted(listNursery, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}

}
