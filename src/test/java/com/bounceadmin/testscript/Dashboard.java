package com.bounceadmin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;

public class Dashboard extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;

	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);

			loginObj.logIn("superadmin@darisni.me","Strongpassword1");
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
	public void verifyDashboardData() //verify all dashboard elements are present
	{
		try {
			log.info("Entered verifyDashboardData test");
			eTest = eReports.createTest("Verify Dashboard Data");
			eTest.assignCategory("DashBoard");	

			expectedArray = new String[4];
			expectedArray[0] = "Nurseries";
			expectedArray[1] = "Students";
			expectedArray[2] = "Parents";
			expectedArray[3] = "Employees";

			actualArray = new String[4];
			waitForElementToLoad(dashboardObj.nursery);
			actualArray[0] = dashboardObj.nursery.getText();
			actualArray[1] = dashboardObj.students.getText();
			actualArray[2] = dashboardObj.parents.getText();
			actualArray[3] = dashboardObj.employees.getText();

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		for(int i=0;i<actualArray.length;i++)
		{
			System.out.println(actualArray[i]);
		}
		Assert.assertEquals(actualArray, expectedArray);
		log.info("Assertion passed");
	}

	@Test(priority=2)
	public void switchToDarisniSuperAdmin() //verify all dashboard elements are present
	{
		try {
			log.info("Entered switchToDarisniSuperAdmin test");
			eTest = eReports.createTest("Switch To DarisniSuperAdmin");
			eTest.assignCategory("DashBoard");	

			expectedMsg = "Darisni Super Admin";
			waitForElementToLoad(dashboardObj.BounceAdmin);
			waitIfElementClickIsIntercepted(dashboardObj.currentRole, "click", "");
			waitForElementToLoad(dashboardObj.superAdmin);
			waitIfElementClickIsIntercepted(dashboardObj.superAdmin, "click", "");
			waitForElementToLoad(dashboardObj.DarisniSuperAdmin);
			actualMsg = dashboardObj.currentRole.getText();

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		log.info("Assertion passed");
	}

	@Test(priority=3)
	public void switchToBounceAdmin() //verify all dashboard elements are present
	{
		try {
			log.info("Entered switchToDarisniSuperAdmin test");
			eTest = eReports.createTest("Switch To BounceAdmin");
			eTest.assignCategory("DashBoard");	

			expectedMsg = "Bounce Admin";
			waitForElementToLoad(dashboardObj.DarisniSuperAdmin);
			waitIfElementClickIsIntercepted(dashboardObj.currentRole, "click", "");
			waitForElementToLoad(dashboardObj.Admin);
			waitIfElementClickIsIntercepted(dashboardObj.Admin, "click", "");
			waitForElementToLoad(dashboardObj.BounceAdmin);
			actualMsg = dashboardObj.currentRole.getText();

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		log.info("Assertion passed");
	}

	@AfterClass
	public void signout()
	{
		dashboardObj.logout();
	}
}
