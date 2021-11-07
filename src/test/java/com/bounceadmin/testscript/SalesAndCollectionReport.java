package com.bounceadmin.testscript;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.SalesAndCollectionReportObject;
import com.bounceadmin.testdata.ReportsData;
import com.bounceadmin.testdata.TestDataImport;

public class SalesAndCollectionReport extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	TestDataImport tdImport;
	ReportsData reportdataObj;
	SalesAndCollectionReportObject sandareportObj;
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			tdImport = new TestDataImport();
			reportdataObj = new ReportsData();
			sandareportObj = new SalesAndCollectionReportObject(driver);

			tdImport.readSheet("Reports");
			
			driver.navigate().refresh();
			loginObj.logIn(userEmail,userPassword);
			loginObj.selectRole();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	@Test(priority=1)
	public void filterByCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			list = new ArrayList<String>();

			log.info("Entered filterByCountry test");
			eTest = eReports.createTest("Filter By Country");
			eTest.assignCategory("Sales And Collection Report");

			boolean condition=false;
			int c=0;
			String[] country = reportdataObj.countries() ;
			Set<String> countrySet = new HashSet<String>(Arrays.asList(country));

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.salesAndCollectionReport.click();
			waitForElementToLoad(sandareportObj.filterButton);
			autoScrollandClick(sandareportObj.country);
			for(int i=0;i<country.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[normalize-space()='"+country[i]+"'][1]")));;
			}
			autoScrollandClick(sandareportObj.country);
			sandareportObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(sandareportObj.totalRecords);
			System.out.println(sandareportObj.totalRecords.getText());
			String countstring=sandareportObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			expectedBoolArray.add(true);
	
			while(condition==false)
			{
				condition = isElementPresent(sandareportObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						list.add(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[1]")).getText());
					}
				}

				if(!isElementPresent(sandareportObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(sandareportObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(sandareportObj.resetButton);
			autoScrollandClick(sandareportObj.resetButton);
			autoScrollandClick(dashboardObj.reports);
			String[] array = list.toArray(new String[0]);
			Set<String> unique = new HashSet<String>(Arrays.asList(array));
			actualBoolArray.add(countrySet.containsAll(unique));   
			System.out.println(list);
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
	public void filterByNursery() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			list = new ArrayList<String>();

			log.info("Entered filterByNursery test");
			eTest = eReports.createTest("Filter By Nursery");
			eTest.assignCategory("Sales And Collection Report");

			boolean condition=false;
			int c=0;
			String[] nursery = reportdataObj.nurseries();
			Set<String> nurserySet = new HashSet<String>(Arrays.asList(nursery));

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.salesAndCollectionReport.click();
			waitForElementToLoad(sandareportObj.filterButton);
			autoScrollandClick(sandareportObj.nursery);
			for(int i=0;i<nursery.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Nursery')]//following::div[normalize-space()='"+nursery[i]+"'][1]")));
			}
			autoScrollandClick(sandareportObj.nursery);
			sandareportObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(sandareportObj.totalRecords);
			System.out.println(sandareportObj.totalRecords.getText());
			String countstring=sandareportObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			expectedBoolArray.add(true);
	
			while(condition==false)
			{
				condition = isElementPresent(sandareportObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						list.add(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[1]")).getText());
					}
				}

				if(!isElementPresent(sandareportObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(sandareportObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(sandareportObj.resetButton);
			autoScrollandClick(sandareportObj.resetButton);
			autoScrollandClick(dashboardObj.reports);
			String[] array = list2.toArray(new String[0]);
			Set<String> unique = new HashSet<String>(Arrays.asList(array)); 
			actualBoolArray.add(nurserySet.containsAll(unique));
			System.out.println(list);
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
	
	@Test(priority=3)
	public void filterByCountryNursery() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			list = new ArrayList<String>();
			list2 = new ArrayList<String>();

			log.info("Entered filterByCountry test");
			eTest = eReports.createTest("Filter By Country and Nursery");
			eTest.assignCategory("Sales And Collection Report");

			boolean condition=false;
			int c=0;
			String[] country = reportdataObj.countries() ;
			Set<String> countrySet = new HashSet<String>(Arrays.asList(country));
			String[] nursery = reportdataObj.nurseries();
			Set<String> nurserySet = new HashSet<String>(Arrays.asList(nursery));

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.salesAndCollectionReport.click();
			waitForElementToLoad(sandareportObj.filterButton);
			autoScrollandClick(sandareportObj.country);
			for(int i=0;i<country.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[normalize-space()='"+country[i]+"'][1]")));;
			}
			autoScrollandClick(sandareportObj.country);
			sandareportObj.nursery.click();
			for(int i=0;i<nursery.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Nursery')]//following::div[normalize-space()='"+nursery[i]+"'][1]")));
			}
			sandareportObj.nursery.click();

			sandareportObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(sandareportObj.totalRecords);
			System.out.println(sandareportObj.totalRecords.getText());
			String countstring=sandareportObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			expectedBoolArray.add(true);expectedBoolArray.add(true);
	
			while(condition==false)
			{
				condition = isElementPresent(sandareportObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						list.add(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[1]")).getText());
						list2.add(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[1]")).getText());
					}
				}

				if(!isElementPresent(sandareportObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(sandareportObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(sandareportObj.resetButton);
			autoScrollandClick(sandareportObj.resetButton);
			autoScrollandClick(dashboardObj.nurseries);
			String[] array = list.toArray(new String[0]);
			Set<String> unique1 = new HashSet<String>(Arrays.asList(array));
			String[] array2 = list2.toArray(new String[0]);
			Set<String> unique2 = new HashSet<String>(Arrays.asList(array2));
			actualBoolArray.add(countrySet.containsAll(unique1));  
			actualBoolArray.add(nurserySet.containsAll(unique2));
			
			
			System.out.println(list2);
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
	
	@Test(priority=4) 
	public void verifyPrintClickCancel() //verify print page is loaded when print button clicked and click print
	{
		try
		{
			log.info("Entered verifyPrintClickCancel test");
			eTest = eReports.createTest("Verify Print - ClickCancel");
			eTest.assignCategory("Sales And Collection Report");
			
			expectedMsg = "PRINT";
			String[] country = reportdataObj.countries() ;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.salesAndCollectionReport.click();
			waitForElementToLoad(sandareportObj.filterButton);
			autoScrollandClick(sandareportObj.country);
			for(int i=0;i<country.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[normalize-space()='"+country[i]+"'][1]")));;
			}
			autoScrollandClick(sandareportObj.country);
			autoScrollandClick(sandareportObj.filterButton);
			Thread.sleep(2000);
			waitForElementToLoad(sandareportObj.printButton);
			sandareportObj.printButton.click();
			
			actualMsg = driver.switchTo().activeElement().getAttribute("innerText");
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			waitForElementToLoad(sandareportObj.resetButton);
			autoScrollandClick(sandareportObj.resetButton);
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		Assert.assertEquals(expectedMsg, actualMsg);
	}
	
	@Test(priority=5) 
	public void verifyPrintClickPrint() //verify print page is loaded when print button clicked and click print
	{
		try
		{
			log.info("Entered verifyPrintClickPrint test");
			eTest = eReports.createTest("Verify Print - ClickPrint");
			eTest.assignCategory("Sales And Collection Report");
			
			expectedMsg = "PRINT";
			String[] country = reportdataObj.countries() ;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.salesAndCollectionReport.click();
			waitForElementToLoad(sandareportObj.filterButton);
			autoScrollandClick(sandareportObj.country);
			for(int i=0;i<country.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[normalize-space()='"+country[i]+"'][1]")));;
			}
			autoScrollandClick(sandareportObj.country);
			autoScrollandClick(sandareportObj.filterButton);
			Thread.sleep(2000);
			waitForElementToLoad(sandareportObj.printButton);
			sandareportObj.printButton.click();
			
			actualMsg = driver.switchTo().activeElement().getAttribute("innerText");
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			for(int i=0;i<4;i++)
			{
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			waitForElementToLoad(sandareportObj.resetButton);
			autoScrollandClick(sandareportObj.resetButton);
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		Assert.assertEquals(expectedMsg, actualMsg);
	}
	
	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}
}
