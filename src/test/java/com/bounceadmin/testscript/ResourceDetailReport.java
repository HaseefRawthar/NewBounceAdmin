package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.ResourceDetailReportObject;

public class ResourceDetailReport extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	ResourceDetailReportObject resourcedetailrepoObj;
	String[] testData;
	
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
		    resourcedetailrepoObj = new ResourceDetailReportObject(driver);
			
			loginObj.logIn(userEmail,userPassword);
			loginObj.selectRole();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	@Test(priority=1)
	public void filterReportByNurseryName()//verify all fields are present
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterReportByCountry test");
			eTest = eReports.createTest("Filter Report By Country");
			eTest.assignCategory("Resource Detail Reports");
			
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.resourceDetailReport.click();
			
			waitForElementToLoad(resourcedetailrepoObj.nurseryName);
			resourcedetailrepoObj.nurseryName.sendKeys("Kuwait Nursery");
			resourcedetailrepoObj.filterButton.click();
			
			for(int i=0;i<3;i++)
			{
				expectedBoolArray.add(true);
			}
			waitForElementToLoad(resourcedetailrepoObj.NurseryName);
			actualBoolArray.add(isElementPresent(resourcedetailrepoObj.NurseryName));
			actualBoolArray.add(isElementPresent(resourcedetailrepoObj.imageCount));
			actualBoolArray.add(isElementPresent(resourcedetailrepoObj.videoCount));
			
			waitForElementToLoad(resourcedetailrepoObj.resetButton);
			autoScrollandClick(resourcedetailrepoObj.resetButton);
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
	public void filterReportByCountry()//verify all fields are present
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterReportByCountry test");
			eTest = eReports.createTest("Filter Report By Country");
			eTest.assignCategory("Resource Detail Reports");
			
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.resourceDetailReport.click();
			
			waitForElementToLoad(resourcedetailrepoObj.country);
			resourcedetailrepoObj.country.sendKeys("Kuwait");
			resourcedetailrepoObj.filterButton.click();
			
			for(int i=0;i<3;i++)
			{
				expectedBoolArray.add(true);
			}
			waitForElementToLoad(resourcedetailrepoObj.NurseryName);
			actualBoolArray.add(isElementPresent(resourcedetailrepoObj.NurseryName));
			actualBoolArray.add(isElementPresent(resourcedetailrepoObj.imageCount));
			actualBoolArray.add(isElementPresent(resourcedetailrepoObj.videoCount));
			
			waitForElementToLoad(resourcedetailrepoObj.resetButton);
			autoScrollandClick(resourcedetailrepoObj.resetButton);
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
