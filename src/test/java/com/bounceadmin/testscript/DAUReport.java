package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DAUReportObject;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;

public class DAUReport extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	DAUReportObject daurreportObj;
	String[] testData;
	
	
	@BeforeClass
	public void initialize()
	{
		loginObj = new LogInObject(driver);
		dashboardObj = new DashboardObject(driver);
	    daurreportObj = new DAUReportObject(driver);
		
		loginObj.logIn(userEmail,userPassword);
		loginObj.selectRole();
	}
	
	@Test(priority=1)
	public void filterReportByCountry()//verify all fields are present
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			boolean condition=false;
			int c=0;
			String country ="Kuwait";
			log.info("Entered filterReportByCountry test");
			eTest = eReports.createTest("Filter DAU Report By Country");
			eTest.assignCategory("DAU Reports");
			
			waitIfElementClickIsIntercepted(dashboardObj.DauReport, "click", "");
			
			waitForElementToLoad(daurreportObj.country);
			daurreportObj.country.sendKeys(country);
			daurreportObj.filterButton.click();
			
			for(int i=0;i<4;i++)
			{
				expectedBoolArray.add(true);
			}
			waitForElementToLoad(daurreportObj.NurseryName);
			actualBoolArray.add(isElementPresent(daurreportObj.slno));
			actualBoolArray.add(isElementPresent(daurreportObj.NurseryName));
			actualBoolArray.add(isElementPresent(daurreportObj.countryname));
			actualBoolArray.add(isElementPresent(daurreportObj.noOfActiveStudents));
			
			Thread.sleep(1500);
			waitForElementToLoad(daurreportObj.totalRecords);
			System.out.println(daurreportObj.totalRecords.getText());
			String countstring=daurreportObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(daurreportObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[4]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(daurreportObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(daurreportObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			
			
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
	public void filterReportByNurseryName()//verify all fields are present
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			boolean condition=false;
			int c=0;
			String name = "Academy LVC";
			log.info("Entered filterReportByNurseryName test");
			eTest = eReports.createTest("filterReportByNurseryName");
			eTest.assignCategory("DAU Reports");
			
			waitIfElementClickIsIntercepted(dashboardObj.DauReport, "click", "");
			
			waitForElementToLoad(daurreportObj.resetButton);
			autoScrollandClick(daurreportObj.resetButton);
			waitForElementToLoad(daurreportObj.nurseryName);
			daurreportObj.nurseryName.sendKeys(name);
			daurreportObj.filterButton.click();
			driver.navigate().refresh();
			
			for(int i=0;i<4;i++)
			{
				expectedBoolArray.add(true);
			}
			waitForElementToLoad(daurreportObj.NurseryName);
			actualBoolArray.add(isElementPresent(daurreportObj.slno));
			actualBoolArray.add(isElementPresent(daurreportObj.NurseryName));
			actualBoolArray.add(isElementPresent(daurreportObj.countryname));
			actualBoolArray.add(isElementPresent(daurreportObj.noOfActiveStudents));
			
			Thread.sleep(1500);
			waitForElementToLoad(daurreportObj.totalRecords);
			System.out.println(daurreportObj.totalRecords.getText());
			String countstring=daurreportObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(daurreportObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//span[contains(text(),'"+name+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(daurreportObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(daurreportObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			
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
