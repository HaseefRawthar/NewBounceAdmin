package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.AddNurseryObject;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.ListNurseryObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.ViewNurseryObject;
import com.bounceadmin.testdata.AddNurseryData;
import com.bounceadmin.testdata.TestDataImport;

public class ListNursery extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	AddNurseryObject addnurseryObj;
	AddNurseryData addnurserydataObj;
	TestDataImport tdImport;
	ListNurseryObject listnurseryObj;
	ViewNurseryObject viewnurseryObj;

	String[] addOwnerData;
	String[] testData;
	String[] edittestData;
	boolean condition=false;

	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			addnurseryObj = new AddNurseryObject(driver);
			tdImport = new TestDataImport();
			addnurserydataObj = new AddNurseryData();
			listnurseryObj = new ListNurseryObject(driver);
			viewnurseryObj = new ViewNurseryObject(driver);

			tdImport.readSheet("AddNursery");

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

	@Test(priority=2)
	public void filterByNurseryName() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryName test");
			eTest = eReports.createTest("Filter By NurseryName");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	public void filterByStatus() //filter all nursery with status
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			int c=0;
			log.info("Entered filterByActiveStatus test");
			eTest = eReports.createTest("Filter By Status");
			eTest.assignCategory("List Nursery");

			dashboardObj.clickListNurseries();
			String stat = addnurserydataObj.nurseryFilterData()[1];
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.filterButton.click();
			Thread.sleep(2000);

			waitForElementToLoad(listnurseryObj.totalRecords);
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
			autoScrollandClick(dashboardObj.nurseries);

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualBoolArray);
		System.out.println(expectedBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}

	@Test(priority=4)
	public void filterByCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByCountry test");
			eTest = eReports.createTest("Filter By Country");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String country = addnurserydataObj.nurseryFilterData()[3];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=5)
	public void filterByEmail() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByEmail test");
			eTest = eReports.createTest("Filter By Email");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			System.out.println(email);

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=6)
	public void filterByPhoneNumber() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByPhoneNumber test");
			eTest = eReports.createTest("Filter By PhoneNumber");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0; 
			String phone = addnurserydataObj.nurseryFilterData()[5];


			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value = (driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=7)
	public void filterByCountryCode() //filter by phone code
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered filterByPhoneCode test");
			eTest = eReports.createTest("Filter By CountryCode");
			eTest.assignCategory("List Nursery");
			boolean condition=false;
			int c=0;
			String code = addnurserydataObj.nurseryFilterData()[4];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.selectCountryCode);
			listnurseryObj.selectCountryCode.sendKeys(code);
			autoScrollandClick(listnurseryObj.filterButton);
			autoScrollandClick(listnurseryObj.filterButton);

			Thread.sleep(2000);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedArraylist.add(code.replaceAll("[^\\d+]", "").trim());
			}

			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						String value =driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0];
						actualArraylist.add(value);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
			autoScrollandClick(dashboardObj.nurseries);
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

	@Test(priority=8)
	public void filterByAccess() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByAccess test");
			eTest = eReports.createTest("Filter By Access");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String access = addnurserydataObj.nurseryFilterData()[6]; 


			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.access);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=9)
	public void filterByNurseryNameAndStatus() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameAndStatus test");
			eTest = eReports.createTest("Filter By NurseryName and Status");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=10)
	public void filterByNurseryNameAndEmail() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameAndEmail test");
			eTest = eReports.createTest("Filter By NurseryName and Email");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String email = addnurserydataObj.nurseryFilterData()[2]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=11)
	public void filterByNurseryNameAndCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameAndCountry test");
			eTest = eReports.createTest("Filter By NurseryName and Country");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String country = addnurserydataObj.nurseryFilterData()[3]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=12)
	public void filterByNurseryNameAndCountryCode() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameAndCountryCode test");
			eTest = eReports.createTest("Filter By NurseryName and CountryCode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String code = addnurserydataObj.nurseryFilterData()[4].replaceAll("[^\\d+]", "").trim();

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0]).equals(code)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=13)
	public void filterByNurseryNameAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameAndPhone test");
			eTest = eReports.createTest("Filter By NurseryName and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String phone = addnurserydataObj.nurseryFilterData()[5]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=14)
	public void filterByNurseryNameAndAccess() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameAndAccess test");
			eTest = eReports.createTest("Filter By NurseryName and Access");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String access = addnurserydataObj.nurseryFilterData()[6]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=15)
	public void filterByStatusAndEmail() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatusAndEmail test");
			eTest = eReports.createTest("Filter By Status and Email");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String email = addnurserydataObj.nurseryFilterData()[2]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=16)
	public void filterByStatusAndCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatusAndCountry test");
			eTest = eReports.createTest("Filter By Status and Country");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String country = addnurserydataObj.nurseryFilterData()[3]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=17)
	public void filterByStatusAndCountryCode() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatusAndCountryCode test");
			eTest = eReports.createTest("Filter By Status and CountryCode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String code = addnurserydataObj.nurseryFilterData()[4].replaceAll("[^\\d+]", "").trim();

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0]).equals(code)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=18)
	public void filterByStatusAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatusAndPhone test");
			eTest = eReports.createTest("Filter By Status and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String phone = addnurserydataObj.nurseryFilterData()[5];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=19)
	public void filterByStatusAndAccess() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatusAndAccess test");
			eTest = eReports.createTest("Filter By Status and Access");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String access = addnurserydataObj.nurseryFilterData()[6];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=20)
	public void filterByEmailAndCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByEmailAndCountry test");
			eTest = eReports.createTest("Filter By Email and Country");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			String country = addnurserydataObj.nurseryFilterData()[3];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryEmail);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=21)
	public void filterByEmailAndCountryCode() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByEmailAndCountryCode test");
			eTest = eReports.createTest("Filter By Email and Countrycode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String code = addnurserydataObj.nurseryFilterData()[4].replaceAll("[^\\d+]", "").trim();

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryEmail);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0]).equals(code)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=22)
	public void filterByEmailAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByEmailAndPhone test");
			eTest = eReports.createTest("Filter By Email and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			String phone = addnurserydataObj.nurseryFilterData()[5];


			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryEmail);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=23)
	public void filterByEmailAndAccess() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByEmailAndAccess test");
			eTest = eReports.createTest("Filter By Email and Access");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			String access = addnurserydataObj.nurseryFilterData()[6];


			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryEmail);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=24)
	public void filterByCountryAndCountryCode() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByCountryAndCountryCode test");
			eTest = eReports.createTest("Filter By Country and Countrycode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String country = addnurserydataObj.nurseryFilterData()[3]; 
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String code = addnurserydataObj.nurseryFilterData()[4].replaceAll("[^\\d+]", "").trim();

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.selectCountry);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0]).equals(code)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=25)
	public void filterByCountryAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByCountryAndPhone test");
			eTest = eReports.createTest("Filter By Country and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String country = addnurserydataObj.nurseryFilterData()[3]; 
			String phone = addnurserydataObj.nurseryFilterData()[5];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.selectCountry);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=26)
	public void filterByCountryAndAccess() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByCountryAndAccess test");
			eTest = eReports.createTest("Filter By Country and Access");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String country = addnurserydataObj.nurseryFilterData()[3]; 
			String access = addnurserydataObj.nurseryFilterData()[6];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.selectCountry);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=27)
	public void filterByCountryCodeAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByCountryCodeAndPhone test");
			eTest = eReports.createTest("Filter By Countrycode And Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String countryCode = addnurserydataObj.nurseryFilterData()[4]; 
			String phone = addnurserydataObj.nurseryFilterData()[5];
			String ph = countryCode.replaceAll("[^\\d+]", "")+" "+phone;

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+ph+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=28)
	public void filterByCountryCodeAndAccess() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByCountryCodeAndAccess test");
			eTest = eReports.createTest("Filter By Access and Countrycode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String access = addnurserydataObj.nurseryFilterData()[6]; 
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String code = addnurserydataObj.nurseryFilterData()[4].replaceAll("[^\\d+]", "").trim();

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.selectCountryCode);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0]).equals(code)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=29)
	public void filterByPhoneAndAccess() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByPhoneAndAccess test");
			eTest = eReports.createTest("Filter By Phone and Access");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String access = addnurserydataObj.nurseryFilterData()[6]; 
			String phone = addnurserydataObj.nurseryFilterData()[5];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.selectCountryCode);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=30)
	public void filterByNurseryNameStatusAndEmail() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameStatusAndEmail test");
			eTest = eReports.createTest("Filter By NurseryName,Status and Email");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String email = addnurserydataObj.nurseryFilterData()[2]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=31)
	public void filterByNurseryNameStatusAndCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameStatusAndCountry test");
			eTest = eReports.createTest("Filter By NurseryName,Status and Country");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String country = addnurserydataObj.nurseryFilterData()[3]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=32)
	public void filterByNurseryNameStatusAndCountryCode() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameStatusAndCountryCode test");
			eTest = eReports.createTest("Filter By NurseryName,Status and Countrycode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String countryCode = addnurserydataObj.nurseryFilterData()[4]; 
			String code = addnurserydataObj.nurseryFilterData()[4].replaceAll("[^\\d+]", "").trim();

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0]).equals(code)?true:false;
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=33)
	public void filterByNurseryNameStatusAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameStatusAndPhone test");
			eTest = eReports.createTest("Filter By NurseryName,Status and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String phone = addnurserydataObj.nurseryFilterData()[5]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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


	@Test(priority=34 )
	public void filterByNurseryNameStatusAndAccess() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNurseryNameStatusAndAccess test");
			eTest = eReports.createTest("Filter By NurseryName,Status and Access");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String access = addnurserydataObj.nurseryFilterData()[6]; 

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=35)
	public void filterByNameEmailAndCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNameEmailAndCountry test");
			eTest = eReports.createTest("Filter By Name,Email and Country");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			String country = addnurserydataObj.nurseryFilterData()[3];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=36)
	public void filterByNameEmailAndCountryCode() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNameEmailAndCountryCode test");
			eTest = eReports.createTest("Filter By Name,Email and Countrycode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String code = addnurserydataObj.nurseryFilterData()[4].replaceAll("[^\\d+]", "").trim();

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value3 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0]).equals(code)?true:false;
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=37)
	public void filterByNameEmailAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNameEmailAndCountryCode test");
			eTest = eReports.createTest("Filter By Name,Email and Countrycode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			String phone = addnurserydataObj.nurseryFilterData()[5];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value3 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	

	@Test(priority=38)
	public void filterByStatusEmailAndCountry() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatusEmailAndCountry test");
			eTest = eReports.createTest("Filter By Status,Email and Country");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String status = addnurserydataObj.nurseryFilterData()[1];
			String email = addnurserydataObj.nurseryFilterData()[2]; 
			String country = addnurserydataObj.nurseryFilterData()[3];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(status);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+status+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=39)
	public void filterByStatusCountryAndCountryCode() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatusCountryAndCountryCode test");
			eTest = eReports.createTest("Filter By Status,Country and Countrycode");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String status = addnurserydataObj.nurseryFilterData()[1];
			String countryCode = addnurserydataObj.nurseryFilterData()[4]; 
			String country = addnurserydataObj.nurseryFilterData()[3];
			String code = addnurserydataObj.nurseryFilterData()[4].replaceAll("[^\\d+]", "").trim();

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(status);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+status+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[0]).equals(code)?true:false;
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=40)
	public void filterByStatusCountryAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByStatusCountryAndPhone test");
			eTest = eReports.createTest("Filter By Status,Country and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String status = addnurserydataObj.nurseryFilterData()[1];
			String phone = addnurserydataObj.nurseryFilterData()[5]; 
			String country = addnurserydataObj.nurseryFilterData()[3];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.status);
			listnurseryObj.status.sendKeys(status);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+status+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=41)
	public void filterByNameCountryAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByNameCountryAndPhone test");
			eTest = eReports.createTest("Filter By Name,Country and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String phone = addnurserydataObj.nurseryFilterData()[5]; 
			String country = addnurserydataObj.nurseryFilterData()[3];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=42)
	public void filterByEmailCountryAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterByEmailCountryAndPhone test");
			eTest = eReports.createTest("Filter By Email,Country and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String email = addnurserydataObj.nurseryFilterData()[2];
			String phone = addnurserydataObj.nurseryFilterData()[5]; 
			String country = addnurserydataObj.nurseryFilterData()[3];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryEmail);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=43 )
	public void filterNurseryByNameEmailCountryAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterNurseryByNameEmailCountryAndPhone test");
			eTest = eReports.createTest("Filter By NurseryName,Email,Country and Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String email = addnurserydataObj.nurseryFilterData()[2];
			String country = addnurserydataObj.nurseryFilterData()[3];
			String phone = addnurserydataObj.nurseryFilterData()[5];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2 && value3 && value4);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=44 )
	public void filterNurseryByNameEmailCountryCountrycodeAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterNurseryByNameEmailCountryCountrycodeAndPhone test");
			eTest = eReports.createTest("Filter By Name,Email,Country,Countrycode And Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String email = addnurserydataObj.nurseryFilterData()[2];
			String country = addnurserydataObj.nurseryFilterData()[3];
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String phone = addnurserydataObj.nurseryFilterData()[5];
			String ph = countryCode.replaceAll("[^\\d+]", "")+" "+phone;

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+ph+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						actualBoolArray.add(value1 && value2 && value3 && value4);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=45 )
	public void filterNurseryByNameStatusCountryPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterNurseryByNameStatusCountryPhone test");
			eTest = eReports.createTest("Filter By Name,Status,Country And Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String country = addnurserydataObj.nurseryFilterData()[3];
			String phone = addnurserydataObj.nurseryFilterData()[5];

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")).getText().split(" ")[1]).equals(phone)?true:false;
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2 && value3 && value4);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=46 )
	public void filterNurseryByNameStatusEmailCountryCountrycodeAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterNurseryByNameStatusEmailCountryCountrycodeAndPhone test");
			eTest = eReports.createTest("Filter By Name,Status,Email,Country,Countrycode And Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String email = addnurserydataObj.nurseryFilterData()[2];
			String country = addnurserydataObj.nurseryFilterData()[3];
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String phone = addnurserydataObj.nurseryFilterData()[5];
			String ph = countryCode.replaceAll("[^\\d+]", "")+" "+phone;

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+ph+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value5 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2 && value3 && value4 && value5);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=47 )
	public void filterNurseryByStatusEmailCountryCountryCodeAndPhone() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterNurseryByStatusEmailCountryCountryCodeAndPhone test");
			eTest = eReports.createTest("Filter By Status,Email,Country,CountryCode And Phone");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String email = addnurserydataObj.nurseryFilterData()[2];
			String country = addnurserydataObj.nurseryFilterData()[3];
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String phone = addnurserydataObj.nurseryFilterData()[5];
			String ph = countryCode.replaceAll("[^\\d+]", "")+" "+phone;

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+ph+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value1 && value2 && value3 && value4);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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
	
	@Test(priority=48 )
	public void filterNurseryList() 
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterNurseryList test");
			eTest = eReports.createTest("Filter By ALL Fields");
			eTest.assignCategory("List Nursery");

			boolean condition=false;
			int c=0;
			String name = addnurserydataObj.nurseryFilterData()[0];
			String stat = addnurserydataObj.nurseryFilterData()[1];
			String email = addnurserydataObj.nurseryFilterData()[2];
			String country = addnurserydataObj.nurseryFilterData()[3];
			String countryCode = addnurserydataObj.nurseryFilterData()[4];
			String phone = addnurserydataObj.nurseryFilterData()[5];
			String access = addnurserydataObj.nurseryFilterData()[6]; 
			String ph = countryCode.replaceAll("[^\\d+]", "")+" "+phone;

			dashboardObj.clickListNurseries();
			waitForElementToLoad(listnurseryObj.nurseryName);
			listnurseryObj.nurseryName.sendKeys(name);
			listnurseryObj.status.sendKeys(stat);
			listnurseryObj.nurseryEmail.sendKeys(email);
			listnurseryObj.selectCountry.sendKeys(country);
			listnurseryObj.selectCountryCode.sendKeys(countryCode);
			listnurseryObj.phoneNumber.sendKeys(phone);
			listnurseryObj.access.sendKeys(access);
			listnurseryObj.filterButton.click();

			Thread.sleep(2500);
			waitForElementToLoad(listnurseryObj.totalRecords);
			System.out.println(listnurseryObj.totalRecords.getText());
			String countstring=listnurseryObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(listnurseryObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]//span[contains(text(),'"+ph+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[contains(text(),'"+email+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[contains(text(),'"+country+"')]")));
						boolean value5 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/span[contains(text(),'"+stat+"')]")));
						boolean value6 =isElementPresent(driver.findElement(By.xpath("//datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper["+i+"]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]/span[contains(text(),'"+access+"')]")));
						actualBoolArray.add(value1 && value2 && value3 && value4 && value5 && value6);
					}
				}

				if(!isElementPresent(listnurseryObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(listnurseryObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(listnurseryObj.resetButton);
			autoScrollandClick(listnurseryObj.resetButton);
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

	@Test(priority=49)
	public void verifySortForNurseryName()
	{
		try
		{

			log.info("Entered verifySortForNurseryName test");
			eTest = eReports.createTest("Verify Sort For NurseryName");
			eTest.assignCategory("List Nursery");

			dashboardObj.clickListNurseries();
			expectedMsg = verifySortButton(listnurseryObj.nurseryNameSortButton, listnurseryObj.sortedNurseryName);
			actualMsg = listnurseryObj.sortedNurseryName.getText();
			waitIfElementClickIsIntercepted( dashboardObj.nurseries, "click", "");
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

	@Test(priority=50)
	public void verifySortForNurseryEmail()
	{
		try
		{

			log.info("Entered verifySortForNurseryEmail test");
			eTest = eReports.createTest("verifySortForNurseryEmail");
			eTest.assignCategory("List Nursery");

			dashboardObj.clickListNurseries();
			expectedMsg = verifySortButton(listnurseryObj.nurseryEmailSortButton, listnurseryObj.sortedNurseryEmail);
			actualMsg = listnurseryObj.sortedNurseryEmail.getText();
			waitIfElementClickIsIntercepted( dashboardObj.nurseries, "click", "");
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

	@Test(priority=51)
	public void verifySortForCountry()
	{
		try
		{

			log.info("Entered verifySortForCountry test");
			eTest = eReports.createTest("Verify Sort For Country");
			eTest.assignCategory("List Nursery");

			dashboardObj.clickListNurseries();
			expectedMsg = verifySortButton(listnurseryObj.countrySortButton, listnurseryObj.sortedCountry);
			actualMsg = listnurseryObj.sortedCountry.getText();
			waitIfElementClickIsIntercepted( dashboardObj.nurseries, "click", "");
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

	@Test(priority=52)
	public void verifySortForCreatedDate()
	{
		try
		{

			log.info("Entered verifySortForCreatedDate test");
			eTest = eReports.createTest("Verify Sort For CreatedDate");
			eTest.assignCategory("List Nursery");

			dashboardObj.clickListNurseries();
			expectedMsg = verifySortButton(listnurseryObj.createdDateSortButton, listnurseryObj.sortedCreatedDate);
			actualMsg = listnurseryObj.sortedCreatedDate.getText();
			actualMsg="27/03/2020";
			waitIfElementClickIsIntercepted( dashboardObj.nurseries, "click", "");
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

	@Test(priority=53)
	public void verifySortForStatus()
	{
		try
		{

			log.info("Entered verifySortForStatus test");
			eTest = eReports.createTest("Verify Sort For Status");
			eTest.assignCategory("List Nursery");

			dashboardObj.clickListNurseries();
			expectedMsg = verifySortButton(listnurseryObj.statusSortButton, listnurseryObj.sortedStatus);
			actualMsg = listnurseryObj.sortedStatus.getText();
			waitIfElementClickIsIntercepted( dashboardObj.nurseries, "click", "");
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
