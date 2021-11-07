package com.bounceadmin.testscript;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;

import com.bounceadmin.objectrepository.DashboardObject;

import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.PaymentTransactionListObject;
import com.bounceadmin.testdata.PaymentTransactionData;
import com.bounceadmin.testdata.TestDataImport;


public class PaymentTransactionsList extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	PaymentTransactionListObject paytransactionObj;
	PaymentTransactionData paydataObj;
	TestDataImport tdImport;
	String[] testData;
	
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
		
			paytransactionObj = new PaymentTransactionListObject(driver);
			paydataObj = new PaymentTransactionData();
			tdImport = new TestDataImport();
			
			tdImport.readSheet("PaymentList");
			
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
	public void filterByDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByDate test");
			eTest = eReports.createTest("Filter By Date");
			eTest.assignCategory("Payment Transaction");
			
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			
			String date = paydataObj.paymentFilterData()[0];
			waitForElementToLoad(paytransactionObj.fromDate);
			paytransactionObj.fromDate.sendKeys(date);
			Thread.sleep(500);
			waitForElementToLoad(paytransactionObj.toDate);
			paytransactionObj.toDate.sendKeys(date);
			paytransactionObj.filterButton.click();
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]/div[1]/span[contains(text(),'"+date+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	
	@Test(priority=2)
	public void filterByFromDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByDate test");
			eTest = eReports.createTest("Filter By From Date");
			eTest.assignCategory("Payment Transaction");
			
			boolean condition=false;
			int c=0;
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			
			String fromDate = paydataObj.paymentFilterData()[0];
			waitForElementToLoad(paytransactionObj.fromDate);
			paytransactionObj.fromDate.sendKeys(fromDate);
			paytransactionObj.filterButton.click();
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
					
				
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						String date =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]/div[1]/span[1]")).getText();
						boolean value = checkDateIsAfter(date, fromDate);
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	
	@Test(priority=3)
	public void filterByToDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByDate test");
			eTest = eReports.createTest("Filter By To Date");
			eTest.assignCategory("Payment Transaction");
			
			boolean condition=false;
			int c=0;
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			
			String toDate = paydataObj.paymentFilterData()[1];
			waitForElementToLoad(paytransactionObj.fromDate);
			paytransactionObj.toDate.sendKeys(toDate);
			paytransactionObj.filterButton.click();
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						String date =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]/div[1]/span[1]")).getText();
						boolean value = checkDateIsBefore(date, toDate);
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	public void filterByFromDateAndToDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByFromDateAndToDate test");
			eTest = eReports.createTest("Filter By From Date and To Date");
			eTest.assignCategory("Payment Transaction");
			
			boolean condition=false;
			int c=0;
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			
			String toDate = paydataObj.paymentFilterData()[1];
			String fromDate = paydataObj.paymentFilterData()[0];
			waitForElementToLoad(paytransactionObj.fromDate);
			paytransactionObj.fromDate.sendKeys(fromDate);
			Thread.sleep(500);
			paytransactionObj.toDate.sendKeys(toDate);
			paytransactionObj.filterButton.click();
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						String date =driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]/div[1]/span")).getText();
						boolean value1 = checkDateIsBefore(date, toDate);
						boolean value2 = checkDateIsAfter(date, fromDate);
						System.out.println(date);
						actualBoolArray.add(value1 | value2);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	public void filterByPayMode() //filter PaymentTransactionsList by payment mode
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPayMode test");
			eTest = eReports.createTest("Filter By PayMode");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			
			String paymode = paydataObj.paymentFilterData()[2];
			waitForElementToLoad(paytransactionObj.paymentMode);
			paytransactionObj.paymentMode.sendKeys(paymode);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[12]/div[1]/span[contains(text(),'"+paymode+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
					Thread.sleep(1000);
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	public void filterByPaymentGateway() //filter PaymentTransactionsList by paymentGateway
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPaymentGateway test");
			eTest = eReports.createTest("Filter By PaymentGateway");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;

			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			
			String payGateway = paydataObj.paymentFilterData()[3];
			waitForElementToLoad(paytransactionObj.paymentGateway);
			paytransactionObj.paymentGateway.sendKeys(payGateway);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[10]//span[contains(text(),'"+payGateway+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	public void filterByPaymentMethod() //filter PaymentTransactionsList by payment method
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPaymentMethod test");
			eTest = eReports.createTest("Filter By PaymentMethod");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			
			String payMethod = paydataObj.paymentFilterData()[4];
			waitForElementToLoad(paytransactionObj.paymentMethod);
			paytransactionObj.paymentMethod.sendKeys(payMethod);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[11]//span[contains(text(),'"+payMethod+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	public void filterByNurseryName() //filter PaymentTransactionsList by nursery name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByNurseryName test");
			eTest = eReports.createTest("Filter By NurseryName");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			String nursery = paydataObj.paymentFilterData()[5];
			waitForElementToLoad(paytransactionObj.nurseryName);
			paytransactionObj.nurseryName.sendKeys(nursery);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//a[contains(text(),'"+nursery+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	public void filterByTransactionStatus() //filter PaymentTransactionsList by transaction status
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByTransactionStatus test");
			eTest = eReports.createTest("Filter By Transaction Status");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			
			String transactionStat = paydataObj.paymentFilterData()[6];
			waitForElementToLoad(paytransactionObj.transactionStatus);
			paytransactionObj.transactionStatus.sendKeys(transactionStat);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[8]//span[contains(text(),'"+transactionStat+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	
		
	@Test(priority=10) 
	public void filterByDepositeStatus() //filter PaymentTransactionsList by transfer status
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByDepositeStatus test");
			eTest = eReports.createTest("Filter By Deposite Status");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			
			String depositeStat = paydataObj.paymentFilterData()[8];
			waitForElementToLoad(paytransactionObj.transferStatus);
			paytransactionObj.transferStatus.sendKeys(depositeStat);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[9]//span[contains(text(),'"+depositeStat+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	
	@Test(priority=11) 
	public void filterByPaymentGatewayRefId() //filter PaymentTransactionsList by payment gateway reference id
	{
		try
		{
			
			log.info("Entered filterByPaymentGatewayRefId test");
			eTest = eReports.createTest("Filter By Payment Gateway RefId");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
            
			String refId = paydataObj.paymentFilterData()[9];
			waitForElementToLoad(paytransactionObj.paymentGatewayRefId);
			expectedMsg = refId;
			paytransactionObj.paymentGatewayRefId.sendKeys(refId);
			paytransactionObj.filterButton.click();
			Thread.sleep(2500);
			
			waitForElementToLoad(paytransactionObj.getpatmentGatewayRefId);
			actualMsg = paytransactionObj.getpatmentGatewayRefId.getText();
			
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test(priority=12)
	public void filterByPayModeGatewayMethod() //filter PaymentTransactionsList by payment mode
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPayModeGatewayMethod test");
			eTest = eReports.createTest("Filter By PayMode,Gateway,Pay Method");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			
			String payGateway = paydataObj.paymentFilterData()[3];
			String paymode = paydataObj.paymentFilterData()[2];
			String payMethod = paydataObj.paymentFilterData()[4];
			waitForElementToLoad(paytransactionObj.paymentMode);
			paytransactionObj.paymentMode.sendKeys(paymode);
			paytransactionObj.paymentGateway.sendKeys(payGateway);
			paytransactionObj.paymentMethod.sendKeys(payMethod);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[12]/div[1]/span[contains(text(),'"+paymode+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[10]//span[contains(text(),'"+payGateway+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[11]//span[contains(text(),'"+payMethod+"')]")));
						actualBoolArray.add(value1 | value2 | value3);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	
	@Test(priority=13)
	public void filterByPayModeGatewayMethodTransactionStatus() //filter PaymentTransactionsList by payment mode
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPayModeGatewayMethodTransactionStatus test");
			eTest = eReports.createTest("Filter By PayMode,Gateway,Pay Method,Transaction status");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			
			String transactionStat = paydataObj.paymentFilterData()[6];
			String payGateway = paydataObj.paymentFilterData()[3];
			String paymode = paydataObj.paymentFilterData()[2];
			String payMethod = paydataObj.paymentFilterData()[4];
			waitForElementToLoad(paytransactionObj.paymentMode);
			paytransactionObj.paymentMode.sendKeys(paymode);
			paytransactionObj.paymentGateway.sendKeys(payGateway);
			paytransactionObj.paymentMethod.sendKeys(payMethod);
			paytransactionObj.transactionStatus.sendKeys(transactionStat);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[12]/div[1]/span[contains(text(),'"+paymode+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[10]//span[contains(text(),'"+payGateway+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[11]//span[contains(text(),'"+payMethod+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[8]//span[contains(text(),'"+transactionStat+"')]")));
						actualBoolArray.add(value1 | value2 | value3 | value4);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	
	@Test(priority=14)
	public void filterByPayModeGatewayMethodTransactionStatDepoStat() //filter PaymentTransactionsList by payment mode
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPayModeGatewayMethodTransactionStatDepoStat test");
			eTest = eReports.createTest("Filter By PayMode,Gateway,Pay Method,Transaction,Deposite status");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			
			String depositeStat = paydataObj.paymentFilterData()[8];
			String transactionStat = paydataObj.paymentFilterData()[6];
			String payGateway = paydataObj.paymentFilterData()[3];
			String paymode = paydataObj.paymentFilterData()[2];
			String payMethod = paydataObj.paymentFilterData()[4];
			waitForElementToLoad(paytransactionObj.paymentMode);
			paytransactionObj.paymentMode.sendKeys(paymode);
			paytransactionObj.paymentGateway.sendKeys(payGateway);
			paytransactionObj.paymentMethod.sendKeys(payMethod);
			paytransactionObj.transactionStatus.sendKeys(transactionStat);
			paytransactionObj.transferStatus.sendKeys(depositeStat);
			paytransactionObj.filterButton.click();
			
			Thread.sleep(2500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[12]/div[1]/span[contains(text(),'"+paymode+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[10]//span[contains(text(),'"+payGateway+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[11]//span[contains(text(),'"+payMethod+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[8]//span[contains(text(),'"+transactionStat+"')]")));
						boolean value5 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[9]//span[contains(text(),'"+depositeStat+"')]")));
						actualBoolArray.add(value1 | value2 | value3 | value4 | value5);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
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
	
	@Test(priority=15) 
	public void verifyPrintClickPrint() //verify print page is loaded when print button clicked and click print
	{
		try
		{
			log.info("Entered verifyPrintClickPrint test");
			eTest = eReports.createTest("Verify Print - ClickPrint");
			eTest.assignCategory("Payment Transaction");
			
			expectedMsg = "PRINT";
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			
			waitForElementToLoad(paytransactionObj.printButton);
			paytransactionObj.printButton.click();
			
			actualMsg = driver.switchTo().activeElement().getAttribute("innerText");
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			for(int i=0;i<4;i++)
			{
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1500);
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		Assert.assertEquals(expectedMsg, actualMsg);
	}
	
	@Test(priority=16)
	public void verifyPrintClickCancel() //verify print page is loaded when print button clicked and click cancel
	{
		try
		{
			log.info("Entered verifyPrintClickCancel test");
			eTest = eReports.createTest("Verify Print - ClickCancel");
			eTest.assignCategory("Payment Transaction");
			
			expectedMsg = "PRINT";
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");
			
			waitForElementToLoad(paytransactionObj.printButton);
			paytransactionObj.printButton.click();
			actualMsg = driver.switchTo().activeElement().getAttribute("innerText");
			
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
	}
	
	@Test(priority=17)
	public void verifySortForCustomerRefId()
	{
		try
		{
			
			log.info("Entered verifySortForCustomerRefId test");
			eTest = eReports.createTest("Verify Sort For CustomerRefId");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.customerRefIdSortButton, paytransactionObj.sortedCustomerRefId);
			actualMsg = paytransactionObj.sortedCustomerRefId.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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
	
	@Test(priority=18)
	public void verifySortForBounceId()
	{
		try
		{
			
			log.info("Entered verifySortForBounceId test");
			eTest = eReports.createTest("Verify Sort For BounceId");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.bouncePayIdSortButton, paytransactionObj.sortedBouncePayId);
			actualMsg = paytransactionObj.sortedBouncePayId.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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
	
	@Test(priority=19)
	public void verifySortForNurseryName()
	{
		try
		{
			
			log.info("Entered verifySortForNurseryName test");
			eTest = eReports.createTest("Verify Sort For NurseryName");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.nurseryNameSortButton, paytransactionObj.sortedNurseryName);
			actualMsg = paytransactionObj.sortedNurseryName.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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
	
	@Test(priority=20)
	public void verifySortForPayDate()
	{
		try
		{
			
			log.info("Entered verifySortForPayDate test");
			eTest = eReports.createTest("Verify Sort For PayDate");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.payDateSortButton, paytransactionObj.sortedPayDate);
			actualMsg = paytransactionObj.sortedPayDate.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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
	
	@Test(priority=21)
	public void verifySortForAmount()
	{
		try
		{
			
			log.info("Entered verifySortForAmount test");
			eTest = eReports.createTest("Verify Sort For Amount");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.AmountSortButton, paytransactionObj.sortedAmount);
			actualMsg = paytransactionObj.sortedAmount.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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
	
	@Test(priority=22)
	public void verifySortForPayGateway()
	{
		try
		{
			
			log.info("Entered verifySortForPayGateway test");
			eTest = eReports.createTest("Verify Sort For PayGateway");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paytransactionObj.paygatewaySortButton);
			Thread.sleep(2000);
			expectedMsg = verifySortButton(paytransactionObj.paygatewaySortButton, paytransactionObj.sortedGateway);
			actualMsg = paytransactionObj.sortedGateway.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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
	
	@Test(priority=23)
	public void verifySortForPayMethod()
	{
		try
		{
			
			log.info("Entered verifySortForPayMethod test");
			eTest = eReports.createTest("Verify Sort For Payment Method");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paytransactionObj.payMethodSortButton);
			Thread.sleep(2000);
			expectedMsg = verifySortButton(paytransactionObj.payMethodSortButton, paytransactionObj.sortedMethod);
			actualMsg = paytransactionObj.sortedMethod.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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

	@Test(priority=24)
	public void verifySortForPayMode()
	{
		try
		{
			
			log.info("Entered verifySortForPayMode test");
			eTest = eReports.createTest("Verify Sort For Payment Mode");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paytransactionObj.payModeSortButton);
			Thread.sleep(2000);
			expectedMsg = verifySortButton(paytransactionObj.payModeSortButton, paytransactionObj.sortedMode);
			actualMsg = paytransactionObj.sortedMode.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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

	@Test(priority=25)
	public void verifySortForGatewayRefId()
	{
		try
		{
			
			log.info("Entered verifySortForGatewayRefId test");
			eTest = eReports.createTest("Verify Sort For GatewayRefId");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paytransactionObj.payGatewayRefSortButton);
			Thread.sleep(2000);
			expectedMsg = verifySortButton(paytransactionObj.payGatewayRefSortButton, paytransactionObj.sortedGatewayRef);
			actualMsg = paytransactionObj.sortedGatewayRef.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
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
