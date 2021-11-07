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
import com.bounceadmin.objectrepository.TransferListObject;


public class TransferList extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	TransferListObject transferlistObj;
	String[] testData;
	
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			transferlistObj = new TransferListObject(driver);
			
			loginObj.logIn(userEmail,userPassword);
			loginObj.selectRole();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	@Test(priority=1)
	public void filterByNurseryName() //filter by nursery name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByNurseryName test");
			eTest = eReports.createTest("Filter By NurseryName");
			eTest.assignCategory("Transfers");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();
			waitForElementToLoad(transferlistObj.nurseryName);
			transferlistObj.nurseryName.sendKeys("Payment Nursery");
			transferlistObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(transferlistObj.totalRecords);
			System.out.println(transferlistObj.totalRecords.getText());
			String countstring=transferlistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(transferlistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[4]//a[contains(text(),'Payment Nursery')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(transferlistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(transferlistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(transferlistObj.resetButton);
			autoScrollandClick(transferlistObj.resetButton);
			autoScrollandClick(dashboardObj.transfers);
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
	public void filterByDate()
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();
			
			log.info("Entered filterByDate test");
			eTest = eReports.createTest("filterByDate");
			eTest.assignCategory("Transfers");
			boolean condition=false;
			int c=0;
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();
			waitForElementToLoad(transferlistObj.fromDate);
			transferlistObj.fromDate.sendKeys("15/09/2020");
			waitForElementToLoad(transferlistObj.toDate);
			Thread.sleep(500);
			transferlistObj.toDate.sendKeys("15/09/2020");
			transferlistObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(transferlistObj.totalRecords);
			System.out.println(transferlistObj.totalRecords.getText());
			String countstring=transferlistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedArraylist.add("15/09/2020");
			}
			while(condition==false)
			{
				condition = isElementPresent(transferlistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						String value= driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]")).getText();
						actualArraylist.add(value);
					}
				}
				
				if(!isElementPresent(transferlistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(transferlistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(transferlistObj.resetButton);
			autoScrollandClick(transferlistObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
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
	public void filterByStatus()
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByStatus test");
			eTest = eReports.createTest("filterByStatus");
			eTest.assignCategory("Transfers");
			boolean condition=false;
			int c=0;
			String stat = "To Do";
			
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();
			waitForElementToLoad(transferlistObj.nurseryName);
			transferlistObj.status.sendKeys(stat);
			transferlistObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(transferlistObj.totalRecords);
			System.out.println(transferlistObj.totalRecords.getText());
			String countstring=transferlistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(transferlistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(transferlistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(transferlistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(transferlistObj.resetButton);
			autoScrollandClick(transferlistObj.resetButton);
			autoScrollandClick(dashboardObj.transfers);
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
	public void verifyPrintClickPrint() //verify print page is loaded when print button clicked and click print
	{
		try
		{
			log.info("Entered verifyPrintClickPrint test");
			eTest = eReports.createTest("verifyPrintClickPrint");
			eTest.assignCategory("Transfers");
			
			expectedMsg = "PRINT";
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();
			
			waitForElementToLoad(transferlistObj.printButton);
			transferlistObj.printButton.click();
			
			actualMsg = driver.switchTo().activeElement().getAttribute("innerText");
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		Assert.assertEquals(expectedMsg, actualMsg);
	}
	
	@Test(priority=5)
	public void verifyPrintClickCancel() //verify print page is loaded when print button clicked and click cancel
	{
		try
		{
			log.info("Entered verifyPrintClickCancel test");
			eTest = eReports.createTest("verifyPrintClickCancel");
			eTest.assignCategory("Transfers");
			
			expectedMsg = "PRINT";
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();
			
			waitForElementToLoad(transferlistObj.printButton);
			transferlistObj.printButton.click();
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
	
	@Test(priority=6)
	public void verifySortForTransferReqId()
	{
		try
		{
			
			log.info("Entered verifySortForTransferReqId test");
			eTest = eReports.createTest("verifySortForTransferReqId");
			eTest.assignCategory("Transfers");
			
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();

			expectedMsg = verifySortButton(transferlistObj.transferReqIdSortButton, transferlistObj.sortedTransferReqId);
			actualMsg = transferlistObj.sortedTransferReqId.getText();
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
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
	
	@Test(priority=7)
	public void verifySortForBankName()
	{
		try
		{
			
			log.info("Entered verifySortForBankName test");
			eTest = eReports.createTest("verifySortForBankName");
			eTest.assignCategory("Transfers");
			
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();

			expectedMsg = verifySortButton(transferlistObj.BankSortButton, transferlistObj.sortedBank);
			actualMsg = transferlistObj.sortedBank.getText();
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
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
	
	@Test(priority=8)
	public void verifySortForBounceCommision()
	{
		try
		{
			
			log.info("Entered verifySortForBounceCommision test");
			eTest = eReports.createTest("verifySortForBounceCommision");
			eTest.assignCategory("Transfers");
			
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", transferlistObj.bounceCommisionSortButton);
			expectedMsg = verifySortButton(transferlistObj.bounceCommisionSortButton, transferlistObj.sortedBounceCommision);
			actualMsg = transferlistObj.sortedBounceCommision.getText();
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
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
	
	@Test(priority=9)
	public void verifySortForDeduction()
	{
		try
		{
			
			log.info("Entered verifySortForDeduction test");
			eTest = eReports.createTest("verifySortForDeduction");
			eTest.assignCategory("Transfers");
			
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", transferlistObj.deductionSortButton);
			expectedMsg = verifySortButton(transferlistObj.deductionSortButton, transferlistObj.sortedDeduction);
			actualMsg = transferlistObj.sortedDeduction.getText();
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
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
	
	@Test(priority=10	
			)
	public void verifySortForAddition()
	{
		try
		{
			
			log.info("Entered verifySortForAddition test");
			eTest = eReports.createTest("verifySortForAddition");
			eTest.assignCategory("Transfers");
			
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
			dashboardObj.transferList.click();

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", transferlistObj.additionSortButton);
			expectedMsg = verifySortButton(transferlistObj.additionSortButton, transferlistObj.sortedAddition);
			actualMsg = transferlistObj.sortedAddition.getText();
			waitIfElementClickIsIntercepted(dashboardObj.transfers, "click", "");
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
