package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.LvcReportObject;

public class LvcReport extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	LvcReportObject lvcreportObj;
	String[] testData;
	
	
	@BeforeClass
	public void initialize() 
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
		    lvcreportObj = new LvcReportObject(driver);
			
			loginObj.logIn(userEmail,userPassword);
			loginObj.selectRole();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	@Test(priority=1)
	public void filterReportByCountry() //filter by country and verify all elements are present
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterReportByCountry test");
			eTest = eReports.createTest("Filter Report By Country");
			eTest.assignCategory("Lvc Reports");
			
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.lvcReport.click();
			
			waitForElementToLoad(lvcreportObj.country);
			lvcreportObj.country.sendKeys("Kuwait");
			lvcreportObj.filterButton.click();
			
			for(int i=0;i<3;i++)
			{
				expectedBoolArray.add(true);
			}
			waitForElementToLoad(lvcreportObj.launched);
			actualBoolArray.add(isElementPresent(lvcreportObj.launched));
			actualBoolArray.add(isElementPresent(lvcreportObj.attendees));
			actualBoolArray.add(isElementPresent(lvcreportObj.averageLength));
			
			waitForElementToLoad(lvcreportObj.resetButton);
			autoScrollandClick(lvcreportObj.resetButton);
			autoScrollandClick(dashboardObj.reports);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion Passed");
	}
	
	@Test(priority=2)
	public void filterReportByNurseryName() //filter by nursery name and verify all elements are present
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterReportByNurseryName test");
			eTest = eReports.createTest("Filter Report By NurseryName");
			eTest.assignCategory("Lvc Reports");
			
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.lvcReport.click();
			
			waitForElementToLoad(lvcreportObj.nurseryName);
			lvcreportObj.nurseryName.sendKeys("Kuwait Nursery");
			lvcreportObj.filterButton.click();
			
			for(int i=0;i<3;i++)
			{
				expectedBoolArray.add(true);
			}
			waitForElementToLoad(lvcreportObj.launched);
			actualBoolArray.add(isElementPresent(lvcreportObj.launched));
			actualBoolArray.add(isElementPresent(lvcreportObj.attendees));
			actualBoolArray.add(isElementPresent(lvcreportObj.averageLength));
			
			waitForElementToLoad(lvcreportObj.resetButton);
			autoScrollandClick(lvcreportObj.resetButton);
			autoScrollandClick(dashboardObj.reports);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion Passed");
	}
	
	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}
}
