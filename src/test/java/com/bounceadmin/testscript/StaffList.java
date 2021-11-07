package com.bounceadmin.testscript;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.AddStaffObject;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.StaffListObject;
import com.bounceadmin.objectrepository.ViewStaffObject;
import com.bounceadmin.testdata.AddStaffData;
import com.bounceadmin.testdata.TestDataImport;

public class StaffList extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	TestDataImport tdImport;
	AddStaffObject addstaffObj;
	AddStaffData addstaffdataObj;
	StaffListObject stafflistObj;
	ViewStaffObject viewstaffObj;
	String[] staffData;
	String[] testData,roles;

	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			tdImport = new TestDataImport();
			addstaffObj = new AddStaffObject(driver);
			addstaffdataObj = new AddStaffData();
			stafflistObj = new StaffListObject(driver);
			viewstaffObj = new ViewStaffObject(driver);

			tdImport.readSheet("AddStaff");

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
	public void listAndViewStaffDetails()
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered listAndViewStaffDetails test");
			eTest = eReports.createTest("List And View StaffDetails");
			eTest.assignCategory("List Staff");

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			staffData = addstaffdataObj.addStaffTestData();
			testData = addstaffdataObj.viewStaffData();
			for(int i=0;i<testData.length;i++)
			{
				System.out.println(testData[i]);
				expectedArraylist.add(testData[i]);
			}
			expectedArraylist.add("Testrole");
			expectedArraylist.add("Active");
			System.out.println(expectedArraylist);
			for(int i=0;i<staffData.length;i++)
			{
				System.out.println(staffData[i]);
			}
			String name = staffData[0]+" "+staffData[1]+" "+staffData[2];
			stafflistObj.staffFilter(name,staffData[3],"","");
			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.viewButton);
			autoScrollandClick(stafflistObj.viewButton);
			waitForElementToLoad(viewstaffObj.viewName);
			actualArraylist.add(viewstaffObj.viewName.getText());
			actualArraylist.add(viewstaffObj.viewphoneNumber.getText());
			actualArraylist.add(viewstaffObj.viewEmail.getText());
			actualArraylist.add(viewstaffObj.viewRole.getText());
			actualArraylist.add(viewstaffObj.viewStatus.getText());
			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualArraylist);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");
	}

	@Test(priority=2)
	public void deactivateStaff()
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered deactivateStaff test");
			eTest = eReports.createTest("Deactivate Staff");
			eTest.assignCategory("List Staff");

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			expectedArraylist.add("Darisni Employee has been deactivated");
			expectedArraylist.add("ACTIVATE");
			expectedArraylist.add("Inactive");

			staffData = addstaffdataObj.addStaffTestData();
			String name = staffData[0]+" "+staffData[1]+" "+staffData[2];
			stafflistObj.staffFilter(name,staffData[3],"","Bounce Admin");
			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.viewButton);
			autoScrollandClick(stafflistObj.viewButton);
			waitForElementToLoad(viewstaffObj.deactivateButton);
			viewstaffObj.deactivateButton.click();
			waitForElementToLoad(viewstaffObj.yesButton);
			viewstaffObj.yesButton.click();
			waitForElementToLoad(viewstaffObj.deactivateMsg);
			actualArraylist.add(viewstaffObj.deactivateMsg.getText());
			waitForElementToLoad(viewstaffObj.activateButton);
			actualArraylist.add(viewstaffObj.activateButton.getText());
			actualArraylist.add(viewstaffObj.viewStatus.getText());
			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualArraylist);
		System.out.println(expectedArraylist);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion Passed");
	}

	@Test(priority=3)
	public void activateStaff()
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered deactivateStaff test");
			eTest = eReports.createTest("Activate Staff");
			eTest.assignCategory("List Staff");

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			expectedArraylist.add("Darisni Employee has been activated");
			expectedArraylist.add("DEACTIVATE");
			expectedArraylist.add("Active");

			staffData = addstaffdataObj.addStaffTestData();
			String name = staffData[0]+" "+staffData[1]+" "+staffData[2];
			stafflistObj.staffFilter(name,staffData[3],"","Bounce Admin");
			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.viewButton);
			autoScrollandClick(stafflistObj.viewButton);
			waitForElementToLoad(viewstaffObj.activateButton);
			viewstaffObj.activateButton.click();
			waitForElementToLoad(viewstaffObj.yesButton);
			viewstaffObj.yesButton.click();
			waitForElementToLoad(viewstaffObj.activateMsg);
			actualArraylist.add(viewstaffObj.activateMsg.getText());
			waitForElementToLoad(viewstaffObj.deactivateButton);
			actualArraylist.add(viewstaffObj.deactivateButton.getText());
			actualArraylist.add(viewstaffObj.viewStatus.getText());
			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualArraylist);
		System.out.println(expectedArraylist);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion Passed");
	}
	
	@Test(priority=4)
	public void verifyMultiRolesForSingleName() //verify multi roles assigned to a single staff
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered verifyMultiRolesForSingleName test");
			eTest = eReports.createTest("Verify Multi Roles For Single Staff");
			eTest.assignCategory("List Staff");

			String name = addstaffdataObj.viewStaffData()[0];
			String  email = addstaffdataObj.viewStaffData()[2];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.email.sendKeys(email);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			roles = addstaffdataObj.staffRoles();
			Arrays.sort(roles);
			expectedArray = roles;

			for(int i =1;i<=count;i++)
			{
				if(isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]"))))
				{
					String value = driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]")).getText();
					actualArraylist.add(value);
				}
			}

			actualArray = actualArraylist.toArray(new String[0]);
			Arrays.sort(actualArray);
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		Assert.assertEquals(actualArray, expectedArray);
		log.info("Assertion passed");
	}

	@Test(priority=5)
	public void filterStaffByName() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByName test");
			eTest = eReports.createTest("Filter Staff By Name");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String name = addstaffdataObj.staffFilterData()[0];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByEmail() //filter staff by email
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByEmail test");
			eTest = eReports.createTest("Filter Staff By Email");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String email = addstaffdataObj.staffFilterData()[1];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.email);
			stafflistObj.email.sendKeys(email);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//span[contains(text(),'"+email+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByStatus() //filter staff by status
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByStatus test");
			eTest = eReports.createTest("Filter Staff By Status");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String stat = addstaffdataObj.staffFilterData()[2];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.status);
			stafflistObj.status.sendKeys(stat);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'"+stat+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByRole() //filter staff by their role
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByRoleAsCustomersupport test");
			eTest = eReports.createTest("Filter Staff By Role");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String role = addstaffdataObj.staffFilterData()[3];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.listStaff, "click", "");

			waitForElementToLoad(stafflistObj.role);
			stafflistObj.role.sendKeys(role);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+role+"')]")));
						actualBoolArray.add(value);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByNameAndEmail() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByNameAndEmail test");
			eTest = eReports.createTest("Filter Staff By Name and Email");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String name = addstaffdataObj.staffFilterData()[0];
			String email = addstaffdataObj.staffFilterData()[1];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.email.sendKeys(email);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//span[contains(text(),'"+email+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByNameAndStatus() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByNameAndStatus test");
			eTest = eReports.createTest("Filter Staff By Name and Status");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String name = addstaffdataObj.staffFilterData()[0];
			String status = addstaffdataObj.staffFilterData()[2];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.status.sendKeys(status);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'"+status+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByNameAndRole() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByNameAndRole test");
			eTest = eReports.createTest("Filter Staff By Name and Role");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String name = addstaffdataObj.staffFilterData()[0];
			String role = addstaffdataObj.staffFilterData()[3];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.role.sendKeys(role);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+role+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByEmailAndStatus() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByEmailAndStatus test");
			eTest = eReports.createTest("Filter Staff By Email and Status");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String email = addstaffdataObj.staffFilterData()[1];
			String status = addstaffdataObj.staffFilterData()[2];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.email);
			stafflistObj.email.sendKeys(email);
			stafflistObj.status.sendKeys(status);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//span[contains(text(),'"+email+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'"+status+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByEmailAndRole() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByEmailAndRole test");
			eTest = eReports.createTest("Filter Staff By Email and Role");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String email = addstaffdataObj.staffFilterData()[1];
			String role = addstaffdataObj.staffFilterData()[3];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.email);
			stafflistObj.email.sendKeys(email);
			stafflistObj.role.sendKeys(role);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//span[contains(text(),'"+email+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+role+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByStatusAndRole() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByStatusAndRole test");
			eTest = eReports.createTest("Filter Staff By Status and Role");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String status = addstaffdataObj.staffFilterData()[2];
			String role = addstaffdataObj.staffFilterData()[3];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.status);
			stafflistObj.status.sendKeys(status);
			stafflistObj.role.sendKeys(role);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'"+status+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+role+"')]")));
						actualBoolArray.add(value1 && value2);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByNameEmailAndRole() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByNameEmailAndRole test");
			eTest = eReports.createTest("Filter Staff By Name, Email and Role");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String name = addstaffdataObj.staffFilterData()[0];
			String email = addstaffdataObj.staffFilterData()[1];
			String role = addstaffdataObj.staffFilterData()[3];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.email.sendKeys(email);
			stafflistObj.role.sendKeys(role);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//span[contains(text(),'"+email+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+role+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByNameEmailAndStatus() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByNameEmailAndStatus test");
			eTest = eReports.createTest("Filter Staff By Name, Status and Email");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String name = addstaffdataObj.staffFilterData()[0];
			String email = addstaffdataObj.staffFilterData()[1];
			String status = addstaffdataObj.staffFilterData()[2];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.email.sendKeys(email);
			stafflistObj.status.sendKeys(status);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//span[contains(text(),'"+email+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'"+status+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByEmailStatusAndRole() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByEmailStatusAndRole test");
			eTest = eReports.createTest("Filter Staff By Email, Status and Role");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String role = addstaffdataObj.staffFilterData()[3];
			String email = addstaffdataObj.staffFilterData()[1];
			String status = addstaffdataObj.staffFilterData()[2];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.email);
			stafflistObj.email.sendKeys(email);
			stafflistObj.status.sendKeys(status);
			stafflistObj.role.sendKeys(role);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+role+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//span[contains(text(),'"+email+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'"+status+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaffByNameStatusAndRole() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaffByNameStatusAndRole test");
			eTest = eReports.createTest("Filter Staff By Name, Status and Role");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String name = addstaffdataObj.staffFilterData()[0];
			String status = addstaffdataObj.staffFilterData()[2];
			String role = addstaffdataObj.staffFilterData()[3];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.status.sendKeys(status);
			stafflistObj.role.sendKeys(role);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'"+status+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+role+"')]")));
						actualBoolArray.add(value1 && value2 && value3);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void filterStaff() //filter staff by name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered filterStaff test");
			eTest = eReports.createTest("Filter Staff By All fields");
			eTest.assignCategory("List Staff");
			boolean condition=false;
			int c=0;
			String name = addstaffdataObj.staffFilterData()[0];
			String role = addstaffdataObj.staffFilterData()[3];
			String email = addstaffdataObj.staffFilterData()[1];
			String status = addstaffdataObj.staffFilterData()[2];

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();
			waitForElementToLoad(stafflistObj.name);
			stafflistObj.name.sendKeys(name);
			stafflistObj.email.sendKeys(email);
			stafflistObj.status.sendKeys(status);
			stafflistObj.role.sendKeys(role);
			stafflistObj.filterButton.click();

			Thread.sleep(2000);
			waitForElementToLoad(stafflistObj.totalRecords);
			System.out.println(stafflistObj.totalRecords.getText());
			String countstring=stafflistObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);

			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(stafflistObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value1 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[3]//div[contains(text(),'"+name+"')]")));
						boolean value2 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//span[contains(text(),'"+role+"')]")));
						boolean value3 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//span[contains(text(),'"+email+"')]")));
						boolean value4 =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[7]//span[contains(text(),'"+status+"')]")));
						actualBoolArray.add(value1 && value2 && value3 && value4);
					}
				}

				if(!isElementPresent(stafflistObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(stafflistObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(stafflistObj.resetButton);
			autoScrollandClick(stafflistObj.resetButton);
			autoScrollandClick(dashboardObj.staff);
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
	public void verifySortForName()
	{
		try
		{

			log.info("Entered verifySortForName test");
			eTest = eReports.createTest("Verify Sort For Name");
			eTest.assignCategory("List Staff");

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();

			expectedMsg = verifySortButton(stafflistObj.nameSortButton, stafflistObj.sortedName);
			actualMsg = stafflistObj.sortedName.getText();
			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
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
	public void verifySortForEmail()
	{
		try
		{

			log.info("Entered verifySortForEmail test");
			eTest = eReports.createTest("Verify Sort For Email");
			eTest.assignCategory("List Staff");

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();

			expectedMsg = verifySortButton(stafflistObj.emailSortButton, stafflistObj.sortedEmail);
			actualMsg = stafflistObj.sortedEmail.getText();
			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
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
	public void verifySortForStatus()
	{
		try
		{

			log.info("Entered verifySortForStatus test");
			eTest = eReports.createTest("Verify Sort For Status");
			eTest.assignCategory("List Staff");

			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
			dashboardObj.listStaff.click();

			expectedMsg = verifySortButton(stafflistObj.statusSortButton, stafflistObj.sortedStatus);
			actualMsg = stafflistObj.sortedStatus.getText();
			waitIfElementClickIsIntercepted(dashboardObj.staff, "click", "");
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
