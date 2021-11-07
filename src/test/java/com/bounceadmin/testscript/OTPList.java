package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.OTPListObject;

public class OTPList extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	OTPListObject otplistObj;
	String[] testData;


	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			otplistObj = new OTPListObject(driver);

			loginObj.logIn(userEmail,userPassword);
			waitForElementToLoad(loginObj.selectDarisnisuperAdmin);
			loginObj.selectDarisnisuperAdmin.click();
			loginObj.selectButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}

	@Test(priority=1)
	public void verifyHeadersAndfilterByStatus() //verify table headers and filter by status
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatus test");
			eTest = eReports.createTest("Filter By Status");
			eTest.assignCategory("Configurations - OTP List");
			boolean condition=false;
			int c=0;

			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			dashboardObj.otpList.click();
			waitForElementToLoad(otplistObj.status);
			otplistObj.status.sendKeys("Active");
			otplistObj.filterButton.click();

			Thread.sleep(1500);
			waitForElementToLoad(otplistObj.totalRecords);
			System.out.println(otplistObj.totalRecords.getText());
			String countstring=otplistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count+5;i++)
			{
				expectedBoolArray.add(true);
			}

			actualBoolArray.add(isElementPresent(otplistObj.slNo));
			actualBoolArray.add(isElementPresent(otplistObj.phone));
			actualBoolArray.add(isElementPresent(otplistObj.otp));
			actualBoolArray.add(isElementPresent(otplistObj.type));
			actualBoolArray.add(isElementPresent(otplistObj.stat));

			while(condition==false)
			{
				condition = isElementPresent(otplistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'Active')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(otplistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(otplistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(otplistObj.resetButton);
			autoScrollandClick(otplistObj.resetButton);
			autoScrollandClick(dashboardObj.configurations);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}

	@Test(priority=2)
	public void filterByPhoneCode() //filter by phone code
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered filterByStatus test");
			eTest = eReports.createTest("Filter By Phonecode");
			eTest.assignCategory("Configurations - OTP List");
			boolean condition=false;
			int c=0;

			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			dashboardObj.otpList.click();
			waitForElementToLoad(otplistObj.phoneCode);
			otplistObj.phoneCode.sendKeys("Kuwait (+965)");
			autoScrollandClick(otplistObj.filterButton);
			autoScrollandClick(otplistObj.filterButton);

			Thread.sleep(2000);
			waitForElementToLoad(otplistObj.totalRecords);
			System.out.println(otplistObj.totalRecords.getText());
			String countstring=otplistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedArraylist.add("+965");
			}

			while(condition==false)
			{
				condition = isElementPresent(otplistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						String value =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]")).getText().split(" ")[0];
						actualArraylist.add(value);
					}
				}

				if(!isElementPresent(otplistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(otplistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(otplistObj.resetButton);
			autoScrollandClick(otplistObj.resetButton);
			autoScrollandClick(dashboardObj.configurations);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedArraylist);
		System.out.println(actualArraylist);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");
	}

	@Test(priority=3)
	public void verifySortForPhoneNumber()
	{
		try
		{

			log.info("Entered verifySortForPhoneNumber test");
			eTest = eReports.createTest("Verify Sort For PhoneNumber");
			eTest.assignCategory("Configurations - OTP List");

			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			dashboardObj.otpList.click();

			expectedMsg = verifySortButton(otplistObj.phoneNumSortButton, otplistObj.sortedphoneNum);
			actualMsg = otplistObj.sortedphoneNum.getText();
			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}

	@Test(priority=4)
	public void verifySortForCreatedDate()
	{
		try
		{

			log.info("Entered verifySortForCreatedDate test");
			eTest = eReports.createTest("Verify Sort For CreatedDate");
			eTest.assignCategory("Configurations - OTP List");

			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			dashboardObj.otpList.click();

			expectedMsg = verifySortButton(otplistObj.createDateSortButton, otplistObj.sortedDate);
			actualMsg = otplistObj.sortedDate.getText();
			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}

	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}
}
