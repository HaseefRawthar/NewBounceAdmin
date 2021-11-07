package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.ActiveStudentsObject;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.testdata.ReportsData;
import com.bounceadmin.testdata.TestDataImport;

public class ActiveStudents extends SetUp{

	LogInObject loginObj;
	DashboardObject dashboardObj;
	ActiveStudentsObject activestudentsObj;
	TestDataImport tdImport;
	ReportsData reportdataObj;
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			activestudentsObj = new ActiveStudentsObject(driver);
			tdImport = new TestDataImport();
			reportdataObj = new ReportsData();

			tdImport.readSheet("ActiveStudents");
			
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

			log.info("Entered filterByCountry test");
			eTest = eReports.createTest("Filter By Country");
			eTest.assignCategory("Active Students");

			boolean condition=false;
			int c=0;
			String country = reportdataObj.activeStudentsFilterData()[0] ;

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			waitForElementToLoad(activestudentsObj.country);
			activestudentsObj.country.sendKeys(country);
			activestudentsObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.nurseries);
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
	public void filterByNurseryName() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryName test");
			eTest = eReports.createTest("Filter By Nursery Name");
			eTest.assignCategory("Active Students");

			boolean condition=false;
			int c=0;
			String nursery = reportdataObj.activeStudentsFilterData()[1];

			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			waitForElementToLoad(activestudentsObj.nurseryName);
			activestudentsObj.nurseryName.sendKeys(nursery);
			activestudentsObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+nursery+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.nurseries);
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
	public void filterByCountryNursery() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			log.info("Entered filterByCountryNursery test");
			eTest = eReports.createTest("Filter By Country,Nursery");
			eTest.assignCategory("Active Students");
			
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			
			String country = reportdataObj.activeStudentsFilterData()[0];
			String nursery = reportdataObj.activeStudentsFilterData()[1];

			waitForElementToLoad(activestudentsObj.country);
			activestudentsObj.country.sendKeys(country);
			activestudentsObj.nurseryName.sendKeys(nursery);
			activestudentsObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
					
				
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+nursery+"')]")));
						actualBoolArray.add(value1 | value2);
					}
				}
				
				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
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
	public void filterByCountryNurseryFromDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			log.info("Entered filterByDate test");
			eTest = eReports.createTest("Filter By Country,Nursery,From Date");
			eTest.assignCategory("Active Students");
			
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			
			String country = reportdataObj.activeStudentsFilterData()[0];
			String fromDate = reportdataObj.activeStudentsFilterData()[2];
			String nursery = reportdataObj.activeStudentsFilterData()[1];

			waitForElementToLoad(activestudentsObj.country);
			activestudentsObj.country.sendKeys(country);
			activestudentsObj.nurseryName.sendKeys(nursery);
			activestudentsObj.fromDate.sendKeys(fromDate);
			activestudentsObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
					
				
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+nursery+"')]")));
						String date =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]/div[1]/span[1]")).getText();
						boolean value3 = checkDateIsAfter(date, fromDate);
						actualBoolArray.add(value1 | value2 | value3);
					}
				}
				
				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
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
	public void filterByCountryNurseryToDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			log.info("Entered filterByToDate test");
			eTest = eReports.createTest("Filter ByCountry,Nursery,To Date");
			eTest.assignCategory("Active Students");
			
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			
			String country = reportdataObj.activeStudentsFilterData()[0];
			String toDate = reportdataObj.activeStudentsFilterData()[3];
			String nursery = reportdataObj.activeStudentsFilterData()[1];

			waitForElementToLoad(activestudentsObj.country);
			activestudentsObj.country.sendKeys(country);
			activestudentsObj.nurseryName.sendKeys(nursery);
			activestudentsObj.toDate.sendKeys(toDate);
			activestudentsObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
					
				
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+nursery+"')]")));
						String date =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]/div[1]/span[1]")).getText();
						boolean value3 = checkDateIsBefore(date, toDate);
						actualBoolArray.add(value1 | value2 | value3);
					}
				}
				
				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
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
	
	@Test(priority=6)
	public void filterByCountryFromAndToDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			log.info("Entered filterByCountryFromAndToDate test");
			eTest = eReports.createTest("Filter By Country,From And To Date");
			eTest.assignCategory("Active Students");
			
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			
			String country = reportdataObj.activeStudentsFilterData()[0];
			String fromDate = reportdataObj.activeStudentsFilterData()[2];
			String toDate = reportdataObj.activeStudentsFilterData()[3];

			waitForElementToLoad(activestudentsObj.country);
			activestudentsObj.country.sendKeys(country);
			activestudentsObj.toDate.sendKeys(toDate);
			Thread.sleep(1000);
			activestudentsObj.fromDate.sendKeys(fromDate);
			activestudentsObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
					
				
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+country+"')]")));
						String date =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]/div[1]/span[1]")).getText();
						boolean value2 = checkDateIsBefore(date, toDate);
						boolean value3 = checkDateIsAfter(date, fromDate);
						System.out.println(date);
						actualBoolArray.add(value1 | value2 | value3);
					}
				}
				
				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
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
	
	@Test(priority=7)
	public void filterByNurseryFromAndToDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			log.info("Entered filterByCountryNurseryFromAndToDate test");
			eTest = eReports.createTest("Filter By Nursery,From And To Date");
			eTest.assignCategory("Active Students");
			
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			
			String fromDate = reportdataObj.activeStudentsFilterData()[2];
			String toDate = reportdataObj.activeStudentsFilterData()[3];
			String nursery = reportdataObj.activeStudentsFilterData()[1];

			waitForElementToLoad(activestudentsObj.country);
			activestudentsObj.nurseryName.sendKeys(nursery);
			activestudentsObj.toDate.sendKeys(toDate);
			Thread.sleep(1000);
			activestudentsObj.fromDate.sendKeys(fromDate);
			activestudentsObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
					
				
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+nursery+"')]")));
						String date =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]/div[1]/span[1]")).getText();
						boolean value2 = checkDateIsBefore(date, toDate);
						boolean value3 = checkDateIsAfter(date, fromDate);
						System.out.println(date);
						actualBoolArray.add(value1 | value2 | value3);
					}
				}
				
				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
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
	
	@Test(priority=8)
	public void filterByCountryNurserySameDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			log.info("Entered filterByCountryNurseryFromAndToDate test");
			eTest = eReports.createTest("Filter By Country,Nursery,From And To Date");
			eTest.assignCategory("Active Students");
			
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			
			String country = reportdataObj.activeStudentsFilterData()[0];
			String date = reportdataObj.activeStudentsFilterData()[2];
			String nursery = reportdataObj.activeStudentsFilterData()[1];

			waitForElementToLoad(activestudentsObj.country);
			activestudentsObj.country.sendKeys(country);
			activestudentsObj.nurseryName.sendKeys(nursery);
			activestudentsObj.toDate.sendKeys(date);
			Thread.sleep(1000);
			activestudentsObj.fromDate.sendKeys(date);
			activestudentsObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
					
				
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+nursery+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]/div[1]/span[contains(text(),'"+date+"')]")));
						actualBoolArray.add(value1 | value2 | value3 );
					}
				}
				
				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
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
	
	@Test(priority=9)
	public void filterByCountryNurseryFromAndToDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			log.info("Entered filterByCountryNurseryFromAndToDate test");
			eTest = eReports.createTest("Filter By Country,Nursery,From And To Date");
			eTest.assignCategory("Active Students");
			
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.reports, "click", "");
			dashboardObj.activeStudents.click();
			
			String country = reportdataObj.activeStudentsFilterData()[0];
			String fromDate = reportdataObj.activeStudentsFilterData()[2];
			String toDate = reportdataObj.activeStudentsFilterData()[3];
			String nursery = reportdataObj.activeStudentsFilterData()[1];

			waitForElementToLoad(activestudentsObj.country);
			activestudentsObj.country.sendKeys(country);
			activestudentsObj.nurseryName.sendKeys(nursery);
			activestudentsObj.toDate.sendKeys(toDate);
			activestudentsObj.fromDate.sendKeys(fromDate);
			activestudentsObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(activestudentsObj.totalRecords);
			System.out.println(activestudentsObj.totalRecords.getText());
			String countstring=activestudentsObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(activestudentsObj.lastpagecheck);
					
				
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+nursery+"')]")));
						String date =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]/div[1]/span[1]")).getText();
						boolean value3 = checkDateIsBefore(date, toDate);
						boolean value4 = checkDateIsAfter(date, fromDate);
						System.out.println(date);
						actualBoolArray.add(value1 | value2 | value3 | value4);
					}
				}
				
				if(!isElementPresent(activestudentsObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(activestudentsObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(activestudentsObj.resetButton);
			autoScrollandClick(activestudentsObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
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
	
	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}
}
