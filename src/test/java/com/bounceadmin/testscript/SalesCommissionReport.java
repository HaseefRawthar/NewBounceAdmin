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
import com.bounceadmin.objectrepository.SalesCommisionReportObject;
import com.bounceadmin.testdata.ReportsData;
import com.bounceadmin.testdata.TestDataImport;

public class SalesCommissionReport extends SetUp{

	LogInObject loginObj;
	DashboardObject dashboardObj;
	TestDataImport tdImport;
	ReportsData reportdataObj;
	SalesCommisionReportObject salescommsionreportObj;
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			salescommsionreportObj = new SalesCommisionReportObject(driver);
			tdImport = new TestDataImport();
			reportdataObj = new ReportsData();
			
			tdImport.readSheet("Reports");

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
	public void filterByCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			list = new ArrayList<String>();

			log.info("Entered filterByCountry test");
			eTest = eReports.createTest("Filter By Country");
			eTest.assignCategory("Sales Commisssion Report");

			boolean condition=false;
			int c=0;
			String[] country = reportdataObj.countries() ;
			Set<String> countrySet = new HashSet<String>(Arrays.asList(country));

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.salesCommissionReport.click();
			waitForElementToLoad(salescommsionreportObj.filterButton);
			autoScrollandClick(salescommsionreportObj.country);
			for(int i=0;i<country.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[normalize-space()='"+country[i]+"'][1]")));;
			}
			autoScrollandClick(salescommsionreportObj.country);
			salescommsionreportObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(salescommsionreportObj.totalRecords);
			System.out.println(salescommsionreportObj.totalRecords.getText());
			String countstring=salescommsionreportObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			expectedBoolArray.add(true);
	
			while(condition==false)
			{
				condition = isElementPresent(salescommsionreportObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						list.add(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[1]")).getText());
					}
				}

				if(!isElementPresent(salescommsionreportObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(salescommsionreportObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(salescommsionreportObj.resetButton);
			autoScrollandClick(salescommsionreportObj.resetButton);
			autoScrollandClick(dashboardObj.nurseries);
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

			log.info("Entered filterByCountry test");
			eTest = eReports.createTest("Filter By Nursery");
			eTest.assignCategory("Sales Commisssion Report");

			boolean condition=false;
			int c=0;
			String[] nursery = reportdataObj.nurseries() ;
			Set<String> nurserySet = new HashSet<String>(Arrays.asList(nursery));

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.salesCommissionReport.click();
			waitForElementToLoad(salescommsionreportObj.filterButton);
			autoScrollandClick(salescommsionreportObj.nursery);
			for(int i=0;i<nursery.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Nursery')]//following::div[normalize-space()='"+nursery[i]+"'][1]")));;
			}
			autoScrollandClick(salescommsionreportObj.nursery);
			salescommsionreportObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(salescommsionreportObj.totalRecords);
			System.out.println(salescommsionreportObj.totalRecords.getText());
			String countstring=salescommsionreportObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			expectedBoolArray.add(true);
	
			while(condition==false)
			{
				condition = isElementPresent(salescommsionreportObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						list.add(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[1]")).getText());
					}
				}

				if(!isElementPresent(salescommsionreportObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(salescommsionreportObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(salescommsionreportObj.resetButton);
			autoScrollandClick(salescommsionreportObj.resetButton);
			autoScrollandClick(dashboardObj.nurseries);
			String[] array = list.toArray(new String[0]);
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

			log.info("Entered filterByCountryNursery test");
			eTest = eReports.createTest("Filter By Nursery,Country");
			eTest.assignCategory("Sales Commisssion Report");

			boolean condition=false;
			int c=0;
			String[] country = reportdataObj.countries() ;
			Set<String> countrySet = new HashSet<String>(Arrays.asList(country));
			String[] nursery = reportdataObj.nurseries() ;
			Set<String> nurserySet = new HashSet<String>(Arrays.asList(nursery));

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.salesCommissionReport.click();
			waitForElementToLoad(salescommsionreportObj.filterButton);
			autoScrollandClick(salescommsionreportObj.country);
			for(int i=0;i<country.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[normalize-space()='"+country[i]+"'][1]")));;
			}
			autoScrollandClick(salescommsionreportObj.country);
			autoScrollandClick(salescommsionreportObj.nursery);
			for(int i=0;i<nursery.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Nursery')]//following::div[normalize-space()='"+nursery[i]+"'][1]")));;
			}
			autoScrollandClick(salescommsionreportObj.nursery);
			salescommsionreportObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(salescommsionreportObj.totalRecords);
			System.out.println(salescommsionreportObj.totalRecords.getText());
			String countstring=salescommsionreportObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			expectedBoolArray.add(true);expectedBoolArray.add(true);
	
			while(condition==false)
			{
				condition = isElementPresent(salescommsionreportObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						list.add(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[1]")).getText());
						list2.add(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[1]")).getText());
					}
				}

				if(!isElementPresent(salescommsionreportObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(salescommsionreportObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(salescommsionreportObj.resetButton);
			autoScrollandClick(salescommsionreportObj.resetButton);
			autoScrollandClick(dashboardObj.nurseries);
			String[] array = list.toArray(new String[0]);
			Set<String> unique1 = new HashSet<String>(Arrays.asList(array));
			String[] array2 = list2.toArray(new String[0]);
			Set<String> unique2 = new HashSet<String>(Arrays.asList(array2));
			actualBoolArray.add(countrySet.containsAll(unique1));  
			actualBoolArray.add(nurserySet.containsAll(unique2));
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
			dashboardObj.salesCommissionReport.click();
			waitForElementToLoad(salescommsionreportObj.filterButton);
			autoScrollandClick(salescommsionreportObj.country);
			for(int i=0;i<country.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[normalize-space()='"+country[i]+"'][1]")));;
			}
			autoScrollandClick(salescommsionreportObj.country);
			autoScrollandClick(salescommsionreportObj.filterButton);
			Thread.sleep(2000);
			waitForElementToLoad(salescommsionreportObj.printButton);
			salescommsionreportObj.printButton.click();
			
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
			waitForElementToLoad(salescommsionreportObj.resetButton);
			autoScrollandClick(salescommsionreportObj.resetButton);
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		Assert.assertEquals(expectedMsg, actualMsg);
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
			dashboardObj.salesCommissionReport.click();
			waitForElementToLoad(salescommsionreportObj.filterButton);
			autoScrollandClick(salescommsionreportObj.country);
			for(int i=0;i<country.length;i++)
			{
				autoScrollandClick(driver.findElement(By.xpath("//label[contains(text(),'Country')]//following::div[normalize-space()='"+country[i]+"'][1]")));;
			}
			autoScrollandClick(salescommsionreportObj.country);
			autoScrollandClick(salescommsionreportObj.filterButton);
			Thread.sleep(2000);
			waitForElementToLoad(salescommsionreportObj.printButton);
			salescommsionreportObj.printButton.click();
			
			actualMsg = driver.switchTo().activeElement().getAttribute("innerText");
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			waitForElementToLoad(salescommsionreportObj.resetButton);
			autoScrollandClick(salescommsionreportObj.resetButton);
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
