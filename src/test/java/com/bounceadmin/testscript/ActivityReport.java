package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.ActivityReportObject;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;

public class ActivityReport extends SetUp{

	LogInObject loginObj;
	DashboardObject dashboardObj;
	ActivityReportObject activityreportObj;
	String[] testData;


	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			activityreportObj = new ActivityReportObject(driver);

			driver.navigate().refresh();
			loginObj.logIn(userEmail,userPassword);
			waitForElementToLoad(loginObj.selectBounceAdmin);
			loginObj.selectBounceAdmin.click();
			loginObj.selectButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}

	@Test(priority=1)
	public void filterReportByCountry() //filter by country and verify all fields are present
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterReportByCountry test");
			eTest = eReports.createTest("Filter Activity Report by country");
			eTest.assignCategory("Activity Reports");

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activityReport.click();

			waitForElementToLoad(activityreportObj.country);
			activityreportObj.country.sendKeys("Kuwait");
			activityreportObj.filterButton.click();

			for(int i=0;i<10;i++)
			{
				expectedBoolArray.add(true);
			}
			waitForElementToLoad(activityreportObj.type);
			actualBoolArray.add(isElementPresent(activityreportObj.type));
			actualBoolArray.add(isElementPresent(activityreportObj.activity));
			actualBoolArray.add(isElementPresent(activityreportObj.countOfComments));
			actualBoolArray.add(isElementPresent(activityreportObj.countOfReplies));
			actualBoolArray.add(isElementPresent(activityreportObj.announcements));
			actualBoolArray.add(isElementPresent(activityreportObj.events));
			actualBoolArray.add(isElementPresent(activityreportObj.images));
			actualBoolArray.add(isElementPresent(activityreportObj.videos));
			actualBoolArray.add(isElementPresent(activityreportObj.dailyReports));
			actualBoolArray.add(isElementPresent(activityreportObj.payments));

			waitForElementToLoad(activityreportObj.resetButton);
			autoScrollandClick(activityreportObj.resetButton);
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
	public void filterReportByNurseryName() //filter by nursery name and verify all fields are present
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterReportByNurseryName test");
			eTest = eReports.createTest("Filter Activity Report by NurseryNmae");
			eTest.assignCategory("Activity Reports");

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activityReport.click();

			waitForElementToLoad(activityreportObj.nurseryName);
			activityreportObj.nurseryName.sendKeys("Kuwait Nursery");
			activityreportObj.filterButton.click();

			for(int i=0;i<10;i++)
			{
				expectedBoolArray.add(true);
			}
			waitForElementToLoad(activityreportObj.type);
			actualBoolArray.add(isElementPresent(activityreportObj.type));
			actualBoolArray.add(isElementPresent(activityreportObj.activity));
			actualBoolArray.add(isElementPresent(activityreportObj.countOfComments));
			actualBoolArray.add(isElementPresent(activityreportObj.countOfReplies));
			actualBoolArray.add(isElementPresent(activityreportObj.announcements));
			actualBoolArray.add(isElementPresent(activityreportObj.events));
			actualBoolArray.add(isElementPresent(activityreportObj.images));
			actualBoolArray.add(isElementPresent(activityreportObj.videos));
			actualBoolArray.add(isElementPresent(activityreportObj.dailyReports));
			actualBoolArray.add(isElementPresent(activityreportObj.payments));

			waitForElementToLoad(activityreportObj.resetButton);
			autoScrollandClick(activityreportObj.resetButton);
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
